package com.d3if1019.menghitungnilaimahasiswa.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.d3if1019.menghitungnilaimahasiswa.Les
import com.d3if1019.menghitungnilaimahasiswa.MainAdapter
import com.d3if1019.menghitungnilaimahasiswa.R
import com.d3if1019.menghitungnilaimahasiswa.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {
    private lateinit var binding: FragmentAboutBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentAboutBinding.inflate(layoutInflater, container, false)

        with(binding.recyclerView) {
            addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
            adapter = MainAdapter(getData())
            setHasFixedSize(true)
        }
        return binding.root
    }

    private fun getData(): List<Les> {
        return listOf(
            Les("Ganesha Operation", "Buah Batu", R.drawable.go),
            Les("Neutron", "Bojongsoang", R.drawable.neutron),
            Les("Nurul Fikri", "Arcamanik", R.drawable.nufik),
            Les("Prima Gama", "Lembang", R.drawable.primagama),
            Les("Ruang Guru", "Dago", R.drawable.ruangguru),
            Les("Kampung Inggris", "Sukabirus", R.drawable.kampung),
            Les("Sinau", "Sukapura", R.drawable.sinau),
            Les("Kumon", "Cipaganti", R.drawable.kumon),
            Les("Lolly", "Batununggal", R.drawable.lolly),
            Les("Aetugrul", "Rajamantri", R.drawable.aetugrul),
        )
    }

}