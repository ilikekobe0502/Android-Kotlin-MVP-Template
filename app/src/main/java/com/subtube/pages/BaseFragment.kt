package com.subtube.pages

import android.app.Fragment
import android.os.Bundle


/**
 * Created by neo_mac on 2017/11/19.
 */
abstract class BaseFragment : Fragment(), BaseContract.View {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onBackPressed() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isActive(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}