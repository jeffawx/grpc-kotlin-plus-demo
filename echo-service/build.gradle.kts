import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

grpc {
    reactorInterface()
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions.freeCompilerArgs += "-opt-in=kotlin.RequiresOptIn"
    }
}
