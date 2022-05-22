package com.d3if1019.menghitungnilaimahasiswa.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.d3if1019.menghitungnilaimahasiswa.model.HasilNilai

class MainViewModel : ViewModel() {

    private val hasilNilai = MutableLiveData<HasilNilai?>()

    fun hitungNilai(praktikum: Float, ass1: Float, ass2: Float, ass3: Float) {
        val praktikum = praktikum * 0.25
        val ass1 = ass1 * 0.20
        val ass2 = ass2 * 0.25
        val ass3 = ass3 * 0.30
        val total = praktikum + ass1 + ass2 + ass3
        hasilNilai.value = HasilNilai(total)
    }

    fun getHasilNilai(): LiveData<HasilNilai?> = hasilNilai
}