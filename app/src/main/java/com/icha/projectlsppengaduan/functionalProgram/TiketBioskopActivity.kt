package com.icha.projectlsppengaduan.functionalProgram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.icha.projectlsppengaduan.R
import com.icha.projectlsppengaduan.databinding.ActivityTiketBioskopBinding

class TiketBioskopActivity : AppCompatActivity() {
    private lateinit var binding : ActivityTiketBioskopBinding
    private var list: MutableMap<String, String> = mutableMapOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTiketBioskopBinding.inflate(layoutInflater)
        setContentView(binding.root)

        main()
    }

    fun main() {
        val mutableMap: MutableMap<String, String> = mutableMapOf()

        binding.btnAddData.setOnClickListener {
            val film = binding.edtFilm.text.toString().trim()
            val jumlah = binding.edtJumlah.text.toString().trim()
            Log.d("film", "${film}, ${jumlah}")
            mutableMap.put(film, jumlah)
            binding.edtFilm.text?.clear()
            binding.edtJumlah.text?.clear()
        }

        binding.btnPrintList.setOnClickListener {
            var text: String = ""
            for(key in mutableMap.keys) {
                text += println("key: ${key}, value: ${mutableMap[key]}")
            }
            binding.hasil.setText(text)
        }
    }

//    fun addTicket(film : String, jumlah: String): MutableMap<String, String> {
//        val mutableMap: MutableMap<String, String> = mutableMapOf<String, String>()
//        mutableMap.put(film, jumlah)
//        return mutableMap
//    }
}