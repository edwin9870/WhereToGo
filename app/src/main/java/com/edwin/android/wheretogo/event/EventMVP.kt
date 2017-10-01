package com.edwin.android.wheretogo.event

import com.edwin.android.wheretogo.models.dto.EventDTO
import java.util.ArrayList


/**
 * Created by Edwin Ramirez Ventura on 9/28/2017.
 */
interface EventMVP {

    interface View {
        fun setPresenter(presenter: Presenter)
        fun showEvents(events: List<EventDTO>)
    }

    interface Presenter {
        fun getEvents()
        fun getPosition(): Long
        fun restore(position: Long, events: ArrayList<EventDTO>?)
    }
}