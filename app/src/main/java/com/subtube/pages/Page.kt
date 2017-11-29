package com.subtube.pages

import android.os.Bundle
import com.subtube.pages.login.login.LoginFragment
import com.subtube.pages.login.signup.SignUpFragment

/**
 * Created by neo on 2017/11/21.
 */
class Page {
    companion object {

        val TAG_LOGIN: Int = 10001
        val TAG_SIGN_UP: Int = 10002

        fun getTag(page: Int): String = String.format("page_%d", page)

        fun getView(page: Int, bundle: Bundle?): BaseContract.View {
            when (page) {
                TAG_LOGIN -> return LoginFragment.newInstance(bundle)
                TAG_SIGN_UP -> return SignUpFragment.newInstance(bundle)
                else -> {
                    throw IllegalArgumentException("No match view ! page = " + page)
                }
            }
        }
    }
}