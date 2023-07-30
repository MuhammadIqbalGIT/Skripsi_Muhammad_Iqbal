package com.example.skripsimuhammadiqbal.Crud.CrudCustomer

import android.util.Log
import com.example.skripsimuhammadiqbal.Crud.NetworkConfig
import retrofit2.Call
import retrofit2.Response

class PresenterCustomerOne(val crudView: CrudCustomerActivity) {
    //fungsi get data
    fun getData() {
        NetworkConfig.getService().getDataCustomer()
            .enqueue(object : retrofit2.Callback<ResultCustomer> {
                override fun onFailure(call: Call<ResultCustomer>, t: Throwable) {
                    crudView.onFailedGet(t.localizedMessage)
                    Log.d("Error", "Error Data")
                }

                override fun onResponse(
                    call: Call<ResultCustomer>,
                    response: Response<ResultCustomer>
                ) {
                    if (response.isSuccessful) {
                        val status = response.body()?.status
                        if (status == 200) {
                            val data = response.body()?.pelanggan
                            crudView.onSuccessGet(data)
                        } else {
                            crudView.onFailedGet("Error $status")
                        }
                    }
                }
            })
    }

    //hapus data
    fun hapusData(id: String?) {
        NetworkConfig.getService()
            .deleteCustomer(id)
            .enqueue(object : retrofit2.Callback<ResultStatusCustomer> {
                override fun onFailure(call: Call<ResultStatusCustomer>, t: Throwable) {
                    crudView.onErrorDelete(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<ResultStatusCustomer>, response: Response<ResultStatusCustomer>
                ) {
                    if (response.isSuccessful && response.body()?.status == 200) {
                        crudView.onSuccessDelete(response.body()?.pesan ?: "")
                    } else {
                        crudView.onErrorDelete(response.body()?.pesan ?: "")
                    }
                }
            })
    }
}