package com.edwin.android.wheretogo.event

import android.app.Activity
import android.app.Fragment
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.edwin.android.wheretogo.R
import com.edwin.android.wheretogo.dto.EventDTO
import com.orhanobut.logger.Logger
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.fragment_event.*
import javax.inject.Inject

/**
 * @author Edwin Ramirez Ventura
 */
class EventFragment : Fragment(), EventMVP.View {

    private var eventAdapter: EventAdapter? = null

    @Inject
    lateinit var eventPresenter: EventMVP.Presenter

    companion object {
        fun newInstance(): EventFragment = EventFragment()
    }

    override fun onAttach(activity: Activity) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            AndroidInjection.inject(this)
        }
        super.onAttach(activity)
    }

    override fun onAttach(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            AndroidInjection.inject(this)
        }
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_event, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.eventAdapter = EventAdapter(activity)
        val linearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

        recyclerview_events.layoutManager = linearLayoutManager
        recyclerview_events.adapter = this.eventAdapter

        eventPresenter.getEvents()
    }

    override fun setPresenter(presenter: EventMVP.Presenter) {
        Logger.d("Setting presenter")
    }

    override fun showEvents(events: List<EventDTO>) {
        Logger.d("Updating showEvents adapter")
        eventAdapter?.setEvents(events.toMutableList())
    }
}
