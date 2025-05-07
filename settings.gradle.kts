pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
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
