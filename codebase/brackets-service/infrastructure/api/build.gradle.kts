plugins {
    java
}

group = "ru.sber.beautifulcode"
version = "1.0"

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

dependencies {
    implementation("ru.sber.beautifulcode.shared:api")
    implementation(project(":application"))

    implementation("org.json:json:20230618")
    compileOnly("jakarta.servlet:jakarta.servlet-api:6.0.0")
}
