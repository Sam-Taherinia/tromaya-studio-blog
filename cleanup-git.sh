#!/bin/bash

# Git Cleanup Script for Tromaya Studio Blog
# This script removes files that should be ignored from Git tracking

echo "🧹 Starting Git cleanup for Tromaya Studio Blog..."

# Function to safely remove files from Git if they exist
safe_git_rm() {
    if git ls-files --error-unmatch "$1" >/dev/null 2>&1; then
        echo "Removing $1 from Git tracking..."
        git rm -r --cached "$1" 2>/dev/null || git rm --cached "$1" 2>/dev/null
    fi
}

# Remove backend build artifacts
echo "📦 Cleaning backend build artifacts..."
safe_git_rm "backend/target/"
safe_git_rm "backend/.mvn/wrapper/maven-wrapper.jar"

# Remove frontend build artifacts and dependencies
echo "🎨 Cleaning frontend build artifacts..."
safe_git_rm "app-ui/node_modules/"
safe_git_rm "app-ui/dist/"
safe_git_rm "app-ui/build/"
safe_git_rm "app-ui/.next/"
safe_git_rm "app-ui/out/"

# Remove IDE files
echo "💻 Cleaning IDE files..."
safe_git_rm "backend/.idea/"
safe_git_rm "app-ui/.idea/"
safe_git_rm "backend/.vscode/"
safe_git_rm "app-ui/.vscode/"
safe_git_rm ".idea/"
safe_git_rm ".vscode/"

# Remove specific IDE files
for ext in iml iws ipr; do
    git ls-files "*.${ext}" | while read file; do
        safe_git_rm "$file"
    done
done

# Remove OS generated files
echo "🖥️ Cleaning OS generated files..."
safe_git_rm ".DS_Store"
safe_git_rm "backend/.DS_Store"
safe_git_rm "app-ui/.DS_Store"
safe_git_rm "Thumbs.db"
safe_git_rm "backend/Thumbs.db"
safe_git_rm "app-ui/Thumbs.db"

# Remove log files
echo "📝 Cleaning log files..."
git ls-files "*.log" | while read file; do
    safe_git_rm "$file"
done
safe_git_rm "backend/logs/"
safe_git_rm "app-ui/logs/"

# Remove temporary files
echo "🗑️ Cleaning temporary files..."
for ext in tmp swp; do
    git ls-files "*.${ext}" | while read file; do
        safe_git_rm "$file"
    done
done

# Add updated files
echo "➕ Adding updated configuration files..."
git add .gitignore 2>/dev/null || echo "Root .gitignore not found"
git add backend/.gitignore 2>/dev/null || echo "Backend .gitignore not found"
git add app-ui/.gitignore 2>/dev/null || echo "Frontend .gitignore not found"
git add README.md 2>/dev/null || echo "README.md not found"

echo "✅ Git cleanup completed!"
echo ""
echo "📋 Next steps:"
echo "1. Review the changes: git status"
echo "2. Commit the changes: git commit -m 'docs: Update documentation and improve .gitignore configuration'"
echo "3. Push to repository: git push origin main"