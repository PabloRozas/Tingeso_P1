pipeline{
    agent any
    tools{
        maven "maven"

    }
    stages{
        stage("Build JAR File"){
            steps{
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/PabloRozas/Tingeso_P1']])
                dir("proyect"){
                    bat "mvn clean"
                    bat "mvn -DskipTests package"
                }
            }
        }       
        stage("Build and Push Docker Image"){
            steps{
                dir("proyect"){
                    script{
                         withDockerRegistry(credentialsId: 'docker-credentials'){
                            bat "docker build -t pablomacuadarozas/backend:latest ."
                            bat "docker push pablomacuadarozas/backend:latest"
                        }
                    }                    
                }
            }
        }
    }
}