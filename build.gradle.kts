plugins {
    java
    kotlin("jvm") version "1.3.72"
    maven
}

group = "com.jofairden"
version = "0.0.1-SNAPSHOT"

repositories {
    /**
     * Ensure you have at least these repositories
     */
    mavenCentral()
    jcenter()
    maven {
        name = "Github PKG"
        url = uri("https://maven.pkg.github.com/jofairden/discord.kt")
        credentials {
            /**
             * In order to access Github PKG, you need to enter your username and access token with the read:packages grant
             * To create a personal access token, go to: https://github.com/settings/tokens
             */
            username = System.getenv("MAVEN_PKG_GITHUB_ACTOR")
            password = System.getenv("MAVEN_PKG_GITHUB_TOKEN")
        }
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:1.3.3")
    testCompile("junit", "junit", "4.12")

    /**
     * Add Discord.Kt as a dependency
     */
    implementation("com.jofairden:discord.kt:0.0.1.2-SNAPSHOT")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}