package com.example.skripsimuhammadiqbal.Crud

import com.example.skripsimuhammadiqbal.Crud.CrudCustomer.ResultCustomer
import com.example.skripsimuhammadiqbal.Crud.CrudCustomer.ResultStatusCustomer
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

object NetworkConfig {
    fun getInterceptor(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        return okHttpClient
    }

    //Retrofit
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            //TODO : UNTUK NEMBAK KE EMULATOR (PAKAI YANG PORT SAJA SOALNYA AKSES MYSQL HARUS MENGGUNAKAN PORT)
            //TODO : INI MENGGUNAKAN IP EMULATOR (IP DEFAULT EMULATOR)
            //.baseUrl("http://10.0.2.2/server_api/index.php/ServerApi/")
            .baseUrl("http://10.0.2.2:8080/server_api/index.php/ServerApi/")


            //TODO : UNTUK NEMBAK KE DEVICE (PAKAI YANG PORT SAJA SOALNYA AKSES MYSQL HARUS MENGGUNAKAN PORT)
            //TODO : INI MENGGUNAKAN IP LAPTOP
            //.baseUrl("http://192.168.127.197:8080/server_api/index.php/ServerApi/")
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getService() = getRetrofit().create(StaffService::class.java)
}

interface StaffService {
    //fungsi create data
    @FormUrlEncoded
    @POST("addStaff")
    fun addStaff(
        @Field("name") name: String,
        @Field("hp") hp: String,
        @Field("alamat") alamat: String
    ): Call<ResultStatus>

    //fungsi get data
    @GET("getDataStaff")
    fun getData(): Call<ResultStaff>

    //fungsi update data
    @FormUrlEncoded
    @POST("updateStaff")
    fun updateStaff(
        @Field("id") id: String,
        @Field("name") name: String,
        @Field("hp") hp: String,
        @Field("alamat") alamat: String
    ): Call<ResultStatus>

    //fungsi delete
    @FormUrlEncoded
    @POST("deleteStaff")
    fun deleteStaff(@Field("id") id: String?): Call<ResultStatus>





    //TODO : CRUD CUSTOMER


    //fungsi create data
    @FormUrlEncoded
    @POST("addCustomer")
    fun addCustomer(
        @Field("name") name: String,
        @Field("hp") hp: String,
        @Field("alamat") alamat: String,
        @Field("email") email: String
    ): Call<ResultStatusCustomer>

    //fungsi get data
    @GET("getDataCustomer")
    fun getDataCustomer(): Call<ResultCustomer>

    //fungsi update data
    @FormUrlEncoded
    @POST("updateCustomer")
    fun updateCustomer(
        @Field("id") id: String,
        @Field("name") name: String,
        @Field("hp") hp: String,
        @Field("alamat") alamat: String,
        @Field("email") email: String
    ): Call<ResultStatusCustomer>

    //fungsi delete
    @FormUrlEncoded
    @POST("deleteCustomer")
    fun deleteCustomer(@Field("id") id: String?): Call<ResultStatusCustomer>




}