package com.icha.projectlsppengaduan

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class aksesOverloadingMethod: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        main()
    }

    fun main(){
        val orang = OverloadingMethod("farah")
        orang.eat()
        orang.eat("siomay")
        orang.eat("siomay", 2)
    }
}