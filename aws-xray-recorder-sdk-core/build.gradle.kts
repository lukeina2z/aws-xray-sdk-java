import nebula.plugin.release.git.opinion.Strategies
import net.ltgt.gradle.errorprone.errorprone
import nl.javadude.gradle.plugins.license.LicenseExtension
import org.checkerframework.gradle.plugin.CheckerFrameworkExtension
import org.gradle.api.tasks.testing.logging.TestExceptionFormat

plugins {
    `java-library`
    `maven-publish`
    id("net.ltgt.errorprone")
}

dependencies {
    // api("com.amazonaws:aws-java-sdk-xray:1.12.767")
    // api("software.amazon.awssdk:apache-client:2.32.0")
    // api("software.amazon.awssdk:aws-core:2.32.0")
    // api("software.amazon.awssdk:xray:2.32.0")

    implementation("com.google.auto.value:auto-value-annotations:1.10.4")
    implementation("com.google.auto.service:auto-service-annotations:1.1.1")

    annotationProcessor("com.google.auto.service:auto-service:1.1.1")
    testImplementation("com.google.auto.service:auto-service:1.1.1")
    annotationProcessor("com.google.auto.value:auto-value:1.10.4")

    // annotationProcessor("com.google.errorprone:error_prone_core:2.4.0")
    // errorprone("com.google.errorprone:error_prone_core")

    annotationProcessor("com.google.errorprone:error_prone_core:2.24.1")
    errorprone("com.google.errorprone:error_prone_core:2.24.1")

    api("commons-logging:commons-logging:1.3.5")
    api("com.fasterxml.jackson.core:jackson-annotations:2.17.0")
    api("com.fasterxml.jackson.core:jackson-databind:2.17.0")
    api("org.apache.httpcomponents:httpclient:4.5.14")

    compileOnly("com.google.code.findbugs:jsr305:3.0.2")
    compileOnly("javax.servlet:javax.servlet-api:3.1.0")
    compileOnly("jakarta.servlet:jakarta.servlet-api:5.0.0")

    testImplementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")
    testImplementation("com.github.stefanbirkner:system-rules:1.16.0")
    testImplementation("com.github.tomakehurst:wiremock-jre8")
    testImplementation("org.openjdk.jmh:jmh-core:1.19")
    testImplementation("org.powermock:powermock-module-junit4:2.0.7")
    testImplementation("org.powermock:powermock-api-mockito2:2.0.7")
    testImplementation("org.skyscreamer:jsonassert:1.3.0")
    testImplementation("jakarta.servlet:jakarta.servlet-api:5.0.0")
}

tasks.jar {
    manifest {
        attributes("Automatic-Module-Name" to "com.amazonaws.xray.sdk_core")
    }
}


// tasks {
//     withType<JavaCompile> {
//         // options.compilerArgs.addAll(listOf(
//         //     "-Astubs=" // Disable checker framework
//         // ))

//         options.compilerArgs.addAll(listOf(
//             "-Asuppress=override.param.invalid"
//         ))

//         options.errorprone {
//             error(
//             )

//             disable(
//                 "EmptyBlockTag",
//                 "MissingSummary",
//                 "MissingOverride",
//                 "StringSplitter",
//                 "AutoValueImmutableFields"
//             )

//                         // Exclude generated sources
//             excludedPaths.set("./build/generated/.*")
//         }
//     }
// }


tasks {
    withType<JavaCompile> {
        options.compilerArgs.addAll(listOf(
            "-AskipDirs=${buildDir}/generated"
        ))
        
        options.errorprone {
            error(
            )

            disable(
                "EmptyBlockTag",
                "MissingSummary",
                "MissingOverride",
                "StringSplitter",
            )
        }
    }
}



description = "AWS X-Ray Recorder SDK for Java - Core"
