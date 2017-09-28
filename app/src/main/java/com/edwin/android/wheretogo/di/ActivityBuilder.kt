package com.edwin.android.wheretogo.di

import android.support.v7.app.AppCompatActivity
import com.edwin.android.wheretogo.event.EventActivity
import com.edwin.android.wheretogo.event.EventActivityComponent
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

/**
 * Created by Edwin Ramirez Ventura on 9/27/2017.
 */

@Module
abstract class ActivityBuilder {

    @Binds
    @IntoMap
    @ActivityKey(EventActivity::class)
    abstract fun bindEventActivity(builder: EventActivityComponent.Builder): AndroidInjector.Factory<out AppCompatActivity>
}