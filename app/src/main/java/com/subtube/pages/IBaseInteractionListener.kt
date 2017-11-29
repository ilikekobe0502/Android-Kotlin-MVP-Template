package com.subtube.pages

import android.os.Bundle

/**
 * Created by neo_mac on 2017/11/19.
 */
interface IBaseInteractionListener {
    interface Base {
        fun showLoadingView()
        fun hideLoadingView()
        fun addFragment(container: Int, page: Int, bundle: Bundle?, addBackStack: Boolean)
        fun replaceFragment(container: Int, page: Int, bundle: Bundle?, addBackStack: Boolean)
    }

    interface Login : Base {
        fun goToSignUp(bundle: Bundle)
    }

    interface Main : Base {

    }
}