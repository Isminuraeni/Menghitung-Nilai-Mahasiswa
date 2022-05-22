package com.d3if1019.menghitungnilaimahasiswa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.d3if1019.menghitungnilaimahasiswa.databinding.ActivityMainBinding
import com.d3if1019.menghitungnilaimahasiswa.model.HasilNilai

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonHitung.setOnClickListener{ hitungNilai() }
        binding.buttonReset.setOnClickListener{ reset()}

        viewModel.getHasilNilai().observe(this, { showResult(it) })
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

        viewModel.hitungNilai(
            praktikum.toFloat(),
            ass1.toFloat(),
            ass2.toFloat(),
            ass3.toFloat()
        )
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

    private fun showResult(result: HasilNilai?){
        if (result == null) return
        binding.editTextHasilAngka.text = getString(R.string.hasilAngka_x, result.hasil)
    }
}