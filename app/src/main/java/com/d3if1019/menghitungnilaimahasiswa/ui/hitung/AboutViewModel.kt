package com.d3if1019.menghitungnilaimahasiswa.ui.hitung

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.d3if1019.menghitungnilaimahasiswa.R
import com.d3if1019.menghitungnilaimahasiswa.model.Les
import com.d3if1019.menghitungnilaimahasiswa.network.LesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AboutViewModel : ViewModel() {

    private val data = MutableLiveData<List<Les>>()
    private val status = MutableLiveData<LesApi.ApiStatus>()


    init {
        retrieveData()
    }

    private fun retrieveData() {
        viewModelScope.launch (Dispatchers.IO) {
            status.postValue(LesApi.ApiStatus.LOADING)
            try {
                data.postValue(LesApi.service.getLes())
                status.postValue(LesApi.ApiStatus.SUCCESS)
            } catch (e: Exception) {
                Log.d("AboutViewModel", "Failure: ${e.message}")
                status.postValue(LesApi.ApiStatus.FAILED)
            }
        }
    }

    fun getLes(): LiveData<List<Les>> = data
    fun getStatus(): LiveData<LesApi.ApiStatus> = status
}