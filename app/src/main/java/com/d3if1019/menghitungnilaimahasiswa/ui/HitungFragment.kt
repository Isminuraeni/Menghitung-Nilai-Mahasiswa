package com.d3if1019.menghitungnilaimahasiswa.ui

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.d3if1019.menghitungnilaimahasiswa.R
import com.d3if1019.menghitungnilaimahasiswa.databinding.FragmentHitungBinding
import com.d3if1019.menghitungnilaimahasiswa.model.HasilNilai

class HitungFragment : Fragment() {

    private lateinit var binding: FragmentHitungBinding

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(requireActivity())[MainViewModel::class.java]

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHitungBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.buttonHitung.setOnClickListener { hitungNilai() }
        binding.aboutButton.setOnClickListener {
            it.findNavController().navigate(
                R.id.action_hitungFragment_to_aboutFragment
            )
        }
        binding.buttonReset.setOnClickListener { reset() }
        viewModel.getHasilNilai().observe(requireActivity(), {showResult(it)})
    }

    private fun hitungNilai() {
        val praktikum = binding.editTextPraktikum.text.toString()
        if (TextUtils.isEmpty(praktikum)){
            Toast.makeText(context, R.string.praktikum_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val ass1 = binding.editTextAss1.text.toString()
        if (TextUtils.isEmpty(ass1)){
            Toast.makeText(context, R.string.ass1_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val ass2 = binding.editTextAss2.text.toString()
        if (TextUtils.isEmpty(ass2)){
            Toast.makeText(context, R.string.ass2_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val ass3 = binding.editTextAss3.text.toString()
        if (TextUtils.isEmpty(ass3)){
            Toast.makeText(context, R.string.ass3_invalid, Toast.LENGTH_LONG).show()
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
        binding.aboutButton.visibility = View.VISIBLE
    }
}