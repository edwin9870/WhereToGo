package com.edwin.android.wheretogo

import com.edwin.android.wheretogo.repositories.EventsRepository
import org.junit.Test
import java.util.concurrent.TimeUnit

/**
 * Created by Edwin Ramirez Ventura on 9/30/2017.
 */
class EventsRepositoryTest {

    @Test
    fun getVenueInformation() {
        println("Start to execute test")
        val eventsRepository = EventsRepository()
        val venueResponse = eventsRepository.getVenue(20879882).timeout(5, TimeUnit.SECONDS).blockingGet()
        println("venueResponse: $venueResponse")

    }
}