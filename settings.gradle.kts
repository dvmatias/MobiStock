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
include(":ui")
include(":domain")
include(":data")
include(":featureHome")
include(":featureLogin")
include(":featureProductDetails")
