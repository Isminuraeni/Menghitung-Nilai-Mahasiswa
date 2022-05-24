package com.d3if1019.menghitungnilaimahasiswa.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "nilai")
data class NilaiEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var tanggal: Long = System.currentTimeMillis(),
    var praktikum: Double,
    var ass1: Double,
    var ass2: Double,
    var ass3: Double
)