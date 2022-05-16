import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = AppConfig.compileSdkVersion
    namespace = AppConfig.nameSpace

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = AppConfig.minSdkVersion
        targetSdk = AppConfig.targetSdkVersion
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
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
            // Fixes conflicts caused by ByteBuddy library used in
            // coroutines-debug and mockito
            pickFirsts += mutableSetOf(
                "win32-x86-64/attach_hotspot_windows.dll",
                "win32-x86/attach_hotspot_windows.dll"
            )
        }
    }
}

dependencies {

    implementation(project(":core"))
    //implementation(project(":charts"))

    // Core Functionality
    with(Dependencies.Android.Essential) {
        implementation(coreKtx)
        implementation(appCompat)
        implementation(material)
        implementation(lifecycleRuntimeKtx)
    }

    // Testing
    with(Dependencies.Android.JUnit) {
        testImplementation(core)
        testImplementation(test)
        testImplementation(testExtKtx)
        androidTestImplementation(test)
    }

    with(Dependencies.Android.TestCore) {
        testImplementation(testArch)
        androidTestImplementation(testArch)
        androidTestImplementation(testKtx)
    }

    // Compose
    with(Dependencies.Android.Compose) {
        implementation(ui)
        implementation(animation)
        implementation(material3)
        implementation(preview)
        implementation(activity)
        implementation(navigation)
        implementation(materialIconsCore)
        implementation(materialIconsExtended)
        implementation(foundation)
        implementation(foundationLayout)

        // Testing Compose
        androidTestImplementation(junit)
        debugImplementation(tooling)
    }

    implementation(Dependencies.Log.timber)

    implementation("com.github.racka98.Material-Kompose:charts:1.0.0-beta01")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.freeCompilerArgs += "-opt-in=kotlin.RequiresOptIn"
}