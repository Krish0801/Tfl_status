package com.example.tflstatus.data.remote

import com.example.tflstatus.data.model.TflStatusModelItemModel
import retrofit2.http.GET

interface ApiRequest {
    @GET(ApiDetails.END_POINT)
    suspend fun getTflStatus() : List<TflStatusModelItemModel>
}