package com.edwin.android.wheretogo

import android.app.Activity
import android.app.Application
import com.edwin.android.wheretogo.di.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created by Edwin Ramirez Ventura on 9/27/2017.
 */
class MyApp  : Application(), HasActivityInjector {

    var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>? = null
        @Inject set

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder().application(this).build().inject(this)
    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity>? = activityDispatchingAndroidInjector

}