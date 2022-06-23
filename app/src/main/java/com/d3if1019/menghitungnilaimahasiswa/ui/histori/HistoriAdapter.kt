package com.d3if1019.menghitungnilaimahasiswa.ui.histori

import android.annotation.SuppressLint
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.d3if1019.menghitungnilaimahasiswa.R
import com.d3if1019.menghitungnilaimahasiswa.databinding.ItemHistoriBinding
import com.d3if1019.menghitungnilaimahasiswa.db.NilaiEntity
import com.d3if1019.menghitungnilaimahasiswa.model.hitungNilai
import java.text.SimpleDateFormat
import java.util.*

class HistoriAdapter :
    ListAdapter<NilaiEntity, HistoriAdapter.ViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK =
            object : DiffUtil.ItemCallback<NilaiEntity>() {
                override fun areItemsTheSame(
                    oldData: NilaiEntity, newData: NilaiEntity
                ): Boolean {
                    return oldData.id == newData.id
                }
                override fun areContentsTheSame(
                    oldData: NilaiEntity, newData: NilaiEntity
                ): Boolean {
                    return oldData == newData
                }
            }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHistoriBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: ItemHistoriBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private val dateFormatter = SimpleDateFormat("dd MMMM yyyy",
            Locale("id", "ID")
        )

        fun bind(item: NilaiEntity) = with(binding) {
            val hasilEntity = item.hitungNilai()

            tanggalTextView.text = dateFormatter.format(Date(item.tanggal))

            rataTextView.text = root.context.getString(R.string.hasil_x, hasilEntity.hasil)

            dataTextView.text = root.context.getString(R.string.data_x, item.praktikum, item.ass1, item.ass2, item.ass3)
        }
    }
}