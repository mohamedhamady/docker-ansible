#!/bin/bash

set -e

#===============================================================================
#
#          FILE:  install-java.sh
# 
#         USAGE:  ./install-java.sh 
# 
#   DESCRIPTION:  
# 
#       OPTIONS:  ---
#  REQUIREMENTS:  ---
#          BUGS:  ---
#         NOTES:  ---
#        AUTHOR:  Hamady Mohamed (), mohamed.ouldhamady@gmail.com
#       COMPANY:  ---
#       VERSION:  1.0
#       CREATED:  27.05.2017 13:11:30 CET
#      REVISION:  ---
#===============================================================================

packages_dir=$(dirname $0)

echo "Available packages: $(ls -al $packages_dir)"

cd $packages_dir

tar -xzf apache-maven-3.5.0-bin.tar.gz
mv $packages_dir/apache-maven-3.5.0 /opt/
ln -sf /opt/apache-maven-3.5.0 /opt/maven

echo "export MAVEN_HOME=/opt/maven" >> /etc/profile
echo 'export PATH=$MAVEN_HOME/bin:$PATH' >> /etc/profile
. /etc/profile
mvn --version
