package com.icha.projectlsppengaduan.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface dataDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(dataEntity: dataEntity)

    @Query("SELECT * from siswa ORDER BY id ASC")
    fun getAllSiswa(): LiveData<List<dataEntity>>
}