package com.tes.magnakarga.tesmagnakarsafe.ui.login

import android.util.Log
import com.google.gson.Gson
import com.tes.magnakarga.tesmagnakarsafe.model.ResponseMessage
import com.tes.magnakarga.tesmagnakarsafe.network.MyClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPresenter(val view: LoginView) {

    fun login(username : String, password : String, loginTime : Long) {
        view.onShowProgressDialog()

        MyClient.getClient()?.login(username, password, loginTime)?.enqueue(object : Callback<ResponseMessage>{
            override fun onResponse(
                call: Call<ResponseMessage>,
                response: Response<ResponseMessage>
            ) {
                view.onHideProgressDialog()
                Log.d("response", Gson().toJson(response.body()))
                if(response.isSuccessful) {
                    view.onSuccessLogin(response.body()!!)
                } else {
                    view.onFailedLogin(response.message())
                }
            }

            override fun onFailure(call: Call<ResponseMessage>, t: Throwable) {
                view.onHideProgressDialog()
                view.onFailedLogin(t.message!!)
            }
        })
    }
}