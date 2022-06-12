package com.icha.projectlsppengaduan.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.icha.projectlsppengaduan.databinding.ItemRowDataBinding
import com.icha.projectlsppengaduan.helper.DataDiffCallback
import com.icha.projectlsppengaduan.room.dataEntity

class dataAdapter : RecyclerView.Adapter<dataAdapter.dataViewHolder>() {
    private val listData = ArrayList<dataEntity>()
    inner class dataViewHolder(private val binding: ItemRowDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: dataEntity) {
            binding.NamaTxt.text = data.nama
            binding.SekolahTxt.text = data.sekolah
            binding.TitikKoordinatTxt.text = "${data.latitude} , ${data.longitude}"
        }
    }

    fun setListData(listData: List<dataEntity>) {
        val diffCallback = DataDiffCallback(this.listData, listData)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.listData.clear()
        this.listData.addAll(listData)
        diffResult.dispatchUpdatesTo(this)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): dataViewHolder {
        val binding = ItemRowDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return dataViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: dataViewHolder, position: Int) {
        holder.bind(listData[position])
    }
}