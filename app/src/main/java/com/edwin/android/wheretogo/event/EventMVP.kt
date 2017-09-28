package com.edwin.android.wheretogo.event

/**
 * Created by Edwin Ramirez Ventura on 9/27/2017.
 */
interface EventMVP {

    interface View {
        fun setPresenter(presenter: Presenter)
    }

    interface Presenter {

    }
}