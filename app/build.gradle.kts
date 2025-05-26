// Gradle plugins this module needs.
// They add more gradle tasks and settings to gradle.
plugins {
    alias(libs.plugins.com.android.application)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.kotlin.serialization)
}

// Android related settings. We can use this, because
// the module applies the Android Gradle plugin
android {
    //base package your code lives in
    namespace = "com.arconsis.androidtrainingexamples"
    // Android version that is used to build your app.
    compileSdk = 35

    defaultConfig {
        // Unique identifier of your app. If you uploaded your app to the Play Store once, you can't change it
        applicationId = "com.arconsis.androidtrainingexamples"
        // Minimum supported Android version. Devices that run lower versions will not see your
        // app in the Play Store.
        minSdk = 24
        // Highest Android version which you tested your app with
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        // This block is needed to be able to use vector graphics
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    // You can build your app in different variants, like e.g.
    // in release variant, where you obfuscate and minify the code.
    // Or in debug variant, where you e.g. want to add "-debug" to the
    // application id and name, to distinguish them.
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    // Defines which java version to use for developing
    // and running the app.
    compileOptions {
        // Describes which java features you can use in your code.
        // Here you can use all features that have been introduced
        // in Java 17 or in a previous version.
        sourceCompatibility = JavaVersion.VERSION_17

        // Describes the java version of the output / bytecode.
        // Theoretically ,this means, that the app can only be executed on devices which have
        // at least this version installed. But Android uses desuggaring to make it compatible for
        // devices with lower java versions (https://developer.android.com/studio/write/java8-support-table)
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        // Kotlin code compiles to java bytecode.
        // With this we set, which version the bytecode has.
        jvmTarget = "17"
    }
    buildFeatures {
        //Needed to be able to use compose
        compose = true
        viewBinding = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    ksp {
        arg("room.schemaLocation", "$projectDir/schemas")
    }
}

// Here you can add third party libraries.
// We could add them directly like the first one or
// reference them from our version catalog like all the others.
// (which in the end does the same, it's just more maintainable).
dependencies {
    // ViewModel
    // Here we directly enter the id of the library.
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    // Here we use our version catalog.
    implementation(libs.lifecycle.viewmodel.ktx)
    // Compose
    val composeBom = platform(libs.compose.bom)
    implementation(composeBom)
    implementation(libs.ui)
    implementation(libs.material3)
    implementation(libs.ui.tooling)
    implementation(libs.ui.tooling.preview)
    // ViewModel utilities for Compose
    implementation(libs.lifecycle.viewmodel.compose)
    // Lifecycles only (without ViewModel)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.lifecycle.runtime.compose)
    // Navigation
    implementation(libs.navigation.compose)
    // Room
    implementation(libs.room.ktx)
    ksp(libs.room.compiler)
    // Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)
    implementation(libs.hilt.work)
    ksp(libs.hilt.compiler)
    implementation(libs.hilt.navigation.compose)
    // DataStore
    implementation(libs.datastore)
    implementation(libs.datastore.preferences)
    // WorkManager
    implementation(libs.work.runtime.ktx)
    // Ktor
    // Here we use the bundle, so we don't have to add all
    // ktor libraries separately
    implementation(libs.bundles.ktor)
    // Serialization
    implementation(libs.kotlinx.serialization.json)
    // Coroutines
    implementation(libs.kotlinx.coroutines.core)
    //Other
    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material.old)
    implementation(libs.activity.compose)
    //Async image loading
    implementation(libs.coil.compose)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(libs.ui.test.junit4)
    androidTestImplementation(libs.ui.tooling)


    //The following libraries are only needed for the coroutine chapter, you don't need to copy them

    //ViewPager and indicator for UI in coroutines chapter
    implementation(libs.accompanist.pager)
    implementation(libs.worm.pager.indicator)


    //For code highlighting in the coroutines chapter
    implementation(libs.code.editor)
}