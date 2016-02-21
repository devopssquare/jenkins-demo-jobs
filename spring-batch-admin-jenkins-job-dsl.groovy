String repository = 'spring-projects'
String project = 'spring-batch-admin'
List<String> branches = [
        'master',
//        '1.3.x'
]
branches.each {String branchName->
    def jobName = "${project}-${branchName}".replaceAll('/','-')
    job(jobName) {
        scm {
            git("git://github.com/${repository}/${project}.git", branchName)
        }
        steps {
            maven("clean test")
        }
    }
}