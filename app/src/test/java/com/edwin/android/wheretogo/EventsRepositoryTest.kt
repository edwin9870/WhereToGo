package com.edwin.android.wheretogo

import com.edwin.android.wheretogo.repositories.EventsRepository
import org.junit.Test
import java.util.concurrent.TimeUnit
import kotlin.test.fail

/**
 * Created by Edwin Ramirez Ventura on 9/30/2017.
 */
class EventsRepositoryTest {

    @Test
    fun getVenueInformationValidVenue() {
        println("Start to execute test")
        val eventsRepository = EventsRepository()
        val venueResponse = eventsRepository.getVenue(20879882).timeout(5, TimeUnit.SECONDS).blockingGet()
        println("venueResponse: $venueResponse")
        if(venueResponse == null) {
            fail("Venue response could not be null")
        } else if(venueResponse.address == null) {
            fail("Address response could not be null")
        }

    }
}