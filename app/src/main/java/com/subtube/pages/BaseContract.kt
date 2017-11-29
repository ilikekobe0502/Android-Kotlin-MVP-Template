package com.subtube.pages

/**
 * Created by neo_mac on 2017/11/19.
 */
interface BaseContract {
    interface View {
        fun onBackPressed()

        fun isActive(): Boolean
    }

    interface Presenter {
    }
}