package com.tes.magnakarga.tesmagnakarsafe.ui.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.tes.magnakarga.tesmagnakarsafe.R
import com.tes.magnakarga.tesmagnakarsafe.base.BaseActivity
import com.tes.magnakarga.tesmagnakarsafe.databinding.ActivityRegisterBinding
import com.tes.magnakarga.tesmagnakarsafe.model.ResponseMessage
import com.tes.magnakarga.tesmagnakarsafe.ui.main.MainActivity

class RegisterActivity : BaseActivity(), RegisterView {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var presenter : RegisterPresenter
    private var username : String? = null
    private var password : String? = null
    private var passwordRepeat : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register)
        presenter = RegisterPresenter(this)
        initAction()
    }

    private fun initAction() {
        binding.btnRegister.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                username = binding.etUsername.text.toString()
                password =  binding.etPassword.text.toString()
                passwordRepeat = binding.etPasswordRepeat.text.toString()

                if(username == "" || password == "" || passwordRepeat == "") {
                    onMessage("Isi Field yang Kosong")
                } else if(!password.equals(passwordRepeat)) {
                    onMessage("Password tidak sama")
                } else {
                    presenter.register(username!!, password!!, System.currentTimeMillis()/1000)
                }
            }
        })
    }

    override fun onSuccessRegister(responseMessage: ResponseMessage) {
        mAppPreference?.setUserName(username)
        mAppPreference?.setLoginState("Login")

        launchActivity(MainActivity::class.java)
        finish()
    }

    override fun onFailedRegister(errMessage: String) {
        onMessage(errMessage)
    }

    override fun onShowProgressDialog() {
        showProgressDialog()
    }

    override fun onHideProgressDialog() {
        hideProgressDialog()
    }
}