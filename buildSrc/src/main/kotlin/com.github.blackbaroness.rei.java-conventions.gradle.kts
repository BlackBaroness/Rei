import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.checkerframework.gradle.plugin.CheckerFrameworkExtension

plugins {
    `java-library`
    id("io.freefair.lombok")
    id("com.github.johnrengelman.shadow")
    id("org.checkerframework")
}

repositories {
    mavenLocal()
    maven("https://repo.maven.apache.org/maven2/")
}

group = "com.github.blackbaroness.rei"
version = "0.1-SNAPSHOT"

final val javaVersion = JavaVersion.VERSION_17
java.sourceCompatibility = javaVersion
java.targetCompatibility = javaVersion

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}

tasks.withType<Javadoc>() {
    options.encoding = "UTF-8"
}

tasks.withType<ShadowJar> {
    exclude("META-INF/**", "OSGI-INF/**", "**/package-info.class")
}

configure<CheckerFrameworkExtension> {
    checkers = listOf(
        "org.checkerframework.checker.formatter.FormatterChecker",
        "org.checkerframework.checker.i18n.I18nChecker",
        "org.checkerframework.checker.i18nformatter.I18nFormatterChecker",
        "org.checkerframework.checker.index.IndexChecker",
        "org.checkerframework.checker.nullness.NullnessChecker",
        "org.checkerframework.checker.optional.OptionalChecker",
        "org.checkerframework.checker.regex.RegexChecker",
        "org.checkerframework.checker.resourceleak.ResourceLeakChecker",
        "org.checkerframework.checker.signature.SignatureChecker",
        "org.checkerframework.checker.units.UnitsChecker",
        "org.checkerframework.framework.util.PurityChecker"
    )
}
