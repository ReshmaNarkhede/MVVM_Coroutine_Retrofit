# MVVM_Coroutine_Retrofit
created to understand few concept like MVVM, Coroutine, retrofit

Created exmple to understand How Mvvm works. MVVM architecture which overcome all drawbacks of MVP and MVC.
Coroutine retrofit and live data all this used in one exmple which helps developers to understand MVVM + Coroutine + Live data + Retrofit.

https://jsonplaceholder.typicode.com/posts
this one is used to get json response and to show asynchronous call.

Add below dependecies in app level build.gradle

//coroutine

    def coroutines_version = "1.5.1"
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_version"
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines_version"
    
//Retrofit

    def retrofit2_version = "2.9.0"
    implementation "com.squareup.retrofit2:retrofit:$retrofit2_version"
    implementation "com.squareup.retrofit2:converter-gson:$retrofit2_version"
    
 // view_model, livedata
 
    def arch_version = '2.2.0-alpha05'
    implementation "androidx.lifecycle:lifecycle-extensions:$arch_version"
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$arch_version"
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:$arch_version"
    implementation "androidx.lifecycle:lifecycle-runtime-ktx:$arch_version"
