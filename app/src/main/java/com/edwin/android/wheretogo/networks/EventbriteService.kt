package com.edwin.android.wheretogo.networks

import com.edwin.android.wheretogo.models.wrapper.EventsResponse
import com.edwin.android.wheretogo.models.wrapper.VenueResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


/**
 * Created by Edwin Ramirez Ventura on 9/29/2017.
 */
interface EventbriteService {
    companion object {
        const val SERVICE_ENDPOINT = "https://www.eventbriteapi.com/v3/"
    }

    @GET("events/search")
    fun getEvents(
            @Query("location.address") location: String,
            @Query("sort_by") sortBy: String) : Observable<EventsResponse>

    @GET("venues/{venueId}")
    fun getVenue(@Path("venueId") venueId: Int) : Observable<VenueResponse>
}