multibranchPipelineJob('Dsl') {
    branchSource {
            source {
                git {
                    id('123456789')
                    remote('https://github.com/pittalar/simplespringboot.git')            
                }
                 extensions {
                    cleanBeforeCheckout()
                }
            } 
    }
    
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
    }
}
