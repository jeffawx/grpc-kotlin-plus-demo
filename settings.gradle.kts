pluginManagement {
    repositories {
        mavenLocal()
//        maven("https://artistry.airwallex.com/repository/lib-release/libs-release-local")
        gradlePluginPortal()
    }
}

rootProject.name = "grpc-kotlin-plus-demo"

include("greeting", "greeting-web")
