import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

tasks {
    withType<KotlinCompile> {
        kotlinOptions.freeCompilerArgs += "-opt-in=kotlin.RequiresOptIn"
    }
}
