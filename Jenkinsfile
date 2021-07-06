pipeline {
    agent {
            docker {
                image 'maven:3.8.1-adoptopenjdk-11'
                args '-v /root/.m2:/root/.m2'
            }
        }
    stages {
        stage('Build test code') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }
        stage('Execute test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Generate allure report') {
            steps {
                script {
                    allure([
                            includeProperties: false,
                            jdk              : '',
                            properties       : [],
                            reportBuildPolicy: 'ALWAYS',
                            results          : [[path: 'target/allure-results']]
                    ])
                }
            }
        }
    }
}