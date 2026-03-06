// pipeline {
//     agent any

//     environment {
//         DOCKER_IMAGE = "swayam614/scientific-calculator"
//         DOCKER_TAG = "latest"
//         DOCKER_PATH = "/usr/local/bin/docker"
//         DOCKER_CONFIG = "${WORKSPACE}/.docker"
//     }

//     stages {

//         stage('Prepare Docker Config') {
//             steps {
//                 sh 'mkdir -p $DOCKER_CONFIG'
//                 sh 'echo "{\\"auths\\":{}}" > $DOCKER_CONFIG/config.json'
//             }
//         }

//         stage('Build and Test with Maven') {
//             steps {
//                 sh '/opt/homebrew/bin/mvn clean package'
//             }
//         }

//         stage('Build Docker Image') {
//             steps {
//                 sh '$DOCKER_PATH build -t $DOCKER_IMAGE:$DOCKER_TAG .'
//             }
//         }

//         stage('Login to DockerHub') {
//             steps {
//                 withCredentials([usernamePassword(credentialsId: 'DockerHubCred',
//                                  usernameVariable: 'DOCKER_USER',
//                                  passwordVariable: 'DOCKER_PASS')]) {
//                     sh 'echo $DOCKER_PASS | $DOCKER_PATH login -u $DOCKER_USER --password-stdin'
//                 }
//             }
//         }

//         stage('Push Docker Image') {
//             steps {
//                 sh '$DOCKER_PATH push $DOCKER_IMAGE:$DOCKER_TAG'
//             }
//         }

//         stage('Deploy with Ansible') {
//             steps {
//                 sh '/opt/homebrew/bin/ansible-playbook -i ansible/hosts ansible/deploy.yml'
//             }
//         }
//     }
// }

pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "swayam614/scientific-calculator"
        DOCKER_TAG = "latest"
        DOCKER_PATH = "/usr/local/bin/docker"
        DOCKER_CONFIG = "${WORKSPACE}/.docker"
    }

    stages {

        stage('Prepare Docker Config') {
            steps {
                sh 'mkdir -p $DOCKER_CONFIG'
                sh 'echo "{\\"auths\\":{}}" > $DOCKER_CONFIG/config.json'
            }
        }

        stage('Build and Test with Maven') {
            steps {
                sh '/opt/homebrew/bin/mvn clean package'
            }
        }

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

        stage('Deploy with Ansible') {
            steps {
                sh '/opt/homebrew/bin/ansible-playbook -i ansible/hosts ansible/deploy.yml'
            }
        }
    }

    post {
        success {
            emailext(
                to: "swayampalrecha6@gmail.com",
                subject: "✅ SUCCESS: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """
Build Successful 🎉

Job Name: ${env.JOB_NAME}
Build Number: ${env.BUILD_NUMBER}
Build URL: ${env.BUILD_URL}

Docker Image: ${DOCKER_IMAGE}:${DOCKER_TAG}
Deployment: Completed via Ansible
""",
                attachLog: true
            )
        }

        failure {
            emailext(
                to: "swayampalrecha6@gmail.com",
                subject: "❌ FAILED: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """
Build Failed 🚨

Job Name: ${env.JOB_NAME}
Build Number: ${env.BUILD_NUMBER}
Build URL: ${env.BUILD_URL}

Check console logs for error details.
""",
                attachLog: true
            )
        }
    }
}