package com.tes.magnakarga.tesmagnakarsafe.network

import com.tes.magnakarga.tesmagnakarsafe.model.Register
import com.tes.magnakarga.tesmagnakarsafe.model.ResponseMessage
import com.tes.magnakarga.tesmagnakarsafe.model.Tes
import com.tes.magnakarga.tesmagnakarsafe.model.User
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query


interface RestAPI {

    @GET("tes")
    fun getTes() : Call<MutableList<Tes>>?

    @GET("users/login")
    fun login(@Query("username") username : String, @Query("password") password : String, @Query("logintime") logintime : Long) : Call<ResponseMessage>?

    @POST("users/register")
    fun register(@Body register: Register) : Call<ResponseMessage>?

    @GET("users/hello")
    fun hello(@Query("username") username : String) : Call<User>?
}