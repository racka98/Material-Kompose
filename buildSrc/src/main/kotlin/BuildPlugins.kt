
object BuildPlugins {
    val android by lazy { "com.android.tools.build:gradle:${Versions.gradlePlugin}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}" }
    val composeDesktop by lazy { "org.jetbrains.compose:compose-gradle-plugin:${Versions.composeDesktop}" }
}