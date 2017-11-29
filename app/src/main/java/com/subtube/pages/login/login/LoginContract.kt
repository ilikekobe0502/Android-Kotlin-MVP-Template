package com.subtube.pages.login.login

import com.subtube.pages.BaseContract

/**
 * Created by neo_mac on 2017/11/19.
 */
interface LoginContract {

    companion object {
        val TAG_ACCOUNT = "com.subtube.pages.login.login.account"
        val TAG_PASSWORD = "com.subtube.pages.login.login.password"
    }

    interface View : BaseContract.View {
        fun loginSucceed()
        fun loginFailed(error: String?)
    }

    interface Presenter : BaseContract.Presenter {
        fun login(account: String?, password: String?)
    }
}