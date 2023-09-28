package com.example.tflstatus.data.model


import com.google.gson.annotations.SerializedName

data class CrowdingModel(
    @SerializedName("type")
    val type: String? = ""
)