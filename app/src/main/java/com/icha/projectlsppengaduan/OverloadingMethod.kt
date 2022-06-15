package com.icha.projectlsppengaduan

class OverloadingMethod(private var nama: String) {
    fun eat() {
        println("$nama sedang makan")
    }

    fun eat(makanan : String) {
        println("$nama sedang makan $makanan")
    }

    fun eat(makanan: String, bungkus: Int) {
        println("$nama sedang makan $makanan sebanyak $bungkus bungkus")
    }

    fun getName(): String {
        return nama
    }
}

fun main() {
    val aksesEat = OverloadingMethod("icha")
    println(aksesEat.getName())
}