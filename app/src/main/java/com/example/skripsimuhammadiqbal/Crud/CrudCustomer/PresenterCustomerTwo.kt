package com.example.skripsimuhammadiqbal.Crud.CrudCustomer

import com.example.skripsimuhammadiqbal.Crud.NetworkConfig
import retrofit2.Call
import retrofit2.Response

class PresenterCustomerTwo (val crudView: UpdateAddCustomerActivity) {
    //Add data
    fun addData(name: String, hp: String, alamat: String, email :String) {
        NetworkConfig.getService()
            .addCustomer(name, hp, alamat,email)
            .enqueue(object : retrofit2.Callback<ResultStatusCustomer> {
                override fun onFailure(call: Call<ResultStatusCustomer>, t: Throwable) {
                    crudView.onErrorAdd(t.localizedMessage)
                }

                override fun onResponse(call: Call<ResultStatusCustomer>, response: Response<ResultStatusCustomer>
                ) {
                    if (response.isSuccessful && response.body()?.status == 200) {
                        crudView.onSuccessAdd(response.body()?.pesan ?: "")
                    } else {
                        crudView.onErrorAdd(response.body()?.pesan ?: "")
                    }
                }
            })
    }

    //update data
    fun updateData(id: String, name: String, hp: String, alamat: String, email: String) {
        NetworkConfig.getService()
            .updateCustomer(id, name, hp, alamat,email)
            .enqueue(object : retrofit2.Callback<ResultStatusCustomer> {
                override fun onFailure(call: Call<ResultStatusCustomer>, t: Throwable) {
                    t.localizedMessage?.let { crudView.onErrorupdate(it) }
                }

                override fun onResponse(call: Call<ResultStatusCustomer>, response: Response<ResultStatusCustomer>
                ) {
                    if (response.isSuccessful && response.body()?.status == 200) {
                        crudView.onSuccessUpdate(response.body()?.pesan ?: "")
                    } else {
                        crudView.onErrorupdate(response.body()?.pesan ?: "")
                    }
                }
            })
    }
}