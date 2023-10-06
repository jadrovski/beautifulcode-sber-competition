plugins {
    java
}

group = "ru.sber.beautifulcode.shared"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}