package com.edwin.android.wheretogo.utils

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Edwin Ramirez Ventura on 9/29/2017.
 */
class RetrofitUtil {

    companion object {


        private const val TOKEN_QUERY_PARAM = "token"

        private fun getEventBrideTokenInterceptor(): Interceptor {
            return Interceptor({ chain ->
                var request = chain.request()
                val url = request.url().newBuilder().addQueryParameter(TOKEN_QUERY_PARAM, "NKSQ2T2D6O5NBCLJJUH3").build()
                request = request.newBuilder().url(url).build()
                chain.proceed(request)
            })
        }

        fun <T> createRetrofitService(clazz: Class<T>, endPoint: String): T {

            val httpClient = OkHttpClient().newBuilder()
            httpClient.addInterceptor(getEventBrideTokenInterceptor()).build()
            val restAdapter = Retrofit.Builder()
                    .baseUrl(endPoint)
                    .client(httpClient.build())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            return restAdapter.create(clazz)
        }
    }


}