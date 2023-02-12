

plugins {
    id("com.github.blackbaroness.rei.java-conventions")
}

dependencies {
    implementation("space.arim.dazzleconf:dazzleconf-ext-snakeyaml:1.3.0-M1")
    implementation("com.google.inject:guice:5.1.0")
    implementation("it.unimi.dsi:fastutil:8.5.11")
    implementation("org.hibernate.orm:hibernate-core:6.2.0.CR2")
    implementation("org.hibernate.orm:hibernate-hikaricp:6.2.0.CR2")
}
