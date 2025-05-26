// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    // Here we add the android gradle plugin (AGP)
    alias(libs.plugins.com.android.application) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.org.jetbrains.kotlin.android) apply false
    alias(libs.plugins.hilt.android) apply false
    alias(libs.plugins.ksp) apply false
}