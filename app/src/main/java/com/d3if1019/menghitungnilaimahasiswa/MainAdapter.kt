package com.d3if1019.menghitungnilaimahasiswa

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.d3if1019.menghitungnilaimahasiswa.databinding.ListItemBinding

class MainAdapter (private val data: List<Les>) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    class ViewHolder(
        private val binding: ListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(les: Les) = with(binding) {
            namaTextView.text = les.nama
            alamatTextView.text = les.alamat
            imageView.setImageResource(les.imageResId)

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