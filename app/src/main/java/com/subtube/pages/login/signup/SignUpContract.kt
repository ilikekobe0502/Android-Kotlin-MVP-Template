package com.subtube.pages.login.signup

import com.subtube.pages.BaseContract

/**
 * Created by neo_mac on 2017/11/19.
 */
interface SignUpContract {
    interface View : BaseContract.View {
        fun signUpSucceed()
        fun signUpFailed(error: String?)
    }

    interface Presenter : BaseContract.Presenter {
        fun signUp(account: String?, password: String?)
    }
}