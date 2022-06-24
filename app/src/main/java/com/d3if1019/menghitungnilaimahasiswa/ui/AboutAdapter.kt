package com.d3if1019.menghitungnilaimahasiswa.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.d3if1019.menghitungnilaimahasiswa.R
import com.d3if1019.menghitungnilaimahasiswa.databinding.ListItemBinding
import com.d3if1019.menghitungnilaimahasiswa.model.Les
import com.d3if1019.menghitungnilaimahasiswa.network.LesApi

class AboutAdapter : RecyclerView.Adapter<AboutAdapter.ViewHolder>() {

    private val data = mutableListOf<Les>()
    @SuppressLint("NotifyDataSetChanged")
    fun updateData(newData: List<Les>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    class ViewHolder(
        private val binding: ListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(les: Les) = with(binding) {
            namaTextView.text = les.nama
            alamatTextView.text = les.alamat

            Glide.with(imageView.context)
                .load(LesApi.getLesUrl(les.imageId))
                .error(R.drawable.ic_baseline_broken_image_24)
                .into(imageView)

            root.setOnClickListener {
                val message = root.context.getString(R.string.message, les.nama)
                Toast.makeText(root.context, message, Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }
    override fun getItemCount(): Int {
        return data.size
    }
}