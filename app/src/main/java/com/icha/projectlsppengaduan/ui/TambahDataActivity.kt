package com.icha.projectlsppengaduan.ui

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.icha.projectlsppengaduan.databinding.ActivityTambahDataBinding
import com.icha.projectlsppengaduan.helper.ViewModelFactory
import com.icha.projectlsppengaduan.room.dataEntity
import java.util.jar.Manifest

class TambahDataActivity : AppCompatActivity(), LocationListener {
    private lateinit var binding : ActivityTambahDataBinding
//    private lateinit var dataInsertViewModel: dataInsertViewModel
    private var dataSiswa: dataEntity? = null
    private var isLocated: Boolean = false
    private var latitude: Double = 0.0
    private var longitude: Double = 0.0

    private lateinit var locationManager: LocationManager
    private val locationPermissionCode = 2

    companion object {
        const val EXTRA_NOTE = "extra_note"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTambahDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataInsertViewModel = obtainViewModel(this@TambahDataActivity)
        dataSiswa = intent.getParcelableExtra(EXTRA_NOTE)

        binding.btnGetKoordinat.setOnClickListener {
            isLocated = true
            getLokasi()
        }

        binding.btnAddData.setOnClickListener{
            if (isLocated) {
                val nama = binding.edtNama.text.toString()
                val sekolah = binding.edtSekolah.text.toString()
//                dataSiswa.let { data->
//                    data?.nama = nama
//                    data?.sekolah = sekolah
//                    data?.latitude = latitude
//                    data?.longitude = longitude
//                }

                //CONTOH BENTUK NAMED ARGUMENT (FUNCTIONAL PROGRAMMING)
                dataSiswa = dataEntity(nama = nama, sekolah = sekolah, latitude = latitude, longitude = longitude)

                dataInsertViewModel.insert(dataSiswa as dataEntity)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(applicationContext, "Klik Tombol Dapatkan Koordinat", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getLokasi() {
        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if ((ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)) {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), locationPermissionCode)
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5f, this)
    }

    private fun obtainViewModel(activity: AppCompatActivity): dataInsertViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory).get(dataInsertViewModel::class.java)
    }

    override fun onLocationChanged(location: Location) {
        latitude = location.latitude
        longitude = location.longitude
        binding.edtKoordinat.setText("Latitude : ${latitude}, Longitude: ${longitude}")
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == locationPermissionCode) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show()
            }
        }
    }
}