plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
    id("maven-publish")
}

android {
    compileSdk = AppConfig.compileSdkVersion

    defaultConfig {
        minSdk = AppConfig.minSdkVersion
        targetSdk = AppConfig.targetSdkVersion

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }
    packagingOptions {
        resources {
            excludes += mutableSetOf(
                "/META-INF/{AL2.0,LGPL2.1}",
                "META-INF/licenses/ASM"
            )
        }
    }

    sourceSets {
        named("main") {
            manifest.srcFile("src/androidMain/AndroidManifest.xml")
            res.srcDirs("src/androidMain/res")
        }
    }

    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
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

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("maven") {
                version = PublishConfig.version
                groupId = PublishConfig.groupId
                artifactId = "charts"

                from(components["release"])
            }
        }
    }
}
