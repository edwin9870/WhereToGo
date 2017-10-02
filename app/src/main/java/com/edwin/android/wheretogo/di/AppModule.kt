package com.edwin.android.wheretogo.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import android.preference.PreferenceManager



/**
 * Created by Edwin Ramirez Ventura on 9/28/2017.
 */
@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context = application

    @Provides
    @Singleton
    fun provideSharedPreferenes(application: Application) : SharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(application)
}