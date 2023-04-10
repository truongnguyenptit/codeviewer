plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization")
    id("org.jetbrains.compose")
}

kotlin {
    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "share-ui"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
//                implementation(kotlin("test"))
                implementation(project(":shared"))

                api(libs.kermit)
                api(libs.kermit.crashlytics)
                api(libs.kotlinx.coroutines.core)
                api(libs.kotlinx.datetime)
                api(libs.multiplatformSettings.core)
                // this enforces new version of atomicfu, the older version from other libraries crashes iOS build
                api(libs.atomicfu)
                api(libs.uuid)

                implementation(libs.bundles.ktor.common)
                implementation(libs.bundles.sqldelight.common)

                implementation(libs.stately.common)
                implementation(libs.koin.core)

                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(compose.runtime)

                implementation(libs.hyperdrive.multiplatformx.api)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting
        val androidUnitTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }

//    targets.withType<org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget> {
//        binaries.withType<org.jetbrains.kotlin.gradle.plugin.mpp.Framework> {
//            linkerOpts.add("-lsqlite3")
//            export(libs.kermit)
//            export(libs.hyperdrive.multiplatformx.api)
//            export(project(":shared"))
//            export(project(":shared-ui"))
//        }
//    }
}

android {
    namespace = "org.jetbrains.codeviewer"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
        targetSdk = 33
    }
}