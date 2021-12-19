package com.example.home_task_48_

import retrofit2.Call
import retrofit2.http.GET

interface API {
    @GET("fact")
    fun getRandomIdea(): Call<ResponseMain>
}