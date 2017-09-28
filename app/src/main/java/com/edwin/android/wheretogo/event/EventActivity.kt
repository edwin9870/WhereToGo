package com.edwin.android.wheretogo.event

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.edwin.android.wheretogo.R

class EventActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)

        val age: Int = 24
        Log.d(this.classLoader.toString(), "Hello world $age")
    }


}
