#!/bin/bash

$MAVEN_HOME/bin/mvn clean verify
mkdir /build
cp /opt/app/target/*-fat.jar /build/

exec $@