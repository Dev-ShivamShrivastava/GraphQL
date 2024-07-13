plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.apollo.graph.ql)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.indigo.graphql"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.indigo.graphql"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    apollo {
        service("service1") {
            sourceFolder.set("com/indigo/graph")
            packageName.set("com.indigo.graph")
            schemaFile.set(file("src/main/graphql/com/indigo/graph/schema.graphqls"))
        }
        service("service2") {
            sourceFolder.set("com/indigo/pokemon")
            packageName.set("com.indigo.pokemon")
            schemaFile.set(file("src/main/graphql/com/indigo/pokemon/schema.graphqls"))
        }
       // useVersion2Compat()
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
        viewBinding = true
    }
}





dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //Graph ql
    implementation(libs.apollo.runtime)
    implementation(libs.apollo.api)

    //Gson
    implementation(libs.convertor.gson)

    //hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.kapt)


}

