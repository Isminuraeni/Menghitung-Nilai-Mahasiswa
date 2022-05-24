package com.d3if1019.menghitungnilaimahasiswa.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "nilai")
data class NilaiEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var tanggal: Long = System.currentTimeMillis(),
    var praktikum: Float,
    var ass1: Float,
    var ass2: Float,
    var ass3: Float
)