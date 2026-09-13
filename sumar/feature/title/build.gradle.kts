plugins {
    alias(libs.plugins.sidequests.compose.multiplatform.library)
}

kotlin {
    android {
        namespace = "com.oanatopan.artproject.sumar.feature.title"
    }

    sourceSets {
        commonMain.dependencies {
            implementation(projects.design.theme)
            implementation(libs.compose.material3)
        }
    }
}
