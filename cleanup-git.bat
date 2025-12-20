@echo off
REM Git Cleanup Script for Tromaya Studio Blog (Windows)
REM This script removes files that should be ignored from Git tracking

echo 🧹 Starting Git cleanup for Tromaya Studio Blog...

REM Remove backend build artifacts
echo 📦 Cleaning backend build artifacts...
git rm -r --cached backend/target/ 2>nul
git rm --cached backend/.mvn/wrapper/maven-wrapper.jar 2>nul

REM Remove frontend build artifacts and dependencies
echo 🎨 Cleaning frontend build artifacts...
git rm -r --cached app-ui/node_modules/ 2>nul
git rm -r --cached app-ui/dist/ 2>nul
git rm -r --cached app-ui/build/ 2>nul
git rm -r --cached app-ui/.next/ 2>nul
git rm -r --cached app-ui/out/ 2>nul

REM Remove IDE files
echo 💻 Cleaning IDE files...
git rm -r --cached backend/.idea/ 2>nul
git rm -r --cached app-ui/.idea/ 2>nul
git rm -r --cached backend/.vscode/ 2>nul
git rm -r --cached app-ui/.vscode/ 2>nul
git rm -r --cached .idea/ 2>nul
git rm -r --cached .vscode/ 2>nul

REM Remove specific IDE files
for /r %%i in (*.iml *.iws *.ipr) do (
    git rm --cached "%%i" 2>nul
)

REM Remove OS generated files
echo 🖥️ Cleaning OS generated files...
git rm --cached .DS_Store 2>nul
git rm --cached backend/.DS_Store 2>nul
git rm --cached app-ui/.DS_Store 2>nul
git rm --cached Thumbs.db 2>nul
git rm --cached backend/Thumbs.db 2>nul
git rm --cached app-ui/Thumbs.db 2>nul

REM Remove log files
echo 📝 Cleaning log files...
for /r %%i in (*.log) do (
    git rm --cached "%%i" 2>nul
)
git rm -r --cached backend/logs/ 2>nul
git rm -r --cached app-ui/logs/ 2>nul

REM Remove temporary files
echo 🗑️ Cleaning temporary files...
for /r %%i in (*.tmp *.swp) do (
    git rm --cached "%%i" 2>nul
)

REM Add updated files
echo ➕ Adding updated configuration files...
git add .gitignore 2>nul
git add backend/.gitignore 2>nul
git add app-ui/.gitignore 2>nul
git add README.md 2>nul

echo ✅ Git cleanup completed!
echo.
echo 📋 Next steps:
echo 1. Review the changes: git status
echo 2. Commit the changes: git commit -m "docs: Update documentation and improve .gitignore configuration"
echo 3. Push to repository: git push origin main

pause