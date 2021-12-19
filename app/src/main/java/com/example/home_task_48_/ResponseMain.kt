package com.example.home_task_48_

import com.google.gson.annotations.SerializedName

data class ResponseMain (

    @SerializedName("fact") val fact: String,
    @SerializedName("length") val length: Int

)