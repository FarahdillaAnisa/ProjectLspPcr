package com.icha.projectlsppengaduan.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.icha.projectlsppengaduan.room.dataDao
import com.icha.projectlsppengaduan.room.dataDatabase
import com.icha.projectlsppengaduan.room.dataEntity
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

//class penghubung antara ViewModel dengan database
class dataRepository(application: Application) {
    private val mdataDao: dataDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = dataDatabase.getDatabase(application)
        mdataDao = db.dataDao()
    }

    fun getAllSiswa(): LiveData<List<dataEntity>> = mdataDao.getAllSiswa()
    fun insert(data: dataEntity) {
        executorService.execute{ mdataDao.insert(data)}
    }
}