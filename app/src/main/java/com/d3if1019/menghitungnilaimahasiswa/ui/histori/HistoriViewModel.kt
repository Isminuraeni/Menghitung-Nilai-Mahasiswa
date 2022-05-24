package com.d3if1019.menghitungnilaimahasiswa.ui.histori

import androidx.lifecycle.ViewModel
import com.d3if1019.menghitungnilaimahasiswa.db.NilaiDao

class HistoriViewModel(db: NilaiDao) : ViewModel() {
    val data = db.getLastNilai()
}