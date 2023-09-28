package com.example.tflstatus.data.repository

import com.example.tflstatus.data.model.TflStatusModelItemModel

interface Repository {
    suspend fun getTflStatus(): List<TflStatusModelItemModel>
}