package com.tes.magnakarga.tesmagnakarsafe.ui.login

import com.tes.magnakarga.tesmagnakarsafe.base.BaseView
import com.tes.magnakarga.tesmagnakarsafe.model.ResponseMessage

interface LoginView : BaseView {
    fun onSuccessLogin(msg : ResponseMessage)
    fun onFailedLogin(errMsg : String)
}