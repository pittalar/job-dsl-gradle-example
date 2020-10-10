multibranchPipelineJob('Dsl') {
    branchSources {
        git {
            id('123456789') // IMPORTANT: use a constant and unique identifier
            remote('https://github.com/pittalar/simplespringboot.git')
        }
        branchSource {
            source {
                git {
                    id('987654321')
                    remote('https://github.com/pittalar/simplespringboot.git')    
                    extensions {
                        cleanBeforeCheckout()
                    }
                }  
            } 
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
    }
}
