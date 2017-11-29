package com.subtube.pages.login.signup

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import com.subtube.pages.BaseFragment
import com.subtube.pages.IBaseInteractionListener
import com.subtube.R
import com.subtube.pages.login.login.LoginContract
import kotlinx.android.synthetic.main.fragment_sign_up.*

class SignUpFragment : BaseFragment(), SignUpContract.View, View.OnClickListener {
    private var mEditTextViewAccount: EditText? = null
    private var mEditTextViewPassword: EditText? = null
    private var mTextViewSignUp: TextView? = null

    private var mPresenter: SignUpContract.Presenter? = null

    private var mListener: IBaseInteractionListener.Login? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = SignUpPresenter(this)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is IBaseInteractionListener.Login) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    companion object {
        fun newInstance(bundle: Bundle?): SignUpFragment {
            val fragment = SignUpFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.button_login -> {
            }
        }
    }

    override fun signUpSucceed() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun signUpFailed(error: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun initUI() {
        mEditTextViewAccount = account
        mEditTextViewPassword = password
        mTextViewSignUp = signUp

        mEditTextViewAccount?.setText(arguments.getString(LoginContract.TAG_ACCOUNT))
        mEditTextViewPassword?.setText(arguments.getString(LoginContract.TAG_PASSWORD))
    }
}
