package com.edwin.android.wheretogo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class HelloWorldActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello_world)
        val age: Int = 24
        Log.d(this.classLoader.toString(), "Hello world $age")
    }
}
