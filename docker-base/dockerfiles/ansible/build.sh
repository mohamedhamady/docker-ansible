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
#       CREATED:  27.05.2017 10:31:06 CET
#      REVISION:  ---
#===============================================================================

docker build --rm -t local/ansible .
