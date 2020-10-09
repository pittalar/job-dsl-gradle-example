String basePath = 'example1'
String repo = 'pittalar/simplespringboot'

folder(basePath) {
    description 'This example shows basic folder/job creation.'
}

mavenJob('example') {
    logRotator(-1, 10)
    jdk('Java 8')
    scm {
        github(repo, 'master')
    }
    triggers {
        githubPush()
    }
    goals('clean install')
		
}

steps {
        dockerBuildAndPublish {
            repositoryName('rameshpi/simplespringboot')
            tag('${BUILD_TIMESTAMP}-${GIT_REVISION,length=7}')
            registryCredentials('7e899a8d-def3-486b-ab4f-7f0a62d76d05')
            forcePull(false)
            createFingerprints(false)
            skipDecorate()
        }
    }