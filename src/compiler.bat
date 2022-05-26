@echo off

REM set JAVA_8_HOME="C:\Program Files\Java\jdk1.8.0_281"
set JAR_PATH=../lib/sqlite-jdbc-3.7.2.jar;
set CLASS_PATH=-d ../bin -cp %JAR_PATH%
REM set CLASS_PATH=-d ../bin

REM %JAVA_8_HOME%\bin\javac.exe %CLASS_PATH% com/emrecellebi/Console.java
REM %JAVA_8_HOME%\bin\jar.exe cfvm ../Melek-Senturk.jar META-INF/MANIFEST.MF -C ../bin/ .

javac.exe %CLASS_PATH% com/emrecellebi/Console.java
jar.exe cfvm ../Melek-Senturk.jar META-INF/MANIFEST.MF -C ../bin/ .