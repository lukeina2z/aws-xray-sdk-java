#!/bin/sh

set -e
set -x

# ./gradlew build -Dorg.gradle.jvmargs="-XX:MaxMetaspaceSize=2096m"

# ./gradlew clean build -Dorg.gradle.jvmargs="-XX:MaxMetaspaceSize=2096m"

# ./gradlew assemble

# ./gradlew publishToMavenLocal


# Mac
/Users/lukezha/.gradle/wrapper/dists/gradle-7.4.2-bin/48ivgl02cpt2ed3fh9dbalvx8/gradle-7.4.2/bin/gradle \
     -Dorg.gradle.jvmargs="-XX:MaxMetaspaceSize=8000m" \
    rewriteRun --init-script ./init.gradle \
    -Drewrite.activeRecipes=software.amazon.awssdk.v2migration.AwsSdkJavaV1ToV2

# Linux
# /home/lukezha/.gradle/wrapper/dists/gradle-7.4.2-bin/48ivgl02cpt2ed3fh9dbalvx8/gradle-7.4.2 \
#     -Dorg.gradle.jvmargs="-XX:MaxMetaspaceSize=8000m" \
#     rewriteRun --init-script ./init.gradle \
#     -Drewrite.activeRecipes=software.amazon.awssdk.v2migration.AwsSdkJavaV1ToV2
