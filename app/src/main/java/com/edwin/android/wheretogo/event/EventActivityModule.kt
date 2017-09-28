package com.edwin.android.wheretogo.event

import dagger.Module
import dagger.Provides

/**
 * Created by Edwin Ramirez Ventura on 9/28/2017.
 */
@Module
class EventActivityModule {


    @Provides
    fun provideView(eventFragment: EventFragment): EventMVP.View = eventFragment

    @Provides
    fun providePresenter(view: EventMVP.View): EventMVP.Presenter = EventPresenter(view)

}