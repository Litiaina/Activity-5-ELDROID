package com.zambo.activity5

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.zambo.activity5.databinding.ActivityViewPermissionsBinding

class ViewPermissionsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityViewPermissionsBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewPermissionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (checkPermission(Manifest.permission.READ_CONTACTS)) binding.contactsStatusTextView.text = "Contacts Permission Granted: YES" else binding.contactsStatusTextView.text = "Contacts Permission Granted: NO"
        if (checkPermission(Manifest.permission.CAMERA)) binding.cameraStatusTextView.text = "Camera Permission Granted: YES" else binding.cameraStatusTextView.text = "Camera Permission Granted: NO"
        if (checkPermission(Manifest.permission.ACCESS_FINE_LOCATION)) binding.locationStatusTextView.text = "Location Permission Granted: YES" else binding.locationStatusTextView.text = "Location Permission Granted: NO"
    }

    private fun checkPermission(permission: String): Boolean {
        return ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED
    }

}