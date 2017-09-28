package com.edwin.android.wheretogo.event


/**
 * Created by Edwin Ramirez Ventura on 9/28/2017.
 */
interface EventMVP {

    interface View {
        fun setPresenter(presenter: Presenter)
    }

    interface Presenter {
        fun getMessage(message: String)
    }
}