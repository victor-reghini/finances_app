pipeline {
  agent {
    node {
      label 'ubuntu linux docker jdk17'
    }

  }
  stages {
    stage('Checkout Code') {
      steps {
        git(url: 'https://github.com/victor-reghini/finances_app', branch: 'main')
      }
    }

  }
}