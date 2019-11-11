MyApplication
==================
Android sample app with JaCoCo, espresso and [cpp with CMake](https://github.com/android/ndk-samples/tree/master/kotlin-app/hello-jni-kotlinApp).

Getting Started
==================
Run JaCoCo with Android Instrumented Test:
```
SET JAVA_HOME=D:\Android\Android Studio\jre
.\gradlew.bat createArm7DebugCoverageReport
```
* JUnit Report: app\build\reports\androidTests\connected\flavors\ARM7
* JaCoCo Report: app\build\reports\coverage\arm7\debug
