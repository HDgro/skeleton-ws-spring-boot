node {
    // Jenkins 파일에서 취급하는 파라미터들을 미리 정의한다.
    // 아래와 같이 미리 정의하면 Jenkins Job 이 Parametrized Job 이 되며 기본 변수들이 들어가게 된다
    properties([[
        $class: 'ParametersDefinitionProperty', parameterDefinitions:
            [
                [$class: 'BooleanParameterDefinition', defaultValue: false, description: '테스트를 Skip 할 수 있습니다. 선택 시 테스트를 건너뛰고 체크아웃 - 빌드 - 아카이빙만 진행합니다', name: 'skipTests']
                , [$class: 'StringParameterDefinition', defaultValue: 'development', description: 'Maven에서 Active 할 Profile 을 입력하세요. 예) production', name: 'activeProfile']
            ]
        ]])

    def mvnHome

    stage('Preparation') { // for display purposes
        echo "Current workspace : ${workspace}"
    }
    stage('Checkout') {
        // Get some code from a Git repository
        checkout scm
    }
    if (skipTests != true) {
        stage('Test') {
        }
        stage('Store Test Results') {
        }
    }
    stage('Build') {
    }
    stage('Archive') {
    }
    stage('Deploy') {
    }
}
