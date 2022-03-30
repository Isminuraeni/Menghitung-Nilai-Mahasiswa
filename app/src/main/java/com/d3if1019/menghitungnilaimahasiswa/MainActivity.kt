package com.d3if1019.menghitungnilaimahasiswa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.d3if1019.menghitungnilaimahasiswa.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonHitung.setOnClickListener{ hitungNilai() }
    }

    private fun hitungNilai() {
        Log.d("MainActivity", "Tombol diklik!")
    }
}