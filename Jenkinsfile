pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "swayam614/scientific-calculator"
        DOCKER_TAG = "latest"
        DOCKER_PATH = "/usr/local/bin/docker"
    }

    stages {

        stage('Build Docker Image') {
            steps {
                sh '$DOCKER_PATH build -t $DOCKER_IMAGE:$DOCKER_TAG .'
            }
        }

        stage('Login to DockerHub') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'DockerHubCred',
                                 usernameVariable: 'DOCKER_USER',
                                 passwordVariable: 'DOCKER_PASS')]) {
                    sh 'echo $DOCKER_PASS | $DOCKER_PATH login -u $DOCKER_USER --password-stdin'
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                sh '$DOCKER_PATH push $DOCKER_IMAGE:$DOCKER_TAG'
            }
        }
    }
}