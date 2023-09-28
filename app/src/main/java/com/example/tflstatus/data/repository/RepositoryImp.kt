package com.example.tflstatus.data.repository

import com.example.tflstatus.data.model.TflStatusModelItemModel
import com.example.tflstatus.data.remote.ApiRequest
import javax.inject.Inject

class RepositoryImp @Inject constructor(
    val apiRequest: ApiRequest
): Repository {
    override suspend fun getTflStatus(): List<TflStatusModelItemModel> = apiRequest.getTflStatus()
}