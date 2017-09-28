package com.edwin.android.wheretogo.event

import android.app.Fragment
import android.app.FragmentTransaction
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.edwin.android.wheretogo.R
import com.orhanobut.logger.Logger
import dagger.android.AndroidInjection
import javax.inject.Inject


class EventActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)

        val fragmentManager = fragmentManager
        var eventFragment: Fragment? = fragmentManager.findFragmentById(R.id.frame_event_fragment)

        if(eventFragment == null) {
            Logger.d("Creating new eventFragment")
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            eventFragment = EventFragment.Companion.newInstance()
            fragmentTransaction.replace(R.id.frame_event_fragment, eventFragment)
            fragmentTransaction.commit()
        }
    }

}
