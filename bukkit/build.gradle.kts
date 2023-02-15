plugins {
    id("com.github.blackbaroness.rei.java-conventions")
}

repositories {
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    implementation(project(":common"))
    testImplementation("com.github.seeseemelk:MockBukkit-v1.19:2.144.5")
    compileOnly("com.destroystokyo.paper:paper-api:1.12-R0.1-SNAPSHOT")
}
