@echo off
mvn -B clean test package
exit /b %ERRORLEVEL%
