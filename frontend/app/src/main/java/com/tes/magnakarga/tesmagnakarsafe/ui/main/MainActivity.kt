package com.tes.magnakarga.tesmagnakarsafe.ui.main

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.databinding.DataBindingUtil
import com.tes.magnakarga.tesmagnakarsafe.R
import com.tes.magnakarga.tesmagnakarsafe.base.BaseActivity
import com.tes.magnakarga.tesmagnakarsafe.databinding.ActivityMainBinding
import com.tes.magnakarga.tesmagnakarsafe.model.User
import com.tes.magnakarga.tesmagnakarsafe.network.MyClient
import retrofit2.Call
import java.util.*
import retrofit2.Callback
import retrofit2.Response

class MainActivity : BaseActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val mainHandler = Handler(Looper.getMainLooper())

        mainHandler.post(object : Runnable {
            override fun run() {
                val date = Date()
                val calendar = Calendar.getInstance()
                calendar.time = date
                val hours: Int = calendar.get(Calendar.HOUR_OF_DAY)
                val minute : Int = calendar.get(Calendar.MINUTE)
                val second : Int = calendar.get(Calendar.SECOND)

                binding.tvWaktuJam.text = hours.toString()
                binding.tvWaktuMenit.text = minute.toString()
                binding.tvWaktuDetik.text = second.toString()

                mainHandler.postDelayed(this, 1000)
            }
        })

        val ts = System.currentTimeMillis()

        binding.btnHello.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                hideProgressDialog()

                MyClient.getClient()?.hello(mAppPreference?.getUsername()!!)?.enqueue(object : Callback<User>{
                    override fun onResponse(call: Call<User>, response: Response<User>) {
                        if(response.isSuccessful){
                            onMessage("Hello " + response.body()?.username + ", " + response.body()?.loginTime.toString())
                        }
                    }

                    override fun onFailure(call: Call<User>, t: Throwable) {
                        onMessage("Gagal fecth data")
                    }
                })
            }
        })
    }

    fun hello() {

    }
}