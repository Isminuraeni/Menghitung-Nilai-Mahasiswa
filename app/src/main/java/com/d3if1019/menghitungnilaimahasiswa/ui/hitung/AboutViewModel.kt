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

    init {
        data.value = initData()
        retrieveData()
    }

    private fun retrieveData() {
        viewModelScope.launch (Dispatchers.IO) {
            try {
                val result = LesApi.service.getLes()
                Log.d("AboutViewModel", "Success: $result")
//                data.postValue(LesApi.service.getLes())
            } catch (e: Exception) {
                Log.d("AboutViewModel", "Failure: ${e.message}")
            }
        }
    }

    private fun initData(): List<Les> {
        return listOf(
            Les("Ganesha Operation", "Buah Batu", R.drawable.go),
            Les("Neutron", "Bojongsoang", R.drawable.neutron),
            Les("Nurul Fikri", "Arcamanik", R.drawable.nufik),
            Les("Prima Gama", "Lembang", R.drawable.primagama),
            Les("Ruang Guru", "Dago", R.drawable.ruangguru),
            Les("Kampung Inggris", "Sukabirus", R.drawable.kampung),
            Les("Sinau", "Sukapura", R.drawable.sinau),
            Les("Kumon", "Cipaganti", R.drawable.kumon),
            Les("Lolly", "Batununggal", R.drawable.lolly),
            Les("Aetugrul", "Rajamantri", R.drawable.aetugrul),
        )
    }

    fun getLes(): LiveData<List<Les>> = data
}