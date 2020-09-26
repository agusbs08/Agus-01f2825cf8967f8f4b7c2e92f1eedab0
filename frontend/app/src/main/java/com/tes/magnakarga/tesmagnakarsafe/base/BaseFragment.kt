package com.tes.magnakarga.tesmagnakarsafe.base

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.tes.magnakarga.tesmagnakarsafe.R
import com.tes.magnakarga.tesmagnakarsafe.app.AppPreference

open class BaseFragment : Fragment() {
    private var mProgressDialog: ProgressDialog? = null
    var mAppPreference: AppPreference? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mAppPreference = AppPreference(context!!)
        mProgressDialog = ProgressDialog(activity)
        mProgressDialog!!.setMessage("Please Wait")
        mProgressDialog!!.setCancelable(true)
        mProgressDialog!!.setCanceledOnTouchOutside(false)
    }

    fun launchActivity(cls: Class<*>?) {
        val i = Intent(activity, cls)
        startActivity(i)
    }

    fun launchActivity(bundle: Bundle?, cls: Class<*>?) {
        val i = Intent(activity, cls)
        if (bundle != null) {
            i.putExtras(bundle)
        }
        startActivity(i)
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
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}