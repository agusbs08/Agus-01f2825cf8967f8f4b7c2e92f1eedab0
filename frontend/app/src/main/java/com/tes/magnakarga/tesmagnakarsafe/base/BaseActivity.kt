package com.tes.magnakarga.tesmagnakarsafe.base

import android.app.ProgressDialog
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.tes.magnakarga.tesmagnakarsafe.ui.main.MainActivity
import com.tes.magnakarga.tesmagnakarsafe.app.AppPreference

open class BaseActivity : AppCompatActivity() {

    var mAppPreference: AppPreference? = null
    private var mProgressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        mAppPreference = AppPreference(this)
        mProgressDialog = ProgressDialog(this)
        mProgressDialog!!.setMessage("Please Wait")
        mProgressDialog!!.setCancelable(true)
        mProgressDialog!!.setCanceledOnTouchOutside(false)
    }

    fun goHome() {
        launchActivity(MainActivity::class.java)
    }

    fun launchActivity(cls: Class<*>?) {
        val i = Intent(this@BaseActivity, cls)
        startActivity(i)
    }

    fun launchActivity(bundle: Bundle?, cls: Class<*>?) {
        val i = Intent(this@BaseActivity, cls)
        if (bundle != null) {
            i.putExtras(bundle)
        }
        startActivity(i)
    }

    protected fun replaceFragment(
        @IdRes containerViewId: Int,
        fragment: Fragment,
        fragmentTag: String,
        backStackStateName: String?
    ) {
        supportFragmentManager
            .beginTransaction()
            .replace(containerViewId, fragment, fragmentTag)
            .addToBackStack(backStackStateName)
            .commit()
    }

    fun showProgressDialog() {
        if (mProgressDialog != null) {
            try {
                mProgressDialog!!.show()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun hideProgressDialog() {
        if (mProgressDialog != null) {
            try {
                mProgressDialog!!.dismiss()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun onMessage(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}