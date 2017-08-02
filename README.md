# MediaFormatter
Java调用ffmpeg工具的封装类

## dependencies for cloning
1. javaSE 
2. ffmpeg
3. maven building tool

## how to use
- cloning into your PC.
- downloading javaSE, ffmpeg, maven into your PC and setting their environments for executing.
```
JAVA_HOME=${the directory you install the jdk}
MAVEN_HOME=${the directory you install the maven /bin}
FFMPEG_HOME=${the directory you install the ffmpeg /bin}
```
- locate into the project folder, execute command [mvn install -Dmaven.test.skip=true]
- you will find the tar.gz package in /target/ 
- extract tar.gz package and execute command [./startup.bat], run the program