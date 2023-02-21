plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

dependencies {
    implementation("io.freefair.gradle:lombok-plugin:6.6.2")
    implementation("gradle.plugin.com.github.johnrengelman:shadow:7.1.2")
    implementation("org.checkerframework:checkerframework-gradle-plugin:0.6.24")
}
