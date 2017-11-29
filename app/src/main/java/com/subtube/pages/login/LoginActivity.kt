package com.subtube.pages.login

import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.ProgressBar
import com.subtube.R
import com.subtube.pages.BaseActivity
import com.subtube.pages.IBaseInteractionListener
import com.subtube.pages.Page
import kotlinx.android.synthetic.main.activity_login.*

/**
 * A login screen that offers login via email/password.
 */
class LoginActivity : BaseActivity(), IBaseInteractionListener.Login {

    private var mContainer: FrameLayout? = null
    private var mLoadingView: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        mContainer = layout_container
        mLoadingView = login_progress

        addFragment(R.id.layout_container, Page.TAG_LOGIN, null, false)
    }

    override fun goToSignUp(bundle: Bundle) {
        replaceFragment(R.id.layout_container, Page.TAG_SIGN_UP, bundle, true)
    }

    override fun showLoadingView() {
        if (mLoadingView != null && !mLoadingView?.isShown!!)
            mLoadingView?.visibility = View.VISIBLE
    }

    override fun hideLoadingView() {
        if (mLoadingView != null && mLoadingView?.isShown!!)
            mLoadingView?.visibility = View.GONE
    }
}
