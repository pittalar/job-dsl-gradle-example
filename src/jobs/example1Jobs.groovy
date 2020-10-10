pipelineJob('Your App Pipeline') { 

  def repo = 'https://github.com/pittalar/job-dsl-gradle-example.git' 
 
  description("Your App Pipeline") 
  keepDependencies(false) 

  properties{ 

    githubProjectUrl (repo) 
    rebuild { 
      autoRebuild(false) 
    } 
  } 

  definition { 

    cpsScm { 
      scm { 
        git { 
          remote { url(repo) } 
          branches('master') 
          scriptPath('Jenkinsfile') 
          extensions { }  // required as otherwise it may try to tag the repo, which you may not want 
        } 
      } 
    } 
  }