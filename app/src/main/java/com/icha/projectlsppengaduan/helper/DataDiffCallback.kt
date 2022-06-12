package com.icha.projectlsppengaduan.helper

import androidx.recyclerview.widget.DiffUtil
import com.icha.projectlsppengaduan.room.dataEntity

class DataDiffCallback(private val mOldDataList: List<dataEntity>, private val mNewDataList: List<dataEntity>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return mOldDataList.size
    }
    override fun getNewListSize(): Int {
        return mNewDataList.size
    }
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return mOldDataList[oldItemPosition].id == mNewDataList[newItemPosition].id
    }
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldSiswa = mOldDataList[oldItemPosition]
        val newSiswa = mNewDataList[newItemPosition]
        return oldSiswa.nama == newSiswa.nama && oldSiswa.sekolah == newSiswa.sekolah && oldSiswa.latitude == newSiswa.latitude && oldSiswa.longitude == newSiswa.longitude
    }
}