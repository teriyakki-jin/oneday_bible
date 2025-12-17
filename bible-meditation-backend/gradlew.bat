\
    @echo off
    setlocal
    if not exist gradle\wrapper\gradle-wrapper.properties (
      echo [ERROR] Gradle wrapper files are missing.
      echo Tip: Open this folder as a Gradle project in IntelliJ, or run: gradle wrapper
      exit /b 1
    )
    java -jar gradle\wrapper\gradle-wrapper.jar %*
