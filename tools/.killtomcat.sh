ps -ef | grep Dcatalina.base=/Users/userId/tomcat-7.0.55 | awk '{print $2}' | head -1 | xargs kill -9
