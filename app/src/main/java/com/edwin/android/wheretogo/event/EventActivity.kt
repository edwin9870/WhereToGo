package com.edwin.android.wheretogo.event

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.edwin.android.wheretogo.R
import com.orhanobut.logger.Logger
import dagger.android.AndroidInjection
import javax.inject.Inject
import com.orhanobut.logger.AndroidLogAdapter




class EventActivity : AppCompatActivity(), EventMVP.View {

    @Inject
    lateinit var messageEvent: MessageEvent

    @Inject
    lateinit var eventPresenter: EventMVP.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)
        val age = 24
        val msj = messageEvent.message()
        eventPresenter.getMessage(msj)
        Logger.d("Hello world $age, msj: $msj")
    }

    override fun setPresenter(presenter: EventMVP.Presenter) {
        Logger.d("Setting presenter...")
    }
}
