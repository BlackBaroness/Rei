plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

dependencies {
    implementation("io.freefair.gradle:lombok-plugin:6.6.1")
    implementation("gradle.plugin.com.github.johnrengelman:shadow:7.1.2")
}
