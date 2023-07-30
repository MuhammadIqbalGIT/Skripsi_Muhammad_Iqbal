package com.example.skripsimuhammadiqbal.Crud.CrudCustomer

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.skripsimuhammadiqbal.databinding.ActivityCrudCustomerBinding

class CrudCustomerActivity : AppCompatActivity(), CrudViewCustomer {
    private lateinit var presenter: PresenterCustomerOne
    private lateinit var binding: ActivityCrudCustomerBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCrudCustomerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fullScreen()
        btnAction()
        presenter = PresenterCustomerOne(this)
        presenter.getData()
        binding.appbar.tvScreen.text = "List Pelanggan"

    }

    override fun onSuccessGet(data: List<DataItemCustomer>?) {
        binding.rvCustomer.layoutManager = LinearLayoutManager(this)
        binding.rvCustomer.adapter = DataCustomerAdapter(data, object : DataCustomerAdapter.onClickItem {
            override fun clicked(item: DataItemCustomer?) {
                val bundle = Bundle()
                bundle.putSerializable("dataItemCustomer", item)
                val intent = Intent(applicationContext, UpdateAddCustomerActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            }

            override fun delete(item: DataItemCustomer?) {
                presenter.hapusData(item?.idPelanggan)
                startActivity(Intent(applicationContext, CrudCustomerActivity::class.java))
                finish()
            }
        })
    }

    private fun fullScreen () {
        //HIDE ACTION BAR SAMA NAMBAHIN FULLSCREEN
        supportActionBar?.hide()
//        setFullScreen(window)
//        lightStatusBar(window)
    }

    private fun btnAction () {
        binding.btnTambahCustomer.setOnClickListener {
            startActivity(Intent(applicationContext, UpdateAddCustomerActivity::class.java))
            finish()
        }
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

    override fun onFailedGet(msg: String) {
        // Implementasi fungsi onFailedGet
        // ...
    }

    override fun onSuccessDelete(msg: String) {
        presenter.getData()
    }

    override fun onErrorDelete(msg: String) {
        Toast.makeText(this, "Delete tidak berhasil", Toast.LENGTH_SHORT).show()
    }

    override fun onSuccessAdd(msg: String) {
        // Implementasi fungsi onSuccessAdd
        // ...
    }

    override fun onErrorAdd(msg: String) {
        // Implementasi fungsi onErrorAdd
        // ...
    }

    override fun onSuccessUpdate(msg: String) {
        // Implementasi fungsi onSuccessUpdate
        // ...
    }

    override fun onErrorupdate(msg: String) {
        // Implementasi fungsi onErrorupdate
        // ...
    }
}
