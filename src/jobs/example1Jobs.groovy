import groovy.json.JsonSlurper

List branches = ['master','devlop','release']

multibranchPipelineJob('Dsl') {
   branches.each { branch ->
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
