pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh '''
                    chmod +x gradlew
                    ./gradlew build -x test
                '''
            }
        }
        stage('DockerSize') {
            steps {
                sh '''
                    docker stop product || true
                    docker rm product || true
                    docker rmi product || true
                    docker build -t product .
                    echo "product: build success"
                '''
            }
        }
        stage('Deploy') {
            steps {
                sh '''
                docker run -e EUREKA_URL="${EUREKA_URL}" -e MASTER_DB_URL="${MASTER_DB_URL}/product" -e MASTER_DB_USERNAME="${MASTER_DB_USERNAME}" -e MASTER_DB_PASSWORD="${MASTER_DB_PASSWORD}" -d --name product --network gentledog product
                echo "product: run success"
                '''
                }
        }
    }
}