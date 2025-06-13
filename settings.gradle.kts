pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
dependencyResolutionManagement {
    @Suppress("UnstableApiUsage")
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "MobiStock"
include(":app")
include(":common")
include(":data")
include(":domain")
include(":featureBarcodeScanner")
include(":featureCategory")
include(":featureDashboard")
include(":featureLogin")
include(":featureProductDetails")
include(":network")
include(":ui")
