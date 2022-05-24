package com.d3if1019.menghitungnilaimahasiswa.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [NilaiEntity::class], version = 1, exportSchema = false)
abstract class NilaiDb : RoomDatabase() {
    abstract val dao: NilaiDao
    companion object {
        @Volatile
        private var INSTANCE: NilaiDb? = null
        fun getInstance(context: Context): NilaiDb {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        NilaiDb::class.java,
                        "nilai.db"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}