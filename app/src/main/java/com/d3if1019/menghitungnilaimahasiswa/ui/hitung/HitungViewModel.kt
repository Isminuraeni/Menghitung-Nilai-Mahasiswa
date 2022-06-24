package com.d3if1019.menghitungnilaimahasiswa.ui.hitung

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.d3if1019.menghitungnilaimahasiswa.db.NilaiDao
import com.d3if1019.menghitungnilaimahasiswa.db.NilaiEntity
import com.d3if1019.menghitungnilaimahasiswa.model.HasilNilai
import com.d3if1019.menghitungnilaimahasiswa.model.hitungNilai
import com.d3if1019.menghitungnilaimahasiswa.network.LesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HitungViewModel(private val db: NilaiDao) : ViewModel() {

    private val hasilNilai = MutableLiveData<HasilNilai?>()

    fun hitungNilai(praktikum: Float, ass1: Float, ass2: Float, ass3: Float) {

        val dataNilai = NilaiEntity(
            praktikum = praktikum,
            ass1 = ass1,
            ass2 = ass2,
            ass3 = ass3
        )

        hasilNilai.value = dataNilai.hitungNilai()

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                db.insert(dataNilai)
            }
        }
    }

    fun getHasilNilai(): LiveData<HasilNilai?> = hasilNilai
}

