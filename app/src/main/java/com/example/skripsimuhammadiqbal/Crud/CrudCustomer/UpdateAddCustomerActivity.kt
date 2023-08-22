package com.example.skripsimuhammadiqbal.Crud.CrudCustomer

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.skripsimuhammadiqbal.Crud.CrudActivity
import com.example.skripsimuhammadiqbal.Crud.DataItem
import com.example.skripsimuhammadiqbal.databinding.ActivityUpdateAddCustomerBinding

class UpdateAddCustomerActivity : AppCompatActivity(), CrudViewCustomer {
    private lateinit var presenter: PresenterCustomerTwo
    private lateinit var binding: ActivityUpdateAddCustomerBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateAddCustomerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fullScreen()
        initBack()

        presenter = PresenterCustomerTwo(this)
        val itemDataItem = intent.getSerializableExtra("dataItemCustomer")

        if (itemDataItem == null) {
            binding.appbar.tvScreen.text = "Tambah Pelanggan"
            binding.btnAction.text = "Tambah"
            binding.btnAction.setOnClickListener() {
                presenter.addData(
                    binding.etNameCustomer.text.toString(),
                    binding.etPhoneCustomer.text.toString(),
                    binding.etEmailCustomer.text.toString(),
                    binding.etAddressCustomer.text.toString()
                )
            }
        } else if (itemDataItem != null) {
            binding.btnAction.text = "Update"
            binding.appbar.tvScreen.text = "Update Pelanggan"
            val item = itemDataItem as DataItemCustomer?
            binding.etNameCustomer.setText(item?.namaPelanggan.toString())
            binding.etPhoneCustomer.setText(item?.handphone.toString())
            binding.etAddressCustomer.setText(item?.alamatPelanggan)
            binding.etEmailCustomer.setText(item?.email)
            binding.btnAction.setOnClickListener() {
                presenter.updateData(
                    item?.idPelanggan ?: "",
                    binding.etNameCustomer.text.toString(),
                    binding.etPhoneCustomer.text.toString(),
                    binding.etAddressCustomer.text.toString(),
                    binding.etEmailCustomer.text.toString()
                )
                finish()
            }
        }
    }


    private fun initBack () {
        binding.appbar.ivBack.setOnClickListener {
            onBackPressed()
        }
    }
    override fun onBackPressed() {
        val fragmentBackStackEntryCount = supportFragmentManager.backStackEntryCount
        if (fragmentBackStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }


    private fun fullScreen() {
        //HIDE ACTION BAR SAMA NAMBAHIN FULLSCREEN
        supportActionBar?.hide()
        // setFullScreen(window)
        //  lightStatusBar(window)
    }

    override fun onSuccessAdd(msg: String) {
        startActivity(Intent(this, CrudCustomerActivity::class.java))
        finish()
        Toast.makeText(this, "Berhasil Menambahkan data pelanggan", Toast.LENGTH_SHORT).show()
    }

    override fun onErrorAdd(msg: String) {}

    override fun onSuccessUpdate(msg: String) {
        startActivity(Intent(this, CrudCustomerActivity::class.java))
        finish()
        Toast.makeText(this, "Berhasil Mengupdate data pelanggan", Toast.LENGTH_SHORT).show()
    }

    override fun onErrorupdate(msg: String) {

    }

    override fun onSuccessGet(data: List<DataItemCustomer>?) {}

    override fun onFailedGet(msg: String) {}

    override fun onSuccessDelete(msg: String) {}

    override fun onErrorDelete(msg: String) {}
}