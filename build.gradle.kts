plugins {
    kotlin("jvm") version "2.1.0"
}

group = "code.challenge.capital.gain"
version = "1.0-SNAPSHOT"

val kotestVersion: String by project

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("io.kotest:kotest-runner-junit5:${kotestVersion}")
    testImplementation("io.kotest:kotest-framework-datatest:${kotestVersion}")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}