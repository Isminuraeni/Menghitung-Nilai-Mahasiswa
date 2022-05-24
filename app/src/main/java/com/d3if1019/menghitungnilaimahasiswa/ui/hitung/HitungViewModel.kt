package com.d3if1019.menghitungnilaimahasiswa.ui.hitung

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.d3if1019.menghitungnilaimahasiswa.db.NilaiDao
import com.d3if1019.menghitungnilaimahasiswa.db.NilaiEntity
import com.d3if1019.menghitungnilaimahasiswa.model.HasilNilai
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HitungViewModel(private val db: NilaiDao) : ViewModel() {

    private val hasilNilai = MutableLiveData<HasilNilai?>()

    val data = db.getLastNilai()

    fun hitungNilai(praktikum: Float, ass1: Float, ass2: Float, ass3: Float) {
        val praktikum = praktikum * 0.25
        val ass1 = ass1 * 0.20
        val ass2 = ass2 * 0.25
        val ass3 = ass3 * 0.30
        val total = praktikum + ass1 + ass2 + ass3
        hasilNilai.value = HasilNilai(total)

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val dataNilai = NilaiEntity(
                    praktikum = praktikum,
                    ass1 = ass1,
                    ass2 = ass2,
                    ass3 = ass3
                )
                db.insert(dataNilai)
            }
        }
    }

    fun getHasilNilai(): LiveData<HasilNilai?> = hasilNilai
}