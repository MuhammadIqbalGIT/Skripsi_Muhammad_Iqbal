package com.example.skripsimuhammadiqbal.Crud.CrudCustomer

import com.example.skripsimuhammadiqbal.Crud.DataItem

interface CrudViewCustomer {
    //get data
    fun onSuccessGet(data: List<DataItemCustomer>?)
    fun onFailedGet(msg : String)

    //untuk add
    fun onSuccessAdd(msg: String)
    fun onErrorAdd(msg : String)

    //untuk update
    fun onSuccessUpdate(msg: String)
    fun onErrorupdate(msg : String)

    //untuk delete
    fun onSuccessDelete(msg: String)
    fun onErrorDelete(msg : String)
}