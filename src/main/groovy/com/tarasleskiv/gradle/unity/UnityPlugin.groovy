package com.tarasleskiv.gradle.unity

import org.gradle.api.InvalidUserDataException
import org.gradle.api.Plugin
import org.gradle.api.Project

class UnityPlugin implements Plugin<Project> {
    void apply(Project project) {
        project.extensions.create("unity", UnityExtension)


        project.afterEvaluate {
            if (project.unity.unityPath == null) {
                throw new InvalidUserDataException("""Path to Unity not set, please specify 'unityPath' in 'unity' plugin config""")
            }

            if (project.unity.projectPath == null) {
                throw new InvalidUserDataException("""Path to Unity project not set, please specify 'unityPath' in 'unity' plugin config""")
            }
        }
    }
}