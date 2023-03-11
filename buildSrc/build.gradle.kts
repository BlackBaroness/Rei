plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

dependencies {
    implementation("io.freefair.gradle:lombok-plugin:6.6.3")
    implementation("gradle.plugin.com.github.johnrengelman:shadow:8.0.0")
    implementation("org.checkerframework:checkerframework-gradle-plugin:0.6.25")
}
