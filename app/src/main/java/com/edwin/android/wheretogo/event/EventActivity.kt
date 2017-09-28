package com.edwin.android.wheretogo.event

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.edwin.android.wheretogo.R
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class EventActivity : AppCompatActivity(), HasSupportFragmentInjector, EventMVP.View {

    @Inject
    lateinit var eventPresenter: EventMVP.Presenter

    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)

        val age: Int = 24
        Log.d(this.classLoader.toString(), "Hello world $age")
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment>? = fragmentDispatchingAndroidInjector

    override fun setPresenter(presenter: EventMVP.Presenter) {

    }
}
