pipeline {
    agent  {
        label 'dind-agent'
    }
    stages {

        stage('Build image') {
            steps {
                script {
                    app = docker.build("class-mino-01/kfimg")
                }
            }
        }
        
        stage("Push image to AR") {
            steps {
                script {
                    docker.withRegistry('https://asia.gcr.io', 'gcr:class-mino-01') {
                        app.push("${env.BUILD_NUMBER}")
                    }
                }
            }
        }

        stage('K8S Manifest Update') {

            steps {

                git credentialsId: 'XOXOT',
                    url: 'https://github.com/XOXOT/argoCD_yaml.git',
                    branch: 'main'

                sh "sed -i 's/store:.*\$/store:${env.BUILD_NUMBER}/g' kf-deployment/deployment.yaml"
                sh "git add kf-deployment/deployment.yaml"
                sh "git commit -m '[UPDATE] store ${env.BUILD_NUMBER} image versioning'"

                withCredentials([gitUsernamePassword(credentialsId: 'XOXOT')]) {
                    sh "git push -u origin main"
                }
            }
            post {
                    failure {
                    echo 'Update failure !'
                    }
                    success {
                    echo 'Update success !'
                    }
            }
        }


    }             

}

