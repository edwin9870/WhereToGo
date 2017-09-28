package com.edwin.android.wheretogo.di

import android.app.Application
import com.edwin.android.wheretogo.MyApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule

/**
 * Created by Edwin Ramirez Ventura on 9/27/2017.
 */
@Component(modules = arrayOf(AndroidInjectionModule::class, AppModule::class, ActivityBuilder::class))
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(app: MyApp)
}