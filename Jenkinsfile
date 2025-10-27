pipeline {
    agent any

    environment {
        DOCKER_HUB_USER = 'aligthage'
        IMAGE_NAME = 'java-hello'
    }

    stages {
        stage('Clone Code') {
            steps {
                echo "=== 🧬 Stage 1: Cloning Repository ==="
                git branch: 'main', url: 'https://github.com/AgeCoder/java-hello.git'
                echo "✅ Repository cloned successfully from https://github.com/AgeCoder/java-hello.git"
            }
        }

        stage('Build Docker Image') {
            steps {
                echo "=== 🏗️ Stage 2: Building Docker Image ==="
                script {
                    bat """
                    echo Building Docker image: %DOCKER_HUB_USER%/%IMAGE_NAME%:latest
                    docker build -t %DOCKER_HUB_USER%/%IMAGE_NAME%:latest .
                    """
                }
                echo "✅ Docker image built successfully."
            }
        }

        stage('Login to Docker Hub') {
            steps {
                echo "=== 🔐 Stage 3: Logging into Docker Hub ==="
                withCredentials([usernamePassword(credentialsId: 'dockerhub', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                    script {
                        bat """
                        echo Logging into Docker Hub as %DOCKER_USER%
                        echo %DOCKER_PASS% | docker login -u %DOCKER_USER% --password-stdin
                        """
                    }
                }
                echo "✅ Logged into Docker Hub successfully."
            }
        }

        stage('Push Image') {
            steps {
                echo "=== 🚀 Stage 4: Pushing Docker Image to Docker Hub ==="
                script {
                    bat """
                    echo Pushing Docker image: %DOCKER_HUB_USER%/%IMAGE_NAME%:latest
                    docker push %DOCKER_HUB_USER%/%IMAGE_NAME%:latest
                    """
                }
                echo "✅ Docker image pushed successfully to Docker Hub."
            }
        }
    }

    post {
        success {
            echo "🎉 Pipeline completed successfully! Image: ${DOCKER_HUB_USER}/${IMAGE_NAME}:latest"
        }
        failure {
            echo "❌ Pipeline failed! Check the logs above for errors."
        }
    }
}
