package com.example.skripsimuhammadiqbal.Crud

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.skripsimuhammadiqbal.databinding.ItemDataBinding

class DataAdapter(
    private val data: List<DataItem>?,
    private val click: onClickItem
) : RecyclerView.Adapter<DataAdapter.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemDataBinding.inflate(layoutInflater, parent, false)
        return MyHolder(binding)
    }

    override fun getItemCount() = data?.size ?: 0

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.onBind(data?.get(position))
        holder.binding.root.setOnClickListener {
            click.clicked(data?.get(position))
        }
        holder.binding.btnHapus.setOnClickListener {
            click.delete(data?.get(position))
        }
    }

    class MyHolder(val binding: ItemDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(dataItem: DataItem?) {
            binding.tvName.text = dataItem?.staffName
            binding.tvPhone.text = dataItem?.staffHp
            binding.tvAddress.text = dataItem?.staffAlamat
        }
    }

    interface onClickItem {
        fun clicked(item: DataItem?)
        fun delete(item: DataItem?)
    }
}
