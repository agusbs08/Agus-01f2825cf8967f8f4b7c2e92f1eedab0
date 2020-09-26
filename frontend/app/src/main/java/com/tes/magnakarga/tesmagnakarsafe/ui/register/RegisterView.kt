package com.tes.magnakarga.tesmagnakarsafe.ui.register

import com.tes.magnakarga.tesmagnakarsafe.base.BaseView
import com.tes.magnakarga.tesmagnakarsafe.model.ResponseMessage

interface RegisterView : BaseView {
    fun onSuccessRegister(responseMessage: ResponseMessage)
    fun onFailedRegister(errMessage : String)
}