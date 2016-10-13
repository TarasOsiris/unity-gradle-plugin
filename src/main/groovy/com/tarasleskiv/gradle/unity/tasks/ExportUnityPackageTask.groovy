package im.getsocial.gradle.unity.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.InvalidUserDataException
import org.gradle.api.tasks.TaskAction

class ExportUnityPackageTask extends DefaultTask {
    String unityPath
    String projectPath
    String logFile

    String packageName
    List<String> exportAssetFolders
    String outputDir

    ExportUnityPackageTask() {
        super()
        this.group = 'Unity'
        this.description = 'Executes Unity in batch mode and exports .unitypackage'
    }

    @TaskAction
    def unityAction() {
        if (unityPath == null) {
            unityPath = project.unity.unityPath
        }

        if (projectPath == null) {
            projectPath = project.unity.projectPath
        }

        if (packageName == null || packageName.isEmpty()) {
            throw new InvalidUserDataException('Unity packageName cannot be null or empty')
        }

        if (outputDir == null || outputDir.isEmpty()) {
            throw new InvalidUserDataException('Output directory cannot be null or empty')
        }

        def unityCommandLine = [unityPath, '-batchmode', '-quit',
                                '-projectPath', projectPath, '-exportPackage']
        exportAssetFolders.each { unityCommandLine << it }
        unityCommandLine << "$outputDir/$packageName"

        if (logFile && !logFile.isEmpty()) {
            unityCommandLine << '-logFile' << logFile
        }

        println('Executing Unity commands line: ' + unityCommandLine.join(' '));

        project.exec {
            commandLine unityCommandLine
        }
    }
}
