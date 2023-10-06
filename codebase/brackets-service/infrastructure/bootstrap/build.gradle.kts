plugins {
    application
}

group = "ru.sber.beautifulcode"
version = "1.0"

repositories {
    mavenCentral()
}

application {
    mainClass.set("ru.sber.beautifulcode.infrastructure.bootstrap.Service")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

dependencies {
    implementation("ru.sber.beautifulcode.shared:api")
    implementation("ru.sber.beautifulcode.shared:application")
    implementation(project(":infrastructure:api"))
    implementation(project(":application"))
    implementation(project(":domain"))

    implementation("org.apache.tomcat.embed:tomcat-embed-core:10.1.7")
}

tasks.register<Jar>("uberJar") {
    archiveClassifier.set("uber")
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE

    manifest {
        attributes["Main-Class"] = application.mainClass
    }

    from(sourceSets.main.get().output)

    dependsOn(configurations.runtimeClasspath)
    from({
        configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
    })
}