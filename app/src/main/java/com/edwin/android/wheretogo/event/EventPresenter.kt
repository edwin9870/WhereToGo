package com.edwin.android.wheretogo.event

import com.edwin.android.wheretogo.models.dto.EventDTO
import com.edwin.android.wheretogo.repositories.EventRepository
import com.orhanobut.logger.Logger
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Edwin Ramirez Ventura on 9/28/2017.
 */
class EventPresenter @Inject constructor(private val view: EventMVP.View,
                                         private val eventRepository: EventRepository) : EventMVP.Presenter {
    private var eventsFloweable: Flowable<EventDTO>? = null
    var index = 0L

    init {
        Logger.d("Constructor get called")
        view.setPresenter(this@EventPresenter)
    }

    companion object {
        const val LIMIT = 5L
    }

    override fun getEvents() {
        Logger.d("Executing getEvents, index: $index")
        if (eventsFloweable == null) {
            eventsFloweable = eventRepository.getEvents().cache()
        }

        eventsFloweable!!.skip(index).take(EventPresenter.LIMIT).toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe { events ->
            Logger.d("Events to show: " + events)
            view.showEvents(events)
            if(index == 0L) {
                index = LIMIT
            } else {
                index += LIMIT
            }

        }
    }
}