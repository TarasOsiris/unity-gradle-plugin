package com.tarasleskiv.gradle.unity.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.InvalidUserDataException
import org.gradle.api.tasks.TaskAction

class ExecuteUnityMethodTask extends DefaultTask {
	String unityPath
	String projectPath
	String logFile
	boolean quit = true

	String methodName
	List<String> extraArgs
	Map<String, String> extraKeyValueArgs

	ExecuteUnityMethodTask() {
		super()
		this.group = 'Unity'
		this.description = "Executes Unity in batch mode and executes specified method"
	}

	@TaskAction
	def unityAction() {
		if (unityPath == null) {
			unityPath = project.unity.unityPath
		}

		if (projectPath == null) {
			projectPath = project.unity.projectPath
		}

		if (methodName == null || methodName.isEmpty()) {
			throw new InvalidUserDataException('Unity method to execute cannot be null or empty')
		}

		def unityCommandLine = [unityPath, '-batchmode',
								'-projectPath', projectPath,
								'-executeMethod', methodName]
		if (quit) {
			unityCommandLine << '-quit'
		}

		if (logFile && !logFile.isEmpty()) {
			unityCommandLine << '-logFile' << logFile
		}

		extraArgs.each { unityCommandLine << it }
		extraKeyValueArgs.each { k, v ->
			unityCommandLine << "-$k=$v"
		}

		println('Executing Unity command line: ' + unityCommandLine.join(' '));

		project.exec {
			commandLine unityCommandLine
		}
	}
}
