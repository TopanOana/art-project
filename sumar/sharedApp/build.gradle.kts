import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    alias(libs.plugins.sidequests.compose.multiplatform.library)
    alias(libs.plugins.kotlinSerialization)
}

kotlin {
    android {
        namespace = "com.oanatopan.artproject.sumar.sharedApp"
    }

    // The iOS targets themselves come from the convention plugin; only the binary they produce is
    // this module's business. Static, so nothing else needs to link a second framework alongside
    // it — Swift only ever calls `MainViewController()`.
    targets.withType<KotlinNativeTarget>().configureEach {
        binaries.framework {
            baseName = "SumarShared"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(projects.sumar.feature.title)
            implementation(projects.sumar.feature.player)
            implementation(projects.sumar.feature.credits)
            implementation(projects.design.theme)
            implementation(projects.design.navigation)
            implementation(libs.compose.material3)
            implementation(libs.kotlinx.serialization.core)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}
