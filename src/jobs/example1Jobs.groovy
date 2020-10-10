multibranchPipelineJob('Dsl') {
    branchSources {
        git {
            remote('https://github.com/pittalar/simplespringboot.git')
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
    }
}
