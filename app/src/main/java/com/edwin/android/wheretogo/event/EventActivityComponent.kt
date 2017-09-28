package com.edwin.android.wheretogo.event

import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by Edwin Ramirez Ventura on 9/27/2017.
 */
@Subcomponent(modules = arrayOf(EventActivityModule::class))
interface EventActivityComponent : AndroidInjector<EventActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<EventActivity>()
}