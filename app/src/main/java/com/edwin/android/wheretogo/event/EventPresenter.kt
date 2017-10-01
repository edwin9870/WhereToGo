package com.edwin.android.wheretogo.event

import com.edwin.android.wheretogo.models.dto.EventDTO
import com.edwin.android.wheretogo.repositories.EventRepository
import com.orhanobut.logger.Logger
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*
import java.util.function.Consumer
import javax.inject.Inject

/**
 * Created by Edwin Ramirez Ventura on 9/28/2017.
 */
class EventPresenter @Inject constructor(private val view: EventMVP.View,
                                         private val eventRepository: EventRepository) : EventMVP.Presenter {
    private lateinit var eventsFloweable: Flowable<EventDTO>
    var index = 0L
    init {
        Logger.d("Constructor get called")
        view.setPresenter(this@EventPresenter)
    }

    companion object {
        const val LIMIT = 10L
    }

    override fun getEvents() {
        val eventList: MutableList<EventDTO> = mutableListOf()
        eventsFloweable = eventRepository.getEvents().cache()

        eventsFloweable.skip(index).take(EventPresenter.LIMIT).toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe { events ->
            Logger.d("Events to show: "+ events)
            view.showEvents(events)
        }
        /*eventList.add(EventDTO("Example 1", "Punta Cana", Date().time, 54545.toDouble(),"punta_cana.jpg" ))
        eventList.add(EventDTO("Example 2", "Santo Domingo", Date().time, 1000.toDouble(),"santo_domingo.jpg" ))
        view.showEvents(eventList)*/
    }
}