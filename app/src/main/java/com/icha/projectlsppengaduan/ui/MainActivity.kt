package com.icha.projectlsppengaduan.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.icha.projectlsppengaduan.databinding.ActivityMainBinding
import com.icha.projectlsppengaduan.helper.ViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var adapter: dataAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataInsertViewModel = obtainViewModel(this@MainActivity)
        dataInsertViewModel.getAllData().observe(this, { listdata ->
            if (listdata != null) {
                adapter.setListData(listdata)
            }
        })

        adapter = dataAdapter()
        binding.rvSiswa.layoutManager = LinearLayoutManager(this)
        binding.rvSiswa.setHasFixedSize(true)
        binding.rvSiswa.adapter = adapter

        binding.fabAdd.setOnClickListener {
            val intent = Intent(this@MainActivity, TambahDataActivity::class.java)
            startActivity(intent)
        }
    }

    private fun obtainViewModel(activity: AppCompatActivity): dataInsertViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory).get(dataInsertViewModel::class.java)
    }
}