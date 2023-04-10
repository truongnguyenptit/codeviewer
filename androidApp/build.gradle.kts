plugins {
    kotlin("multiplatform")
    id("com.android.application")
    id("org.jetbrains.compose")
}

kotlin {
    android()
    sourceSets {
        val androidMain by getting {
            dependencies {
                implementation(project(":shared"))
                implementation(project(":share-ui"))
                implementation(libs.hyperdrive.multiplatformx.api)
                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(compose.runtime)
                implementation(libs.koin.core)
                implementation("io.insert-koin:koin-android:3.3.3")
                implementation("io.insert-koin:koin-androidx-compose:3.4.2")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.0")

            }
        }
    }
}

android {
    compileSdk = 33
    defaultConfig {
        applicationId = "org.jetbrains.Codeviewer"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}
