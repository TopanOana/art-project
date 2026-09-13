plugins {
    alias(libs.plugins.sidequests.android.app)
}

android {
    namespace = "com.oanatopan.artproject.sumar"

    defaultConfig {
        applicationId = "com.oanatopan.artproject.sumar"
        versionCode = 1
        versionName = "1.0.0"
    }
}

dependencies {
    implementation(projects.sumar.sharedApp)
}
