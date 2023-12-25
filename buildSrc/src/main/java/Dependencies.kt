object Dependencies {


    val coreKtx by lazy { "androidx.core:core-ktx:${Versions.coreKtx}" }
    val appcompat by lazy { "androidx.appcompat:appcompat:${Versions.appcompat}" }
    val material by lazy { "com.google.android.material:material:${Versions.material}" }
    val lifecycleRuntimeKtx by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntimeKtx}" }
    val activityCompose by lazy { "androidx.activity:activity-compose:${Versions.activityCompose}" }
    val composeBom by lazy { "androidx.compose:compose-bom:${Versions.compose}" }
    val composeUi by lazy { "androidx.compose.ui:ui:" }
    val composeUiGraphics by lazy { "androidx.compose.ui:ui-graphics:" }
    val composeUiToolingPreview by lazy { "androidx.compose.ui:ui-tooling-preview" }
    val composeMaterial3 by lazy { "androidx.compose.material3:material3" }
    val navigationCompose by lazy { "androidx.navigation:navigation-compose:${Versions.navigationCompose}" }
    val composeTestJUnit4 by lazy { "androidx.compose.ui:ui-test-junit4" }
    val JUnit4 by lazy { "junit:junit:${Versions.JUnit4}" }
    val extTestJUnit by lazy { "androidx.test.ext:junit:${Versions.junit}" }
    val espressoCore by lazy { "androidx.test.espresso:espresso-core:${Versions.espressoCore}" }
    val composeUiTooling by lazy { "androidx.compose.ui:ui-tooling" }
    val composeUiTestManifest by lazy { "androidx.compose.ui:ui-test-manifest" }
    val lifecycleViewModelKtx by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleViewModelKtx}" }

    val hiltAndroid by lazy { "com.google.dagger:hilt-android:${Versions.hiltAndroid}"}
    val hiltAndroidCompiler by lazy {"com.google.dagger:hilt-compiler:${Versions.hiltAndroid}" }
    val hiltCompiler by lazy {"androidx.hilt:hilt-compiler:${Versions.hiltCompiler}" }



    object Modules {

        const val utilities = ":utilities"
    }

}