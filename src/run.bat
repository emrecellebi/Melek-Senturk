@echo off

REM set JAVA_8_HOME="C:\Program Files\Java\jdk1.8.0_281"
set JAR_PATH=../lib/sqlite-jdbc-3.7.2.jar;
set CLASS_PATH=-cp ../bin;%JAR_PATH%
REM set CLASS_PATH=-cp ../bin;

REM %JAVA_8_HOME%\bin\java.exe %CLASS_PATH% com.emrecellebi.Console %*
java.exe %CLASS_PATH% com.emrecellebi.Console %*