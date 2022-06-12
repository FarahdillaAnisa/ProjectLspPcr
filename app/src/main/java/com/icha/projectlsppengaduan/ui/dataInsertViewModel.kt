package com.icha.projectlsppengaduan.ui

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.icha.projectlsppengaduan.repository.dataRepository
import com.icha.projectlsppengaduan.room.dataEntity

class dataInsertViewModel(application: Application): ViewModel() {
    private val mdataRepository: dataRepository = dataRepository(application)

    fun insert(data: dataEntity) {
        mdataRepository.insert(data)
    }

    fun getAllData(): LiveData<List<dataEntity>> = mdataRepository.getAllSiswa()
}