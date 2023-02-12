import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    `java-library`
    id("io.freefair.lombok")
    id("com.github.johnrengelman.shadow")
}

repositories {
    mavenLocal()
    maven("https://repo.maven.apache.org/maven2/")
}

dependencies {
    compileOnly("org.jetbrains:annotations:24.0.0")
}

group = "com.github.blackbaroness.rei"
version = "0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}

tasks.withType<Javadoc>() {
    options.encoding = "UTF-8"
}

tasks.withType<ShadowJar> {
    exclude("META-INF/**", "OSGI-INF/**", "**/package-info.class")
}
