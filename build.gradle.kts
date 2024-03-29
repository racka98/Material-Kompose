// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
    dependencies {
        // Leaving this plugin here so it can be automatically
        // updated by Android Studio
        classpath("com.android.tools.build:gradle:7.2.0")

        classpath(BuildPlugins.kotlin)
        classpath(BuildPlugins.composeDesktop)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven(url = "https://www.jitpack.io")
        maven(url = "https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven(url = "https://maven.pkg.jetbrains.space/public/p/kotlinx-coroutines/maven")
    }
}

task("clean", Delete::class) {
    delete(rootProject.buildDir)
}