package com.example.myapplication.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment" + "\n" + stringFromJNI()
    }
    val text: LiveData<String> = _text
    
    companion object {
        /* this is used to load the 'hello-jni' library on application
         * startup. The library has already been unpacked into
         * /data/data/com.example.kotlinjni/lib/libkotlin-jni.so at
         * installation time by the package manager.
         */
            init {
                System.loadLibrary("kotlin-jni")
            }
    }
    
    /* A native method that is implemented by the
     * 'hello-jni' native library, which is packaged
     * with this application.
     */
    external fun stringFromJNI(): String

    /* This is another native method declaration that is *not*
     * implemented by 'hello-jni'. This is simply to show that
     * you can declare as many native methods in your Kotlin code
     * as you want, their implementation is searched in the
     * currently loaded native libraries only the first time
     * you call them.
     *
     * Trying to call this function will result in a
     * java.lang.UnsatisfiedLinkError exception !
     */
    external fun unimplementedStringFromJNI(): String
}