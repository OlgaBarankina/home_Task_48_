package com.example.home_task_48_

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* add into build gradle
         implementation 'com.squareup.retrofit2:retrofit:2.9.0'
         implementation 'com.google.code.gson:gson:2.8.6'
         implementation 'com.squareup.retrofit2:converter-gson:2.5.0'

         add into Manifest file
         <uses-permission android:name="android.permission.INTERNET" />*/

        var retrofit = RetrofitClient.getClient("https://catfact.ninja")
            .create(API::class.java)

        pbLoading.visibility = View.VISIBLE


        btGetActivity.setOnClickListener {

            retrofit.getRandomIdea().enqueue(object : Callback<ResponseMain> {// we will do it in other queue

                override fun onResponse(call: Call<ResponseMain>, response: Response<ResponseMain>)
                {
                    tvResult.text = response.body()?.fact.toString()  //put here first word
                    pbLoading.visibility = View.INVISIBLE
                    //Log.d("MyLog48", response.body()?.fact.toString())
                }

                @SuppressLint("SetTextI18n")
                override fun onFailure(call: Call<ResponseMain>, t: Throwable) {
                    tvResult.text = "onFailture"
                    pbLoading.visibility = View.INVISIBLE
                    //Log.d("MyLog48", "onFailture")
                }
            })


        }



    }
}