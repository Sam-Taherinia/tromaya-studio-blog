# Git Cleanup Commands for Tromaya Studio Blog

# These commands will help you clean up your repository and remove files that should be ignored

## 1. Remove files that are already tracked but should be ignored

# Remove backend build artifacts
git rm -r --cached backend/target/
git rm --cached backend/.mvn/wrapper/maven-wrapper.jar

# Remove frontend build artifacts and dependencies
git rm -r --cached app-ui/node_modules/
git rm -r --cached app-ui/dist/
git rm --cached app-ui/package-lock.json

# Remove IDE files
git rm -r --cached backend/.idea/
git rm -r --cached app-ui/.idea/
git rm -r --cached backend/.vscode/
git rm -r --cached app-ui/.vscode/
git rm --cached backend/*.iml
git rm --cached backend/*.iws
git rm --cached backend/*.ipr

# Remove OS generated files
git rm --cached .DS_Store
git rm --cached backend/.DS_Store
git rm --cached app-ui/.DS_Store
git rm --cached Thumbs.db
git rm --cached backend/Thumbs.db
git rm --cached app-ui/Thumbs.db

# Remove log files
git rm --cached backend/*.log
git rm --cached app-ui/*.log
git rm -r --cached backend/logs/
git rm -r --cached app-ui/logs/

# Remove temporary files
git rm --cached backend/*.tmp
git rm --cached app-ui/*.tmp
git rm --cached backend/*.swp
git rm --cached app-ui/*.swp

## 2. Add the updated .gitignore files
git add .gitignore
git add backend/.gitignore
git add app-ui/.gitignore

## 3. Add the new README.md
git add README.md

## 4. Commit the changes
git commit -m "docs: Update README.md and improve .gitignore configuration

- Add comprehensive project documentation
- Update .gitignore files for better file exclusion
- Remove tracked files that should be ignored
- Add root .gitignore for project-wide rules"

## 5. Push the changes
git push origin main

# Note: Some of these files might not exist in your repository, 
# so you might get "pathspec did not match any files" errors.
# This is normal and you can ignore those errors.

# Alternative: If you want to be more careful, check what files exist first:
# git ls-files | grep -E "(target/|node_modules/|\.idea/|\.vscode/|\.log$|\.tmp$)"