package com.edwin.android.wheretogo.utils

import android.view.View

/**
 * Created by Edwin Ramirez Ventura on 10/1/2017.
 */

class ViewUtil {
    enum class Visibility(val visibility: Int) {
        VISIBLE(View.VISIBLE),
        INVISIBLE(View.INVISIBLE),
        GONE(View.GONE)
    }
}