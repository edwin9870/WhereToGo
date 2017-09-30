package com.edwin.android.wheretogo.di

import com.edwin.android.wheretogo.networks.EventbriteService
import com.edwin.android.wheretogo.utils.RetrofitUtil
import dagger.Module
import dagger.Provides

/**
 * Created by Edwin Ramirez Ventura on 9/30/2017.
 */
@Module
class AppService {

    @Provides
    fun provideEventbriteService() : EventbriteService {
        return RetrofitUtil.createRetrofitService(EventbriteService::class.java,
                EventbriteService.SERVICE_ENDPOINT)
    }
}
