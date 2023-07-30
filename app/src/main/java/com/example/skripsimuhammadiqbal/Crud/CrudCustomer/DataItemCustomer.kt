package com.example.skripsimuhammadiqbal.Crud.CrudCustomer

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class DataItemCustomer : Serializable {

    @field:SerializedName("id_pelanggan")
    val idPelanggan: String? = null


    @field:SerializedName("nama_pelanggan")
    val namaPelanggan: String? = null


    @field:SerializedName("alamat_pelanggan")
    val alamatPelanggan: String? = null


    @field:SerializedName("handphone")
    val handphone: String? = null


    @field:SerializedName("email")
    val email: String? = null

}