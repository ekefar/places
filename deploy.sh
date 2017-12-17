#!/bin/sh

cd ~/places-project/places
git pull
mvn clean install

killall java
rm -rf ~/tomcat/webapp/ROOT*
cp ~/places-project/places/webapp/target/webapp.war ~/tomcat/webapps/ROOT.war
sh ~/tomcat/bin/startup.sh