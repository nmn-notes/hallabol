export JAVA_HOME=$(/usr/libexec/java_home)
export M2_HOME=/Users/userId/Installables/apache-maven-3.2.3/
export M2=$M2_HOME/bin
export PATH=$M2:$PATH
export PATH=/usr/local/mysql/bin:$PATH
export PATH=/usr/local/git/bin:$PATH

alias c='clear'
alias l='ls -lart'
alias m='mvn clean install'

alias pj='ps -ef | grep java'
alias killtomcat='sh ~/.killtomcat.sh'

alias myproject='cd ~/git_working/myproject'
alias tomcat='cd ~/tomcat-7.0.55'

alias visualvm='~/visualvm_138/bin/visualvm'

alias start-server='sh ~/tomcat-7.0.55/startServer.sh'
alias start-tomcat='cd ~/tomcat-7.0.55; ./bin/startup.sh; tail -f logs/catalina.out'

alias mysql-start='sudo /usr/local/mysql/support-files/mysql.server start'
alias mysql-stop='sudo /usr/local/mysql/support-files/mysql.server stop'

alias open-eclipse='/Applications/eclipse/eclipse &'

alias findAndGrep=findAndGrep

#keytool commands
alias keytool_list-certificate='keytool -printcert -v -file $1'
alias keytool_list-keystore='keytool -list -v -keystore $1'

export PATH="/opt/local/bin:/opt/local/sbin:$PATH"
# Finished adapting your PATH environment variable for use with MacPorts.

findAndGrep() {
    find . -name "$1" | xargs grep "$2"
}
