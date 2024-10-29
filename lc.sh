#!/bin/bash

# Function to get non-empty user input
get_non_empty_input() {
    local prompt="$1"
    local input=""
    while [[ -z "$input" ]]; do
        read -p "$prompt" input
    done
    echo "$input"
}

# Get folder name and extension
name=$(get_non_empty_input "Folder name: ")
ext=$(get_non_empty_input "Extension name (e.g., java, go, etc.): ")

# Get clipboard content
clipboard_content=$(xclip -o -selection clipboard)

# Check if clipboard content is empty
if [[ -z "$clipboard_content" ]]; then
    echo "The clipboard is empty. Please copy some content to the clipboard and try again."
    exit 1
fi

# Create the folder if it doesn't exist
mkdir -p "$name"

# Create the output file with chosen extension
output_file="$name/Solution.$ext"
echo "$clipboard_content" > "$output_file"
echo "Clipboard content has been written to $output_file"

# Loop to add more files if requested
while true; do
    read -p "Do you have any other files to add? (y/n): " response
    if [[ "$response" == "y" ]]; then
        new_ext=$(get_non_empty_input "Extension name (e.g., java, go, etc.): ")
        new_file="$name/Solution.$new_ext"
        
        # Get clipboard content again
        clipboard_content=$(xclip -o -selection clipboard)
        
        if [[ -n "$clipboard_content" ]]; then
            echo "$clipboard_content" > "$new_file"
            echo "Clipboard content has been written to $new_file"
        else
            echo "The clipboard is empty. Please copy some content to the clipboard and try again."
        fi
    elif [[ "$response" == "n" ]]; then
        break
    else
        echo "Please answer 'y' or 'n'."
    fi
done

# Stage and commit changes
git add .
git commit -m "$name"
git push

# Success message
echo -e "\nChanges have been committed and pushed to the remote repository."
echo -e " _____ __ __ _____ __ __ __ __ _____ ____  "
echo -e "|  _  |  |  |   __|  |  |  |  |   __|    \ "
echo -e "|   __|  |  |__   |     |     |   __|  |  |"
echo -e "|__|  |_____|_____|__|__|__|__|_____|____/ "
echo -e "\n"

read -p "Press enter to exit"
