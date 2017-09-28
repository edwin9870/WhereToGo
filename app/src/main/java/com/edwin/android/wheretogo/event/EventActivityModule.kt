package com.edwin.android.wheretogo.event

import dagger.Module
import dagger.Provides

/**
 * Created by Edwin Ramirez Ventura on 9/27/2017.
 */

@Module
class EventActivityModule {

    @Provides
    fun provideMainView(eventActivity: EventActivity): EventMVP.View = eventActivity

    @Provides
    fun providePresenter(view: EventMVP.View): EventMVP.Presenter = EventPresenter(view)

}