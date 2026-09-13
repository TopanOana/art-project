plugins {
    alias(libs.plugins.sidequests.compose.multiplatform.library)
}

compose.resources {
    packageOfResClass = "com.oanatopan.artproject.design.theme"
    generateResClass = always
    // The sumar:feature:* modules pull the metro-map background drawables from here (they're
    // shared theme assets, not per-feature ones), which needs the generated Res class visible
    // outside this module.
    publicResClass = true
}

kotlin {
    android {
        namespace = "com.oanatopan.artproject.design.theme"

        androidResources { enable = true }
    }

    sourceSets {
        commonMain.dependencies {
            api(libs.compose.components.resources)
            // For the shared BackButton composable — kept here rather than duplicated per
            // feature module, since every screen with a back action needs the same one.
            implementation(libs.compose.material3)
            implementation(compose.materialIconsExtended)
        }
    }
}
