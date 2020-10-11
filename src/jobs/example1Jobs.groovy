multibranchPipelineJob('Dsl') {
    branchSources {
        git {
            id('123456789') // IMPORTANT: use a constant and unique identifier
            remote('https://github.com/pittalar/simplespringboot.git')
            includes("master develop release")
        }
        branchSource {
            source {
                git {
                    id('987654321')
                    remote('https://github.com/pittalar/simplespringboot.git')    
                    traits {
                        cleanBeforeCheckoutTrait {
                            extension {                            
                                deleteUntrackedNestedRepositories(true)
                            }
                        }
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
