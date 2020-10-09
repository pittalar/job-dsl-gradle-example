String basePath = 'example1'
String repo = 'pittalar/spring-boot-data-H2-embedded'

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