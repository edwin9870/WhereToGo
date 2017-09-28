package com.edwin.android.wheretogo.di

import android.app.Application
import android.content.Context
import dagger.Module

/**
 * Created by Edwin Ramirez Ventura on 9/27/2017.
 */

@Module
class AppModule {
    fun provideContext(application: Application) : Context = application
}