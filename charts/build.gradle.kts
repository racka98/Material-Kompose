plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
}

android {
    compileSdk = AppConfig.compileSdkVersion

    defaultConfig {
        minSdk = AppConfig.minSdkVersion
        targetSdk = AppConfig.targetSdkVersion
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    sourceSets {
        named("main") {
            manifest.srcFile("src/androidMain/AndroidManifest.xml")
            res.srcDirs("src/androidMain/res")
        }
    }
}

kotlin {
    android()
    jvm("desktop") {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
    }

    sourceSets["commonMain"].dependencies {
        with(Dependencies.Kotlin) {
            implementation(dateTime)
        }
        implementation(compose.ui)
        implementation(compose.runtime)
        implementation(compose.foundation)
        implementation(compose.animation)
        @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
        implementation(compose.material3)
        implementation(compose.material)
    }

    sourceSets["androidMain"].dependencies {
        // Compose
        with(Dependencies.Android.Compose) {
            implementation(ui)
            implementation(preview)
        }
    }

    sourceSets["desktopMain"].dependencies {
        implementation(compose.preview)
        implementation(Dependencies.Log.slf4j)
    }
}
