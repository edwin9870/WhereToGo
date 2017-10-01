package com.edwin.android.wheretogo

import com.edwin.android.wheretogo.models.dto.EventDTO
import com.edwin.android.wheretogo.networks.EventbriteService
import com.edwin.android.wheretogo.repositories.EventRepository
import com.edwin.android.wheretogo.utils.RetrofitUtil
import io.reactivex.FlowableSubscriber
import org.junit.BeforeClass
import org.junit.Test
import org.reactivestreams.Subscription
import java.util.concurrent.TimeUnit
import kotlin.test.fail

/**
 * Created by Edwin Ramirez Ventura on 9/30/2017.
 */
class EventRepositoryTest {

    companion object {
        private lateinit var eventRepository: EventRepository

        private fun getEventBrideService(): EventbriteService {
            return RetrofitUtil.createRetrofitService(EventbriteService::class.java,
                    EventbriteService.SERVICE_ENDPOINT)
        }

        @BeforeClass
        @JvmStatic
        fun init() {
            eventRepository = EventRepository(getEventBrideService())
        }
    }


    @Test
    fun getVenueInformationValidVenue() {
        println("Start to execute test")
        val venueResponse = eventRepository.getVenue(20879882).timeout(5, TimeUnit.SECONDS).blockingGet()
        println("venueResponse: $venueResponse")
        if (venueResponse == null) {
            fail("Venue response could not be null")
        } else if (venueResponse.address == null) {
            fail("Address response could not be null")
        }

    }

    @Test
    fun getEventsValidEvents() {
        var subscription: Subscription? = null
        eventRepository.getEvents().timeout(5000, TimeUnit.SECONDS).subscribe(object : FlowableSubscriber<EventDTO> {
            override fun onSubscribe(s: Subscription) {
                subscription = s
                s.request(1)
            }

            override fun onError(t: Throwable?) {
            }

            override fun onNext(t: EventDTO?) {
                println("Event: $t")
                if(t == null) {
                    fail("Events must not be null")
                }
            }

            override fun onComplete() {
            }
        })

        Thread.sleep(6000)
    }
}