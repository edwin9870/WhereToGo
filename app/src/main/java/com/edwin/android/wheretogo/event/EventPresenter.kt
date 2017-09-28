package com.edwin.android.wheretogo.event

import com.orhanobut.logger.Logger
import javax.inject.Inject

/**
 * Created by Edwin Ramirez Ventura on 9/28/2017.
 */
class EventPresenter @Inject constructor(view: EventMVP.View) : EventMVP.Presenter {

    init {
        Logger.d("Constructor get called")
        view.setPresenter(this@EventPresenter)
    }

    override fun getMessage(message: String) {
        Logger.d("Message: $message")
    }
}