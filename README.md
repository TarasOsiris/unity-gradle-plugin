# unity-gradle-plugin
Gradle Plugin to run Unity3d commads as gradle tasks

# Usage

```groovy
import com.tarasleskiv.gradle.unity.tasks.ExecuteUnityMethodTask

buildscript {
  repositories {
    maven {
      url "https://plugins.gradle.org/m2/"
    }
  }
  dependencies {
    classpath "gradle.plugin.com.tarasleskiv:unity-gradle-plugin:1.0.1"
  }
}

apply plugin: 'java'

allprojects {
  repositories {
    maven {
      url "https://plugins.gradle.org/m2/"
    }
  }
}

dependencies {
  compile group: 'gradle.plugin.com.tarasleskiv', name: 'unity-gradle-plugin', version: '1.0.1'
}

apply plugin: "com.tarasleskiv.gradle.unity"

unity {
  unityPath = '/Applications/Unity/Unity.app/Contents/MacOS/Unity'
  projectPath = 'yyy'
}

task testExecuteMethod(type: ExecuteUnityMethodTask) {
  methodName = 'SomeClass.SomeMethod'
}
```