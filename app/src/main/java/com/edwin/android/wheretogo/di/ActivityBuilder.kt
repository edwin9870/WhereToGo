package com.edwin.android.wheretogo.di

import com.edwin.android.wheretogo.event.EventActivityModule
import com.edwin.android.wheretogo.event.EventFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * Created by Edwin Ramirez Ventura on 9/28/2017.
 */
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = arrayOf(EventActivityModule::class))
    abstract fun bindEventFragment(): EventFragment
}