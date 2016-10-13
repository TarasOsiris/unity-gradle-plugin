# unity-gradle-plugin
Gradle Plugin to run Unity3d commads as gradle tasks

# Usage

```
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

apply plugin: "com.tarasleskiv.gradle.unity"
```