package com.edwin.android.wheretogo.event

import com.edwin.android.wheretogo.models.dto.EventDTO
import com.edwin.android.wheretogo.utils.ViewUtil
import java.util.*


/**
 * Created by Edwin Ramirez Ventura on 9/28/2017.
 */
interface EventMVP {

    interface View {
        fun setPresenter(presenter: Presenter)
        fun showEvents(events: List<EventDTO>)
        fun setContentVisibility(visibility: ViewUtil.Visibility)
        fun setLoaderVisibility(visibility: ViewUtil.Visibility)
    }

    interface Presenter {
        fun getEvents()
        fun getPosition(): Long
        fun restore(position: Long, events: ArrayList<EventDTO>?)
        fun onClickHeart(event: EventDTO, view: android.view.View)
    }
}