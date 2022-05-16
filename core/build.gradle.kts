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
        implementation(compose.runtime)
        with(Dependencies.Kotlin) {
            implementation(dateTime)
        }
    }

    sourceSets["androidMain"].dependencies {

    }

    sourceSets["desktopMain"].dependencies {
        implementation(compose.desktop.currentOs)
        implementation(Dependencies.Log.slf4j)
    }
}