plugins {
    java
}

group = "ru.sber.beautifulcode.shared"

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

dependencies {
    compileOnly("jakarta.servlet:jakarta.servlet-api:6.0.0")
}
