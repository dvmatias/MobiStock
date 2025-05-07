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
include(":featureCategory")
include(":featureHome")
include(":featureLogin")
include(":featureProductDetails")
include(":network")
include(":ui")
