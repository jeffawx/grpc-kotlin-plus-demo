import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `java-library`
    id("com.airwallex.grpc-spring") version "1.2.7" apply false
}

group = "com.airwallex"
version = "0.0.1-SNAPSHOT"

allprojects {
    repositories {
        mavenLocal()
        maven("https://artistry.airwallex.com/repository/lib-release/libs-release-local")
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "com.airwallex.grpc-spring")

    java.sourceCompatibility = JavaVersion.VERSION_11

    tasks {
        withType<KotlinCompile> {
            kotlinOptions {
                freeCompilerArgs = listOf("-Xjsr305=strict")
                jvmTarget = "11"
            }
        }

        test {
            useJUnitPlatform()
        }
    }
}
