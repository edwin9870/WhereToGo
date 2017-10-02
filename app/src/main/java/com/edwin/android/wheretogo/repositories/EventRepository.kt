package com.edwin.android.wheretogo.repositories

import android.content.SharedPreferences
import com.edwin.android.wheretogo.models.dto.EventDTO
import com.edwin.android.wheretogo.models.wrapper.VenueResponse
import com.edwin.android.wheretogo.networks.EventbriteService
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.FlowableEmitter
import io.reactivex.Maybe
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.toObservable
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Created by Edwin Ramirez Ventura on 9/29/2017.
 */
@Singleton
class EventRepository @Inject constructor(private val eventBriteService: EventbriteService,
                                          private val sharedPreferences: SharedPreferences){

    private lateinit var venueDisposable: Disposable

    companion object {
        private const val LOCATION_QUERY_PARAM = "DominicanRepublic"
        private const val SORT_BY_QUERY_PARAM = "date"
        private const val PREF_IS_FAVORITE = "PREF_IS_FAVORITE"
    }

    fun getVenue(venueId: Int): Maybe<VenueResponse> {
        return Maybe.create<VenueResponse>({e ->
            eventBriteService.getVenue(venueId).subscribe(
                    {e.onSuccess(it)},
                    { e.onError(it) },
                    { e.onComplete() }
            )
        })
    }

    fun getEvents() : Flowable<EventDTO> {
        return Flowable.create({ e: FlowableEmitter<EventDTO> ->
            eventBriteService.getEvents(LOCATION_QUERY_PARAM, SORT_BY_QUERY_PARAM)
                    .subscribe {
                        it.events?.toObservable()
                                ?.subscribe {
                            venueDisposable = getVenue(it.venueId!!.toInt()).subscribe({venueSubscriber ->
                                val startTime = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US).parse(it.start!!.local)

                                val event = EventDTO(it.id!!.toLong(),
                                        it.name?.text!!,
                                        venueSubscriber.address!!.localizedAddressDisplay!!,
                                        startTime.time,
                                        0.00,
                                        it.logo?.url)

                                if(isEventFavorite(event.id)) {
                                    event.isFavorite = true
                                }

                                e.onNext(event)
                            })
                        }
                    }
        },
        BackpressureStrategy.BUFFER)
    }

    fun addEventAsFavorite(event: EventDTO) {
        val editor = sharedPreferences.edit()
        editor.putBoolean(event.id.toString(), true)
        editor.apply()
    }

    fun removeEventAsFavorite(event: EventDTO) {
        val editor = sharedPreferences.edit()
        editor.putBoolean(event.id.toString(), false)
        editor.apply()
    }

    fun isEventFavorite(eventId: Long) : Boolean =
            sharedPreferences.getBoolean(eventId.toString(), false)
}