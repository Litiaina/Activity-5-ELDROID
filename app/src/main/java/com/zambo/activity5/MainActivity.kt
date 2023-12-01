package com.zambo.activity5

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.zambo.activity5.databinding.ActivityMainBinding

const val CONTACTS_PERMISSION_CODE = 1000
const val CAMERA_PERMISSION_CODE = 1001
const val LOCATION_PERMISSION_CODE = 1002

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.contactsButton.setOnClickListener {
            requestPermissions(Manifest.permission.READ_CONTACTS, CONTACTS_PERMISSION_CODE)
        }

        binding.cameraButton.setOnClickListener {
            requestPermissions(Manifest.permission.CAMERA, CAMERA_PERMISSION_CODE)
        }

        binding.locationButton.setOnClickListener {
            requestPermissions(Manifest.permission.ACCESS_FINE_LOCATION, LOCATION_PERMISSION_CODE)
        }

        binding.viewPermissionsButton.setOnClickListener {
            startActivity(Intent(this, ViewPermissionsActivity::class.java))
        }

    }

    private fun requestPermissions(permission: String, permissionCode: Int) {
        if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(permission), permissionCode)
        } else {
            Toast.makeText(this, "$permission already granted", Toast.LENGTH_SHORT).show()
        }
    }

}