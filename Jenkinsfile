pipeline {
    agent any
    tools {
        jdk 'JDK 17.0.9'        // Ensure this matches the name you used for JDK configuration in Jenkins
        maven 'Maven 3.9.6'      // Ensure this matches the name you used for Maven configuration in Jenkins
    }
    stages {
        stage('Checkout') {
            steps {
                // Clone the project repository
                git 'https://github.com/Oumayma-Rml/Project-Crud-Jenkins.git'
            }
        }
        stage('Build WAR') {
            steps {
                // Build the application WAR using Maven
                sh 'mvn package -DskipTests'
            }
        }
        stage('Docker Build') {
            steps {
                // Build a Docker image for the Spring Boot application
                sh 'docker build -t crud .'
            }
        }
        stage('Push Docker Image') {
            steps {
                script {
                    // Using DockerHub credentials to authenticate before pushing the image
                    docker.withRegistry('https://index.docker.io/v1/', 'docker-hub-omayma9948-id') {
                        // Tag the image
                        sh 'docker tag crud omayma9948/crud:latest'
                        // Push the image to DockerHub
                        sh 'docker push omayma9948/crud:latest'
                    }
                }
            }
        }
        stage('Deploy') {
            steps {
                // Run the container (optional deployment step for testing locally)
                sh 'docker run -d -p 8080:8080 crud'
            }
        }
    }
    post {
        always {
            // Clean up workspace after the pipeline
            cleanWs()
        }
    }
}
