package com.subtube.pages

import android.app.Fragment
import android.app.FragmentManager
import android.app.FragmentTransaction
import android.os.Bundle
import android.os.Handler
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.subtube.R

/**
 * Created by neo_mac on 2017/11/21.
 */
abstract class BaseActivity : AppCompatActivity(), IBaseInteractionListener.Base {

    private var mDoubleBackToExitPressedOnce: Boolean = false

    override fun addFragment(container: Int, page: Int, bundle: Bundle?, addBackStack: Boolean) {
        val manager: FragmentManager = fragmentManager
        val transaction: FragmentTransaction = manager.beginTransaction()
        val tag: String = Page.getTag(page)

        transaction.add(container, Page.getView(page, bundle) as Fragment, tag)
        if (addBackStack)
            transaction.addToBackStack(tag)

        transaction.commit()
    }

    override fun replaceFragment(container: Int, page: Int, bundle: Bundle?, addBackStack: Boolean) {
        val manager: FragmentManager = fragmentManager
        val transaction: FragmentTransaction = manager.beginTransaction()
        val tag: String = Page.getTag(page)

        transaction.replace(container, Page.getView(page, bundle) as Fragment, tag)
        if (addBackStack)
            transaction.addToBackStack(tag)

        transaction.commit()
    }

    override fun onBackPressed() {
        if (fragmentManager.backStackEntryCount == 0) {
            Snackbar.make(findViewById(android.R.id.content), getString(R.string.back_double_press), Snackbar.LENGTH_SHORT).show()

            if (mDoubleBackToExitPressedOnce) {
                super.onBackPressed()
            } else {
                mDoubleBackToExitPressedOnce = true

                Handler().postDelayed({ mDoubleBackToExitPressedOnce = false }, 2000)
            }
        } else {
            super.onBackPressed()
        }
    }
}