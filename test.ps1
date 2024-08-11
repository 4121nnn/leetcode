# PowerShell script to write clipboard content to a file with a chosen extension

# Prompt the user to enter the name for the file
do {
    $name = Read-Host "Enter the name"
} while ([string]::IsNullOrWhiteSpace($name))

# Prompt the user to enter the file extension (e.g., java, go, etc.)
do {
    $ext = Read-Host "Enter the file extension (e.g., java, go, etc.)"
} while ([string]::IsNullOrWhiteSpace($ext))

# Get the clipboard content
$clipboardContent = Get-Clipboard

# Check if clipboard content is empty
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

# Inform the user
Write-Host "Clipboard content has been written to $output_file"

# PowerShell script to commit and push changes to a Git repository


# Stage all changes
git add .

# Commit the changes with the provided message
git commit -m $name

# Push the changes to the remote repository
git push

# Inform the user
Write-Host "Changes have been committed and pushed to the remote repository."
