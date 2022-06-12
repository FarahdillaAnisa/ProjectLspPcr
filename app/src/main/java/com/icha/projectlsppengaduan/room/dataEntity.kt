package com.icha.projectlsppengaduan.room

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "siswa")
@Parcelize
data class dataEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,

    @ColumnInfo(name = "nama")
    var nama: String? = null,

    @ColumnInfo(name = "asalsekolah")
    var sekolah: String? = null,

    @ColumnInfo(name = "latitude")
    var latitude: Double? = 0.0,

    @ColumnInfo(name = "longitude")
    var longitude: Double? = 0.0
) : Parcelable