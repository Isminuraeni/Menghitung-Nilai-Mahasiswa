package com.d3if1019.menghitungnilaimahasiswa.model

import com.d3if1019.menghitungnilaimahasiswa.db.NilaiEntity

fun NilaiEntity.hitungNilai(): HasilNilai {
    val praktikum = praktikum * 0.25
    val ass1 = ass1 * 0.20
    val ass2 = ass2 * 0.25
    val ass3 = ass3 * 0.30
    val total = praktikum + ass1 + ass2 + ass3

    return HasilNilai(total)
}