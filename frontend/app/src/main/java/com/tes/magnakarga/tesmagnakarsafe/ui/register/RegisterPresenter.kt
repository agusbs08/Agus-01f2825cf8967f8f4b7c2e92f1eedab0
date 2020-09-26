package com.tes.magnakarga.tesmagnakarsafe.ui.register

import com.tes.magnakarga.tesmagnakarsafe.model.Register
import com.tes.magnakarga.tesmagnakarsafe.model.ResponseMessage
import com.tes.magnakarga.tesmagnakarsafe.network.MyClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterPresenter(val view: RegisterView) {

    fun register(username : String, password : String, loginTime : Long) {
        view.onHideProgressDialog()
        val register = Register(username, password, loginTime)
        MyClient.getClient()?.register(register)?.enqueue(object : Callback<ResponseMessage> {
            override fun onResponse(
                call: Call<ResponseMessage>,
                response: Response<ResponseMessage>
            ) {
                view.onHideProgressDialog()
                if(response.isSuccessful) {
                    view.onSuccessRegister(response.body()!!)
                } else {
                    view.onFailedRegister(response.message())
                }
            }

            override fun onFailure(call: Call<ResponseMessage>, t: Throwable) {
                view.onHideProgressDialog()
                view.onFailedRegister(t.message!!)
            }
        })

    }
}