#!/bin/sh

set -e
set -x

# ./gradlew build -Dorg.gradle.jvmargs="-XX:MaxMetaspaceSize=2096m"

./gradlew clean build -Dorg.gradle.jvmargs="-XX:MaxMetaspaceSize=2096m"

# ./gradlew assemble

# ./gradlew publishToMavenLocal

