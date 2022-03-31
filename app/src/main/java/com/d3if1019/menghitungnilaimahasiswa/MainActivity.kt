package com.d3if1019.menghitungnilaimahasiswa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.d3if1019.menghitungnilaimahasiswa.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonHitung.setOnClickListener{ hitungNilai() }
        binding.buttonReset.setOnClickListener{ reset()}
    }

    private fun hitungNilai() {
        val praktikum = binding.editTextPraktikum.text.toString()
        if (TextUtils.isEmpty(praktikum)){
            Toast.makeText(this, R.string.praktikum_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val ass1 = binding.editTextAss1.text.toString()
        if (TextUtils.isEmpty(ass1)){
            Toast.makeText(this, R.string.ass1_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val ass2 = binding.editTextAss2.text.toString()
        if (TextUtils.isEmpty(ass2)){
            Toast.makeText(this, R.string.ass2_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val ass3 = binding.editTextAss3.text.toString()
        if (TextUtils.isEmpty(ass3)){
            Toast.makeText(this, R.string.ass3_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val hitung = (0.25 * praktikum.toFloat()) + (0.20 * ass1.toFloat()) + (0.25 * ass2.toFloat()) + (0.30 * ass3.toFloat())

        binding.editTextHasilAngka.text = getString(R.string.hasilAngka_x, hitung)
    }

    private fun reset(){
        binding.editTextNama.setText("")
        binding.editTextNIM.setText("")
        binding.editTextPraktikum.setText("")
        binding.editTextAss1.setText("")
        binding.editTextAss2.setText("")
        binding.editTextAss3.setText("")
        binding.editTextHasilAngka.setText("")
    }
}