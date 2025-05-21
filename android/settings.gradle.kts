pluginManagement {
    // Load local.properties to get Flutter SDK path
    val localProperties = java.util.Properties()
    val localPropertiesFile = File(rootDir, "local.properties")
    if (localPropertiesFile.exists()) {
        localPropertiesFile.inputStream().use {
            localProperties.load(it)
        }
    }

    val flutterSdkPath = localProperties.getProperty("flutter.sdk")
        ?: throw GradleException("flutter.sdk not set in local.properties")

    // Include Flutter Gradle plugin build
    includeBuild("$flutterSdkPath/packages/flutter_tools/gradle")

    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("dev.flutter.flutter-gradle-plugin") version "1.0.0" apply false // <-- let Flutter handle version
    id("com.android.application") version "8.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.20" apply false
}

include(":app")
