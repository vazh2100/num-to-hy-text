plugins {
    kotlin("jvm") version "2.1.0"
    `maven-publish`
}

group = "com.vazh2100"
version = "1.0.1"

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(17)
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
            groupId = "com.vazh2100"
            artifactId = "num-to-hy-text"
            version = version
        }
    }
}
