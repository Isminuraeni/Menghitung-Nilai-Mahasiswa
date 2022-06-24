package com.d3if1019.menghitungnilaimahasiswa.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.d3if1019.menghitungnilaimahasiswa.databinding.FragmentAboutBinding
import com.d3if1019.menghitungnilaimahasiswa.ui.hitung.AboutViewModel

class AboutFragment : Fragment() {
    private val viewModel: AboutViewModel by lazy {
        ViewModelProvider(this)[AboutViewModel::class.java]
    }

    private lateinit var binding: FragmentAboutBinding
    private lateinit var myAdapter: AboutAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View {
        binding = FragmentAboutBinding.inflate(layoutInflater, container, false)
        myAdapter = AboutAdapter()

        with(binding.recyclerView) {
            addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
            adapter = myAdapter
            setHasFixedSize(true)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getLes().observe(viewLifecycleOwner) {
            myAdapter.updateData(it)
        }
    }

}