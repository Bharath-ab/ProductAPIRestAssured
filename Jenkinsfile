#!/usr/bin/env groovy

pipeline {
    agent any
    options {
        timestamps()
        ansiColor('xterm')
    }
    environment {
        SONARSERVER = 'SonarQube-9.9.1'
    }

    stages {
//        stage('Code Checkout') {
//            steps {
//                checkout scmGit(branches: [[name: '*/allureReport']], extensions: [], userRemoteConfigs: [[credentialsId: '35d7455e-af90-4528-99a7-fda6ad61a0a7', url: 'https://gitlab.com/Bharath-ab/productapirestassured.git']])
//            }
//        }

        stage('Provision Permissions') {
            steps {
                sh 'pwd'
                sh 'chmod 755 ../Phoenix-API-PipeLine'
            }
        }

        stage('Build Project') {
            steps {
                sh 'mvn clean compile test'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv("${SONARSERVER}") {
                    sh '''mvn clean verify sonar:sonar \\
                    -Dsonar.projectKey=Phoenix-API \\
                    -Dsonar.host.url=http://192.168.137.128:9000 \\
                    -Dsonar.login=sqp_b2d744380621bc5ef22a123475512251d3c729ca'''
                }
            }

        }

        stage('Publish Reports') {
            steps {
                allure includeProperties: false, jdk: '', results: [[path: 'allure-results']]
            }
        }

        stage('Stop Existing Containers') {
            steps {
                script {

//                    # stop running container(s)
                    sh 'docker ps -q --filter "name=phoenix" | xargs -r docker stop'
//                    # remove existing container(s)
                    sh 'docker ps -aq --filter "name=phoenix" | xargs -r docker rm'

//                    # removes docker images
                    sh 'docker image ls --format "{{.Repository}}:{{.Tag}}" | grep "phoenix" | xargs -r docker rmi'
                }
            }
        }

        stage('Create Docker Image') {
            steps {
                sh 'echo "Building Docker Image"'
                sh 'docker build . -t phoenixapitesting-${BUILD_NUMBER}'
            }
        }

        stage('Run Docker Container') {
            steps {
                sh 'echo "Running Docker image" '
                sh 'docker run -d --name phoenix-api phoenixapitesting-${BUILD_NUMBER}'
            }
        }

        stage('Tag Docker Image') {
            steps{
                sh 'docker tag "phoenixapitesting-${BUILD_NUMBER}:latest" jenkinsalerts455/phoenixapitesting:${BUILD_NUMBER}'
            }
        }

        stage('Push Docker Image') {
            steps{
//                in case getting un authorized error try this first time
//                sh 'docker login --username username --password password https://index.docker.io/v1/'
                sh 'docker push jenkinsalerts455/phoenixapitesting:${BUILD_NUMBER}'
            }
        }

        stage('Generate Email') {
            steps {
                sh 'echo "Generating Email Logs"'
            }
            post {
                always {
                    script {
//                    # removes docker images
                        sh 'docker image ls --format "{{.Repository}}:{{.Tag}}" | grep "phoenix" | xargs -r docker rmi -f'
                    }
                }
                success {
                    emailext attachLog: true, to: "bharath.varma@outlook.com", attachmentsPattern: '*.xml',
                            body: "${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n More info at: ${env.BUILD_URL}",
                            subject: "Jenkins Build ${currentBuild.currentResult}: Job ${env.JOB_NAME}"
                }
                failure {
                    emailext attachLog: true, to: "bharath.varma@outlook.com", attachmentsPattern: '*.xml',
                            body: "${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n More info at: ${env.BUILD_URL}",
                            subject: "Jenkins Build ${currentBuild.currentResult}: Job ${env.JOB_NAME}"
                }
            }
        }
    }

}
