pipeline{
agent any
    stages{
	    stage('Build'){
		    steps{
			echo "Building"
		}
	}
	
	stage('Test'){
		step{
			catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE'){
				sh "mvn clean install"
			}
		}
	}
	
	stage('publish Allure Reports'){
		steps{
			script{
				allure([
				    includeProperties: false,
				    jdk: '',
				    properties: [],
				    reportBuildPolicy: 'ALWAYS',
				    results:[[path: '/allure-results']]
				])
			}
		}
	}
	
	stage('Publish Extent Report'){
		steps{
			publishHTML([allowMissing:false,
			            alwaysLinkToLastBuild: false,
						keepAll: false,
						reportDir: 'build',
						reportFiles: 'TestExecutionReport.html',
						reportName: 'HTML Extent Report',
						reportTitles: ''])
			}
		}
	}
}
