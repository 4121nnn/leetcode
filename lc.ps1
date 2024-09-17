do {
    $name = Read-Host "Folder name"
} while ([string]::IsNullOrWhiteSpace($name))

do {
    $ext = Read-Host "Extension name (e.g., java, go, etc.)"
} while ([string]::IsNullOrWhiteSpace($ext))

# Get the clipboard content
$clipboardContent = Get-Clipboard

if ([string]::IsNullOrWhiteSpace($clipboardContent)) {
    Write-Host "The clipboard is empty. Please copy some content to the clipboard and try again."
    exit
}

# Create the folder if it doesn't exist
if (-not (Test-Path -Path $name)) {
    New-Item -ItemType Directory -Path $name
}

# Create the output file name with the chosen extension
$output_file = "$name\Solution.$ext"

# Write the clipboard content to the file
Set-Content -Path $output_file -Value $clipboardContent

Write-Host "Clipboard content has been written to $output_file"

# Ask if there are any other files to add
$addMoreFiles = $true

while ($addMoreFiles) {
    $response = Read-Host "Do you have any other files to add? (y/n)"
    
    if ($response -eq 'y') {
        $newExt = Read-Host "Extension name (e.g., java, go, etc.)"
        $newFileName = "$name\Solution.$newExt"
        
        # Get the clipboard content again
        $clipboardContent = Get-Clipboard
        
        if (-not [string]::IsNullOrWhiteSpace($clipboardContent)) {
            # Write the clipboard content to the new file
            Set-Content -Path $newFileName -Value $clipboardContent
            Write-Host "Clipboard content has been written to $newFileName"
        } else {
            Write-Host "The clipboard is empty. Please copy some content to the clipboard and try again."
        }
    } elseif ($response -eq 'n') {
        $addMoreFiles = $false
    } else {
        Write-Host "Please answer 'y' or 'n'."
    }
}

# Stage all changes
git add .

# Commit the changes with the provided message
git commit -m $name

# Push the changes to the remote repository
git push

# Inform the user
Write-Host "Changes have been committed and pushed to the remote repository."
Write-Host @"
▒█▀▄░█▒█░▄▀▀░█▄█░█▄█▒██▀░█▀▄
░█▀▒░▀▄█▒▄██▒█▒█▒█▒█░█▄▄▒█▄▀
"@

 $exit = Read-Host "Press enter to exit"