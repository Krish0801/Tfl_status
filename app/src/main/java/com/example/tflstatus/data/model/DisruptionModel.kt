package com.example.tflstatus.data.model


import com.google.gson.annotations.SerializedName

data class DisruptionModel(
    @SerializedName("affectedRoutes")
    val affectedRoutes: List<Any?>? = listOf(),
    @SerializedName("affectedStops")
    val affectedStops: List<Any?>? = listOf(),
    @SerializedName("category")
    val category: String? = "",
    @SerializedName("categoryDescription")
    val categoryDescription: String? = "",
    @SerializedName("closureText")
    val closureText: String? = "",
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("type")
    val type: String? = ""
)