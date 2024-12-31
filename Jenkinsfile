pipeline {
    agent any
    tools {
        // Specify Java and Maven tools (configure these in Jenkins Global Tool Configuration)
        jdk 'JDK17'          // Replace with the name of the JDK configured in Jenkins
        maven 'Maven3.9.6'   // Replace with the name of the Maven configured in Jenkins
    }
    stages {
        stage('Checkout') {
            steps {
                // Clone the project repository (optional if it's on your local machine)
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
                    // Using the DockerHub credentials to authenticate before pushing the image
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
