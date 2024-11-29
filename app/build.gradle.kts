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
        minSdk = 33
        targetSdk = 33
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



    implementation(libs.androidx.room.common)
    implementation(libs.androidx.room.ktx)
    dependencies {
        implementation("androidx.compose.material3:material3:1.3.1")
        // Testing
        androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
        androidTestImplementation("androidx.test.ext:junit:1.1.5")

        implementation (libs.retrofit)
        implementation (libs.converter.gson)
        implementation (libs.gson)
        implementation(libs.okhttp)
        // Animation
        implementation(libs.androidx.animation)
//      Splash Screen
        implementation (libs.androidx.core.splashscreen)
        implementation (libs.androidx.datastore.preferences)

        implementation(libs.kotlinx.coroutines.android)

        // Lottie File
        implementation(libs.lottie.compose)

        implementation(libs.androidx.runtime.livedata)
        implementation(libs.firebase.functions.ktx)

//        Google Auth
        implementation (libs.play.services.auth)


        // Jetpack Compose integration
        implementation(libs.androidx.navigation.compose)
        implementation(libs.onetapcompose)

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