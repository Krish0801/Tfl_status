package com.example.tflstatus.ui.mainScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tflstatus.data.model.TflStatusModelItemModel
import com.example.tflstatus.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    val repository: Repository
): ViewModel() {

    val _tflStatus = MutableStateFlow(listOf<TflStatusModelItemModel>())
    var tflStatus: StateFlow<List<TflStatusModelItemModel>> = _tflStatus

    init {
        getTflStatus()
    }

    fun getTflStatus() {

        viewModelScope.launch {
            _tflStatus.value = repository.getTflStatus()
        }
    }
}