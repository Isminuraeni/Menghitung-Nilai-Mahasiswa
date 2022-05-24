package com.d3if1019.menghitungnilaimahasiswa.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NilaiDao {
    @Insert
    fun insert(nilai: NilaiEntity)
    @Query("SELECT * FROM nilai ORDER BY id DESC LIMIT 1")
    fun getLastNilai(): LiveData<NilaiEntity?>
}
