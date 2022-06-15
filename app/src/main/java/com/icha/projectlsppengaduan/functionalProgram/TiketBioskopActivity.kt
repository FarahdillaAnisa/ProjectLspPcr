package com.icha.projectlsppengaduan.functionalProgram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.icha.projectlsppengaduan.databinding.ActivityTiketBioskopBinding

class TiketBioskopActivity : AppCompatActivity() {
    private lateinit var binding : ActivityTiketBioskopBinding
    val mutableMap: MutableMap<String, Int> = mutableMapOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTiketBioskopBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        main()
    }

    fun main() {

        var film = ""
        var jumlah = 0

        binding.btnAddData.setOnClickListener {
            try {
                film = binding.edtFilm.text.toString().trim()
                jumlah = binding.edtJumlah.text.toString().toInt()
                Log.d("film", "${film}, ${jumlah}")
                mutableMap.put(film, jumlah)
                binding.edtFilm.text?.clear()
                binding.edtJumlah.text?.clear()
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "masukkan dalam format angka", Toast.LENGTH_SHORT).show()
                binding.edtJumlah.text?.clear()
            }
        }

        binding.btnPrintList.setOnClickListener {
            cetak()
        }
    }

    val cetak = {
        var text: String = ""
        for(key in mutableMap.keys) {
            val harga = mutableMap[key]?.let {jumlah -> total(jumlah) }
            text += "key: ${key}, value: ${mutableMap[key]}, Harga : ${harga}; \n"
        }
        binding.hasil.setText(text)

    }

    var total: (Int) -> Int = {jumlah -> jumlah * 25000}

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}