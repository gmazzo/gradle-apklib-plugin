package com.github.gmazzo.gradle.plugins.tasks

import org.gradle.api.file.FileCollection
import org.gradle.api.tasks.Exec
import org.gradle.api.tasks.InputFiles
import org.gradle.api.tasks.OutputFile

class DexFiles extends Exec {

    @InputFiles
    FileCollection inputFiles

    @OutputFile
    File outputFile

    @Override
    protected void exec() {
        def android = project.extensions['android']

        executable "${android.sdkDirectory}/build-tools/${android.buildToolsRevision}/dx"
        args(['--dex', '--verbose', "--output=$outputFile"] + inputFiles.files)

        super.exec()
    }

}
