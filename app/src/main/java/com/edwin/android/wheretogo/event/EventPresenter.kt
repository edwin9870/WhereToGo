package com.edwin.android.wheretogo.event

import com.edwin.android.wheretogo.models.dto.EventDTO
import com.orhanobut.logger.Logger
import java.util.*
import javax.inject.Inject

/**
 * Created by Edwin Ramirez Ventura on 9/28/2017.
 */
class EventPresenter @Inject constructor(val view: EventMVP.View) : EventMVP.Presenter {
    init {
        Logger.d("Constructor get called")
        view.setPresenter(this@EventPresenter)
    }

    override fun getEvents() {
        val eventList: MutableList<EventDTO> = mutableListOf()
        eventList.add(EventDTO("Example 1", "Punta Cana", Date().time, 54545.toDouble(),"punta_cana.jpg" ))
        eventList.add(EventDTO("Example 2", "Santo Domingo", Date().time, 1000.toDouble(),"santo_domingo.jpg" ))
        view.showEvents(eventList)
    }
}