import groovy.json.JsonSlurper

List branches = ['master','devlop','release']

multibranchPipelineJob('Dsl') {
   branches.each { branch ->
        git {
            id('123456789') // IMPORTANT: use a constant and unique identifier
            remote('https://github.com/pittalar/simplespringboot.git')
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
