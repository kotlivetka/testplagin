plugins {
    kotlin("jvm") version "1.5.31"
    id("xyz.jpenilla.run-paper") version "1.0.4"
    id("net.minecrell.plugin-yml.bukkit") version "0.5.0"
    id("com.github.johnrengelman.shadow") version "6.1.0"
}

group = "com.github.andreypfau"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://papermc.io/repo/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.17.1-R0.1-SNAPSHOT")
}

tasks {
    build {
        dependsOn(shadowJar)
    }
}

tasks {
    runServer {
        minecraftVersion("1.17.1")
    }
}

bukkit {
    main = "com.github.kotlivetka.testplugin.TestPlugin"
    apiVersion = "1.17"
}