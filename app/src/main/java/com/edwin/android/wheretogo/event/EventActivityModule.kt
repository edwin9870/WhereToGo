package com.edwin.android.wheretogo.event

import com.edwin.android.wheretogo.repositories.EventRepository
import dagger.Module
import dagger.Provides

/**
 * Created by Edwin Ramirez Ventura on 9/28/2017.
 */
@Module()
class EventActivityModule {


    @Provides
    fun provideView(eventFragment: EventFragment): EventMVP.View = eventFragment

    @Provides
    fun providePresenter(view: EventMVP.View,
                         eventRepository: EventRepository): EventMVP.Presenter = EventPresenter(view, eventRepository)

}