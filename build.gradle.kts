import net.minecrell.pluginyml.bukkit.BukkitPluginDescription

plugins {
    kotlin("jvm")
    id("io.papermc.paperweight.userdev") version "1.1.12"
    id("xyz.jpenilla.run-paper") version "1.0.4"
    id("net.minecrell.plugin-yml.bukkit") version "0.5.0"
}

group = "com.github.andreypfau"
version = "1.0.0-SNAPSHOT"

dependencies {
    paperDevBundle("1.17.1-R0.1-SNAPSHOT")
}

tasks {
    build {
        dependsOn(reobfJar)
    }
}

bukkit {
    main = "com.github.andreypfau.testplugin.TestPlugin"
    apiVersion = "1.17"
}