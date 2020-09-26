package com.tes.magnakarga.tesmagnakarsafe.ui.login

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.tes.magnakarga.tesmagnakarsafe.R
import com.tes.magnakarga.tesmagnakarsafe.base.BaseActivity
import com.tes.magnakarga.tesmagnakarsafe.databinding.ActivityLoginBinding
import com.tes.magnakarga.tesmagnakarsafe.model.ResponseMessage
import com.tes.magnakarga.tesmagnakarsafe.ui.main.MainActivity
import com.tes.magnakarga.tesmagnakarsafe.ui.register.RegisterActivity

class LoginActivity : BaseActivity(), LoginView {
    private lateinit var binding : ActivityLoginBinding
    private lateinit var presenter : LoginPresenter
    private var username : String? = null
    private var password : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        presenter = LoginPresenter(this)
        checkLoginState()
        initAction()
    }

    private fun checkLoginState() {
        if(mAppPreference?.getLoginState() != null && mAppPreference?.getLoginState() == "Login") {
            launchActivity(MainActivity::class.java)
            finish()
        }
    }

    private fun initAction() {
        binding.btnLogin.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                username = binding.etUsername.text.toString()
                password =  binding.etPassword.text.toString()

                if(username == "" || password == "") {
                    onMessage("Isi Field yang Kosong")
                } else {
                    presenter.login(username!!, password!!, System.currentTimeMillis()/1000)
                }
            }
        })

        binding.tvRegister.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                launchActivity(RegisterActivity::class.java)
            }
        })
    }

    override fun onSuccessLogin(msg: ResponseMessage) {
        mAppPreference?.setUserName(username)
        mAppPreference?.setLoginState("Login")

        launchActivity(MainActivity::class.java)
        finish()
    }

    override fun onFailedLogin(errMsg: String) {
        onMessage(errMsg)
    }

    override fun onShowProgressDialog() {
        showProgressDialog()
    }

    override fun onHideProgressDialog() {
        hideProgressDialog()
    }
}