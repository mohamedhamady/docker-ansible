#!/bin/bash
set -e
#===============================================================================
#
#          FILE:  build.sh
# 
#         USAGE:  ./build.sh 
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
#       CREATED:  27.05.2017 12:11:12 CET
#      REVISION:  ---
#===============================================================================

if [ ! -f jdk-8u111-linux-x64.tar.gz ]; then
  wget --no-check-certificate --no-cookies --header "Cookie: oraclelicense=accept-securebackup-cookie"  http://download.oracle.com/otn-pub/java/jdk/8u111-b14/jdk-8u111-linux-x64.tar.gz
fi

if [ ! -f apache-maven-3.5.0-bin.tar.gz ]; then
    wget --no-check-certificate --no-cookies  http://www-us.apache.org/dist/maven/maven-3/3.5.0/binaries/apache-maven-3.5.0-bin.tar.gz
fi

docker build --rm -t local/java .
