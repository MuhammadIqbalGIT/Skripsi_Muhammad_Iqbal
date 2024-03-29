package com.example.skripsimuhammadiqbal.Crud

interface CrudView {
    //get data
    fun onSuccessGet(data: List<DataItem>?)
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