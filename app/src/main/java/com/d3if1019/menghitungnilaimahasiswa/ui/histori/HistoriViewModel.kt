package com.d3if1019.menghitungnilaimahasiswa.ui.histori

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.d3if1019.menghitungnilaimahasiswa.db.NilaiDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HistoriViewModel(private val db: NilaiDao) : ViewModel() {
    val data = db.getLastNilai()

    fun hapusData() = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            db.clearData()
        }
    }
}