import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("com.google.gms.google-services")
}


val localProperties = Properties()
val localPropertiesFile = rootProject.file("local.properties")
if (localPropertiesFile.exists()) {
    localProperties.load(localPropertiesFile.inputStream())
}

// Lấy giá trị API key từ local.properties
val apiKey = localProperties.getProperty("API_KEY") ?: ""

android {
    buildFeatures {
        buildConfig = true
    }



    namespace = "com.qguxxi.synthvoice"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.qguxxi.synthvoice"
        minSdk = 32
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        // Thêm API key vào BuildConfig
        // Thêm API key vào BuildConfig
        buildConfigField("String", "API_KEY", "\"$apiKey\"")
        buildConfigField("String", "OPEN_AI_API_KEY", "\"$apiKey\"")


        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {



    dependencies {

        implementation ("com.squareup.retrofit2:retrofit:2.11.0")
        implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
        implementation ("com.google.code.gson:gson:2.10")
        // Animation
        implementation("androidx.compose.animation:animation:1.4.3")
//      Splash Screen
        implementation ("androidx.core:core-splashscreen:1.0.0")
        implementation ("androidx.datastore:datastore-preferences:1.0.0")

        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")

        // Lottie File
        implementation("com.airbnb.android:lottie-compose:6.3.0")

        implementation(libs.androidx.runtime.livedata)
        implementation(libs.firebase.functions.ktx)

//        Google Auth
        implementation ("com.google.android.gms:play-services-auth:21.2.0")

        val nav_version = "2.8.0"
        // Jetpack Compose integration
        implementation("androidx.navigation:navigation-compose:$nav_version")
        implementation("com.github.stevdza-san:OneTapCompose:1.0.14")

        implementation(libs.androidx.core.ktx)
        implementation(libs.androidx.lifecycle.runtime.ktx)
        implementation(libs.androidx.activity.compose)
        implementation(platform(libs.androidx.compose.bom))
        implementation(libs.androidx.ui)
        implementation(libs.androidx.ui.graphics)
        implementation(libs.androidx.ui.tooling.preview)
        implementation(libs.androidx.material3)

        implementation(libs.androidx.ui.text.google.fonts)

        // Testing dependencies
        testImplementation(libs.junit)
        androidTestImplementation(libs.androidx.junit)
        androidTestImplementation(libs.androidx.espresso.core)
        androidTestImplementation(platform(libs.androidx.compose.bom))
        androidTestImplementation(libs.androidx.ui.test.junit4)

        // Debugging dependencies
        debugImplementation(libs.androidx.ui.tooling)
        debugImplementation(libs.androidx.ui.test.manifest)
    }

}