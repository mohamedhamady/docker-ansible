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

tar -xzf jdk-8u111-linux-x64.tar.gz
mv $packages_dir/jdk1.8.0_111 /opt/
ln -sf /opt/jdk1.8.0_111 /opt/jdk8

echo "export JAVA_HOME=/opt/jdk8" >> /etc/profile
echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile
. /etc/profile
java -version
