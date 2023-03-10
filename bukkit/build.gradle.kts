plugins {
    id("com.github.blackbaroness.rei.java-conventions")
}

repositories {
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    implementation(project(":common"))
    compileOnly("com.destroystokyo.paper:paper-api:1.12-R0.1-SNAPSHOT")
}
