plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.google.dagger.hilt.android)
    kotlin("kapt")
}

android {
    namespace = "com.samuraicmdv.data"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(mapOf("path" to ":common")))
    implementation(project(mapOf("path" to ":domain")))
    implementation(project(mapOf("path" to ":network")))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.android.material)
    implementation(libs.retrofit)
    implementation(libs.retrofit2.converter.gson)
    implementation(libs.google.dagger.hilt.android)

    annotationProcessor(libs.google.dagger.hilt.compiler)

    testAnnotationProcessor(libs.google.dagger.hilt.compiler)

    androidTestAnnotationProcessor(libs.google.dagger.hilt.compiler)

    testImplementation(libs.junit)
    testImplementation(libs.google.dagger.hilt.android.testing)

    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.androidx.test.espresso.core)
    androidTestImplementation(libs.google.dagger.hilt.android.testing)

    kapt(libs.google.dagger.hilt.android.compiler)
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}