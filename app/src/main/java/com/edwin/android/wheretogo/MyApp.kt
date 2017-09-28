package com.edwin.android.wheretogo

import android.app.Activity
import android.app.Application
import com.edwin.android.wheretogo.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject


/**
 * Created by Edwin Ramirez Ventura on 9/27/2017.
 */
class MyApp: Application(), HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder().application(this@MyApp).build().inject(this@MyApp)
    }


}