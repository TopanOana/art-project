plugins {
    alias(libs.plugins.sidequests.compose.multiplatform.library)
}

kotlin {
    android {
        namespace = "com.oanatopan.artproject.sumar.feature.player"
    }

    sourceSets {
        commonMain.dependencies {
            implementation(projects.design.theme)
            implementation(libs.compose.material3)
            implementation(compose.materialIconsExtended)
        }
    }
}
