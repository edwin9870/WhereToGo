package com.edwin.android.wheretogo.event

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.edwin.android.wheretogo.R
import dagger.android.AndroidInjection
import javax.inject.Inject


class EventActivity : AppCompatActivity(){

    @Inject
    lateinit var messageEvent: MessageEvent

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)

        val age: Int = 24
        val msj = messageEvent.message()
        Log.d(this.classLoader.toString(), "Hello world $age, msj: $msj")
    }
}
