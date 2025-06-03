plugins {
    id("com.android.application")
    kotlin("android")
    id("dev.flutter.flutter-gradle-plugin")
}

android {
    namespace = "com.aziztech.counter_app"
    compileSdk = 35 // or use your flutter.compileSdkVersion if you prefer

    ndkVersion = "27.0.12077973"

    defaultConfig {
        applicationId = "com.aziztech.counter_app"
        minSdk = 21 // or your flutter.minSdkVersion
        targetSdk = 35 // or your flutter.targetSdkVersion

        versionCode = 1 // or your flutter.versionCode
        versionName = "1.0" // or your flutter.versionName
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    buildTypes {
        getByName("release") {
            signingConfig = signingConfigs.getByName("debug")
        }
    }
}

flutter {
    source = "../.."
}
