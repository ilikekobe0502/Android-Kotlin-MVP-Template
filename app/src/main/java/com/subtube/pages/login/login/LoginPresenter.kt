package com.subtube.pages.login.login

import com.subtube.pages.BasePresenter

/**
 * Created by neo_mac on 2017/11/19.
 */
class LoginPresenter(view: LoginContract.View) : BasePresenter(), LoginContract.Presenter {

    var mView: LoginContract.View? = view

    override fun login(account: String?, password: String?) {
        mView?.loginFailed("Error")
    }
}