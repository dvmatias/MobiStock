pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
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
