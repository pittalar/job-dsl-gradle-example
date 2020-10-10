multibranchPipelineJob('Dsl') {
    branchSources {
        git {
            id('123456789')
            
            remote('https://github.com/pittalar/simplespringboot.git')
        }
    }
    extensions {
        cleanBeforeCheckout()
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
    }
}
