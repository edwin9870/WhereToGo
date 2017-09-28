package com.edwin.android.wheretogo.di

import com.edwin.android.wheretogo.event.EventActivity
import com.edwin.android.wheretogo.event.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector



/**
 * Created by Edwin Ramirez Ventura on 9/28/2017.
 */
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    abstract fun bindMainActivity(): EventActivity

}