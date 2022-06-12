package com.icha.projectlsppengaduan.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [dataEntity::class], version = 1, exportSchema = false)
abstract class dataDatabase : RoomDatabase() {
    abstract fun dataDao(): dataDao

    companion object {
        @Volatile
        private var INSTANCE: dataDatabase? = null
        @JvmStatic
        fun getDatabase(context: Context): dataDatabase {
            if (INSTANCE == null) {
                synchronized(dataDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        dataDatabase::class.java, "siswa")
                        .build()
                }
            }
            return INSTANCE as dataDatabase
        }
    }
}