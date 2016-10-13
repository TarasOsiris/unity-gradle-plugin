package com.tarasleskiv.gradle.unity

import org.gradle.api.Plugin
import org.gradle.api.Project

class UnityPlugin implements Plugin<Project> {
    void apply(Project project) {
        project.extensions.create("unity", UnityExtension)
    }
}