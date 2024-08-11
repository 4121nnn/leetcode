# PowerShell script to commit and push changes to a Git repository

# Prompt the user for a commit message
$commitMessage = Read-Host "Enter the commit message"

# Stage all changes
git add .

# Commit the changes with the provided message
git commit -m $commitMessage

# Push the changes to the remote repository
git push

# Inform the user
Write-Host "Changes have been committed and pushed to the remote repository."
