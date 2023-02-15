plugins {
    id("com.github.blackbaroness.rei.java-conventions")
}

repositories {
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    implementation(project(":common"))
    testImplementation("com.github.seeseemelk:MockBukkit-v1.19:2.29.0")
    compileOnly("com.destroystokyo.paper:paper-api:1.16.5-R0.1-SNAPSHOT")
}
