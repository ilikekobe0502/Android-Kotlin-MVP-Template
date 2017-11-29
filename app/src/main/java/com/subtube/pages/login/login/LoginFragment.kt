package com.subtube.pages.login.login

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import com.subtube.pages.BaseFragment
import com.subtube.pages.IBaseInteractionListener
import com.subtube.R
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : BaseFragment(), LoginContract.View, View.OnClickListener {
    private val TAG: String = LoginFragment.javaClass.simpleName

    private var mEditTextViewAccount: EditText? = null
    private var mEditTextViewPassword: EditText? = null
    private var mTextViewLogin: TextView? = null

    private var mPresenter: LoginContract.Presenter? = null

    private var mInteractionListener: IBaseInteractionListener.Login? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = LoginPresenter(this)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is IBaseInteractionListener.Login) {
            mInteractionListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mInteractionListener = null
    }

    companion object {
        fun newInstance(bundle: Bundle?): LoginFragment {
            val fragment = LoginFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun loginSucceed() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loginFailed(error: String?) {
        if (mInteractionListener != null) {
            val bundle = Bundle()
            bundle.putString(LoginContract.TAG_ACCOUNT, mEditTextViewAccount?.text.toString())
            bundle.putString(LoginContract.TAG_PASSWORD, mEditTextViewPassword?.text.toString())
            mInteractionListener!!.goToSignUp(bundle)
        } else {
            Log.e(TAG, "mInteractionListener is null")
        }
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.button_login -> {
                if (!verifyAccount() && !verifyPassword())
                    mPresenter?.login(mEditTextViewAccount?.text.toString(), mEditTextViewPassword?.text.toString())
            }
        }
    }

    private fun initUI() {
        mEditTextViewAccount = account
        mEditTextViewPassword = password
        mTextViewLogin = button_login
        mTextViewLogin?.setOnClickListener(this)
    }

    private fun verifyAccount(): Boolean {
        return mEditTextViewAccount?.text.isNullOrBlank()
    }

    private fun verifyPassword(): Boolean {
        return mEditTextViewPassword?.text.isNullOrBlank()
    }
}
