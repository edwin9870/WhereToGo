package com.edwin.android.wheretogo.event

import dagger.Module
import dagger.Provides

/**
 * Created by Edwin Ramirez Ventura on 9/28/2017.
 */
@Module
class MainActivityModule {

    @Provides
    fun provideMainViewModel(): MessageEvent = MessageEvent()

}