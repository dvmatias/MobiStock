plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.google.dagger.hilt.android)
    alias(libs.plugins.compose.compiler)
    kotlin("kapt")
}

android {
    namespace = "com.samuraicmdv.featurebarcodescanner"
    compileSdk = project.property("compileSdk").toString().toInt()

    defaultConfig {
        minSdk = project.property("minSdk").toString().toInt()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    flavorDimensions += listOf("environment")

    productFlavors {
        create("qa") {
            dimension = "environment"
        }
        create("prod") {
            dimension = "environment"
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(project(mapOf("path" to ":ui")))
    implementation(project(mapOf("path" to ":domain")))
    implementation(project(mapOf("path" to ":common")))

    implementation(libs.android.material)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.appcompat)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.camera.core)
    implementation(libs.androidx.camera.lifecycle)
    implementation(libs.androidx.camera.view)
    implementation(libs.androidx.camera.camera2)
    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.ui.text.google.fonts)
    implementation(libs.coil)
    implementation(libs.coil.compose)
    implementation(libs.google.accompanist.permissions)
    implementation(libs.google.dagger.hilt.android)

    testImplementation(libs.androidx.compose.ui.test.junit4)
    testImplementation(libs.google.dagger.hilt.android.testing)
    testImplementation(libs.junit)

    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    androidTestImplementation(libs.androidx.test.espresso.core)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.google.dagger.hilt.android.testing)

    debugImplementation(libs.androidx.compose.ui.test.manifest)
    debugImplementation(libs.androidx.compose.ui.tooling)

    kapt(libs.google.dagger.hilt.android.compiler)
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}