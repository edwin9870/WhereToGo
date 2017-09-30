package com.edwin.android.wheretogo.repositories

import com.edwin.android.wheretogo.models.dto.EventDTO
import com.edwin.android.wheretogo.models.wrapper.VenueResponse
import com.edwin.android.wheretogo.networks.EventbriteService
import com.edwin.android.wheretogo.utils.RetrofitUtil
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.FlowableEmitter
import io.reactivex.Maybe
import io.reactivex.disposables.Disposable
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import java.text.SimpleDateFormat
import javax.inject.Singleton


/**
 * Created by Edwin Ramirez Ventura on 9/29/2017.
 */
@Singleton
class EventsRepository {

    private lateinit var venueDisposable: Disposable

    companion object {
        private const val LOCATION_QUERY_PARAM = "DominicanRepublic"
        private const val SORT_BY_QUERY_PARAM = "date"


        internal fun getEventBrideService() : EventbriteService {
            return RetrofitUtil.createRetrofitService(EventbriteService::class.java,
                    EventbriteService.SERVICE_ENDPOINT)
        }
    }

    fun getVenue(venueId: Int): Maybe<VenueResponse> {
        return Maybe.create<VenueResponse>({e ->
            getEventBrideService().getVenue(venueId).subscribe(
                    {e.onSuccess(it)},
                    { e.onError(it) },
                    { e.onComplete() }
            )
        })
    }

    fun getEvents() : Flowable<EventDTO> {
        return Flowable.create({ e: FlowableEmitter<EventDTO> ->
            getEventBrideService().getEvents(LOCATION_QUERY_PARAM, SORT_BY_QUERY_PARAM)
                    .subscribe {
                        it.events?.forEach {event ->
                            venueDisposable = getVenue(event.venueId!!.toInt()).subscribe({venueSubscriber ->
                                val startTime = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").parse(event.start!!.local)
                                e.onNext(
                                        EventDTO(event.name?.text!!,
                                                venueSubscriber.address!!.city!!,
                                                startTime.time,
                                                0.00,
                                                event.logo?.url!!)
                                )
                            })

                        }
                    }
        },
        BackpressureStrategy.BUFFER)
    }
}