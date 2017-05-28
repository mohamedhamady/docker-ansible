#!/bin/bash

$MAVEN_HOME/bin/mvn clean verify || exit 1

exec $@