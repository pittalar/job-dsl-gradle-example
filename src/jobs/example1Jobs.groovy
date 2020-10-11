multibranchPipelineJob('Dsl') {
    branchSources {
        git {
            id('123456789') // IMPORTANT: use a constant and unique identifier
            remote('https://github.com/pittalar/spring-boot-data-H2-embedded.git')
            includes("master devlop release")
        }
        branchSource {
            source {
                git {
                    id('987654321')
                    remote('https://github.com/pittalar/spring-boot-data-H2-embedded.git')    
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
