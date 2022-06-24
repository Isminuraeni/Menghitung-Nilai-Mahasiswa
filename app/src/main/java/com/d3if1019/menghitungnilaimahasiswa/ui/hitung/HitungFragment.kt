package com.d3if1019.menghitungnilaimahasiswa.ui.hitung

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.d3if1019.menghitungnilaimahasiswa.R
import com.d3if1019.menghitungnilaimahasiswa.databinding.FragmentHitungBinding
import com.d3if1019.menghitungnilaimahasiswa.db.NilaiDb
import com.d3if1019.menghitungnilaimahasiswa.model.HasilNilai
import com.d3if1019.menghitungnilaimahasiswa.ui.histori.HistoriAdapter

class HitungFragment : Fragment() {

    private lateinit var binding: FragmentHitungBinding
    private lateinit var myAdapter: HistoriAdapter

    private val viewModel: HitungViewModel by lazy {
        val db = NilaiDb.getInstance(requireContext())
        val factory = HitungViewModelFactory(db.dao)
        ViewModelProvider(this, factory)[HitungViewModel::class.java]

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHitungBinding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.buttonHitung.setOnClickListener { hitungNilai() }
        binding.aboutButton.setOnClickListener {
            it.findNavController().navigate(
                R.id.action_hitungFragment_to_aboutFragment
            )
        }
        binding.shareButton.setOnClickListener { shareData() }
        binding.buttonReset.setOnClickListener { reset() }
        viewModel.getHasilNilai().observe(requireActivity()) { showResult(it) }
        viewModel.scheduleUpdater(requireActivity().application)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_histori -> {
                findNavController().navigate (R.id.action_hitungFragment_to_historiFragment)
                return true
            }

            R.id.menu_profil -> {
                findNavController().navigate (R.id.action_hitungFragment_to_profilFragment)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
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
        binding.editTextHasilAngka.text = ""
    }

    private fun showResult(result: HasilNilai?){
        if (result == null) return
        binding.editTextHasilAngka.text = getString(R.string.hasilAngka_x, result.hasil)
        binding.buttonGroup.visibility = View.VISIBLE
    }

    @SuppressLint("QueryPermissionsNeeded")
    private fun shareData(){
        val message = getString(
            R.string.bagikan_template,
            binding.editTextNama.text,
            binding.editTextNIM.text,
            binding.editTextPraktikum.text,
            binding.editTextAss1.text,
            binding.editTextAss2.text,
            binding.editTextAss3.text)

        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain").putExtra(Intent.EXTRA_TEXT, message)
        if (shareIntent.resolveActivity(
                requireActivity().packageManager) != null) {
            startActivity(shareIntent)
        }
    }
}