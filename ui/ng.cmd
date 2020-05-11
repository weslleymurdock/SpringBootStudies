:: Created by murdock, please don't edit manually.
@ECHO OFF

SETLOCAL

SET "NODE_EXE=%~dp0\node.exe"
IF NOT EXIST "%NODE_EXE%" (
  SET "NODE_EXE=node"
)
echo "ng version by murdock"
SET "NG_JS=%~dp0\node_modules\@angular\cli\bin\ng"
::FOR /F "delims=" %%F IN ('CALL "%NODE_EXE%" "%NG_JS%" prefix ') DO (
::  SET "NPM_PREFIX_NG_JS=%%F\node_modules\@angular\cli\bin\ng.js"
::)
::IF EXIST "%NPM_PREFIX_NG_JS%" (
::  SET "NG_JS=%NPM_PREFIX_NG_JS%"
::)

"%NODE_EXE%" "%NG_JS%" %*