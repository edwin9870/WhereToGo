package com.edwin.android.wheretogo.event

import android.app.Activity
import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.edwin.android.wheretogo.R
import com.orhanobut.logger.Logger
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject
import android.os.Build

/**
 * @author Edwin Ramirez Ventura
 */
class EventFragment : Fragment(), EventMVP.View {

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
                              savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_event, container, false)

        return view;
    }

    override fun setPresenter(presenter: EventMVP.Presenter) {
        Logger.d("Setting presenter")
    }
}
