package com.example.skripsimuhammadiqbal.Crud.CrudCustomer

import com.example.skripsimuhammadiqbal.Crud.DataItem
import com.google.gson.annotations.SerializedName

class ResultCustomer{
    @field:SerializedName("pesan")
    val pesan: String? = null

    @field:SerializedName("pelanggan")
    val pelanggan: List<DataItemCustomer>? = null

    @field:SerializedName("status")
    val status: Int? = null
}