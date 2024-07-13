
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false

    //Graph ql
    alias(libs.plugins.apollo.graph.ql) apply false

    //hilt
    alias(libs.plugins.hilt) apply false

    alias(libs.plugins.ksp) apply false


}