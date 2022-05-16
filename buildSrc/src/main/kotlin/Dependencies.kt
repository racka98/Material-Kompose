object Dependencies {

    object Jetbrains {
        val testCommon by lazy { "org.jetbrains.kotlin:kotlin-test-common:${Versions.kotlin}" }
        val testAnnotationsCommon by lazy { "org.jetbrains.kotlin:kotlin-test-annotations-common:${Versions.kotlin}" }

    }

    object Kotlin {
        val kotlinJunit by lazy { "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlin}" }
        val dateTime by lazy { "org.jetbrains.kotlinx:kotlinx-datetime:${Versions.kotlinxDateTime}" }

        object Coroutines {
            private const val VERSION = "1.6.0"
            val core by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:$VERSION" }
            val android by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:$VERSION" }
            val test by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-test:$VERSION" }
        }
    }

    object ArkIvanov {

        object Decompose {
            private const val VERSION = "0.3.1"
            val decompose by lazy { "com.arkivanov.decompose:decompose:$VERSION" }
            val extensionsCompose by lazy {
                "com.arkivanov.decompose:extensions-compose-jetbrains:$VERSION"
            }
        }
    }

    object Log {
        val slf4j by lazy { "org.slf4j:slf4j-simple:${Versions.slf4j}" }
        val logback by lazy { "ch.qos.logback:logback-classic:${Versions.logback}" }
        val kermit by lazy { "co.touchlab:kermit:${Versions.kermit}" }
        val timber by lazy { "com.jakewharton.timber:timber:${Versions.timber}" }
    }

    object Android {

        object Essential {
            val coreKtx by lazy { "androidx.core:core-ktx:${Versions.coreKtx}" }
            val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompat}" }
            val material by lazy { "com.google.android.material:material:${Versions.material}" }

            // Lifecycle components
            val lifecycleRuntimeKtx by lazy {
                "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntimeKtx}"
            }
        }

        // Testing
        object JUnit {
            val core by lazy { "junit:junit:${Versions.junit}" }
            val test by lazy { "androidx.test.ext:junit:${Versions.junitTest}" }
            val testExtKtx by lazy { "androidx.test.ext:junit-ktx:${Versions.testExtJUnit}" }
        }

        object TestCore {
            val testKtx by lazy { "androidx.test:core-ktx:${Versions.testCore}" }
            val testArch by lazy { "androidx.arch.core:core-testing:${Versions.testArchCore}" }
        }

        // Compose
        object Compose {
            val ui by lazy { "androidx.compose.ui:ui:${Versions.compose}" }
            val material by lazy { "androidx.compose.material:material:${Versions.compose}" }
            val material3 by lazy { "androidx.compose.material3:material3:${Versions.composeMaterial3}" }
            val animation by lazy { "androidx.compose.animation:animation:${Versions.compose}" }
            val preview by lazy { "androidx.compose.ui:ui-tooling-preview:${Versions.compose}" }
            val activity by lazy { "androidx.activity:activity-compose:${Versions.activityCompose}" }
            val navigation by lazy { "androidx.navigation:navigation-compose:${Versions.composeNavigation}" }
            val materialIconsCore by lazy { "androidx.compose.material:material-icons-core:${Versions.compose}" }
            val materialIconsExtended by lazy { "androidx.compose.material:material-icons-extended:${Versions.compose}" }
            val foundation by lazy { "androidx.compose.foundation:foundation:${Versions.compose}" }
            val foundationLayout by lazy { "androidx.compose.foundation:foundation-layout:${Versions.compose}" }
            val constraintLayout by lazy { "androidx.constraintlayout:constraintlayout-compose:${Versions.composeConstraintLayout}" }

            // Compose Testing
            val junit by lazy { "androidx.compose.ui:ui-test-junit4:${Versions.compose}" }
            val tooling by lazy { "androidx.compose.ui:ui-tooling:${Versions.compose}" }
        }

        // Accompanist
        object Accompanist {
            val pager by lazy { "com.google.accompanist:accompanist-pager:${Versions.accompanist}" }
            val swipeRefresh by lazy { "com.google.accompanist:accompanist-swiperefresh:${Versions.accompanist}" }
            val systemUiController by lazy { "com.google.accompanist:accompanist-systemuicontroller:${Versions.accompanist}" }
        }
    }

}
