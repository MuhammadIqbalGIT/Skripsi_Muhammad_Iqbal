package com.example.skripsimuhammadiqbal.Crud.CrudCustomer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.skripsimuhammadiqbal.Crud.DataItem
import com.example.skripsimuhammadiqbal.databinding.ItemDataBinding
import com.example.skripsimuhammadiqbal.databinding.ItemDataCustomerBinding

class DataCustomerAdapter(
    private val data: List<DataItemCustomer>?,
    private val click: onClickItem
) : RecyclerView.Adapter<DataCustomerAdapter.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemDataCustomerBinding.inflate(layoutInflater, parent, false)
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

    class MyHolder(val binding: ItemDataCustomerBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(dataItem: DataItemCustomer?) {
            binding.tvNameCustomer.text = dataItem?.namaPelanggan
            binding.tvPhoneCustomer.text = dataItem?.handphone
            binding.tvAddressCustomer.text = dataItem?.alamatPelanggan
            binding.tvEmailCustomer.text = dataItem?.email
        }
    }

    interface onClickItem {
        fun clicked(item: DataItemCustomer?)
        fun delete(item: DataItemCustomer?)
    }
}
