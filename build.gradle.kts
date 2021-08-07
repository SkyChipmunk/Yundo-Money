import kr.heartpattern.spikotgradle.paperApi

plugins {
    kotlin("jvm") version "1.5.20"
    id("kr.heartpattern.spikot") version "4.0.7"
}

group = "kr.skychipmunk"
version = "1.0-SNAPSHOT"

repositories {
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://repo.heartpattern.io/repository/maven-public/")
    maven("https://jitpack.io")
}

dependencies {
    compileOnly("com.github.SkyChipmunk:Spikot:-SNAPSHOT")
    kapt("com.github.PeraSite:SpikotClassLocator:-SNAPSHOT")
    paperApi("1.12.2")
}

afterEvaluate {
    configurations.kapt.get().exclude("kr.heartpattern", "SpikotClassLocator")
}

