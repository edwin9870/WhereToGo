package com.edwin.android.wheretogo

import android.app.Activity
import android.app.Application
import android.app.Fragment
import com.edwin.android.wheretogo.di.DaggerAppComponent
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.HasFragmentInjector
import javax.inject.Inject


/**
 * Created by Edwin Ramirez Ventura on 9/27/2017.
 */
class MyApp: Application(), HasActivityInjector, HasFragmentInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun fragmentInjector(): AndroidInjector<Fragment> = fragmentInjector

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder().application(this@MyApp).build().inject(this@MyApp)
        Logger.addLogAdapter(AndroidLogAdapter())
    }


}