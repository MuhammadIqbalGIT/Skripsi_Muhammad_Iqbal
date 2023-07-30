package com.example.skripsimuhammadiqbal.Crud

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.skripsimuhammadiqbal.databinding.ActivityCrudBinding

class CrudActivity : AppCompatActivity(), CrudView {
    private lateinit var presenter: Presenter
    private lateinit var binding: ActivityCrudBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCrudBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fullScreen()
        btnAction()
        presenter = Presenter(this)
        presenter.getData()
        binding.appbar.tvScreen.text = "List Produk"

    }

    override fun onSuccessGet(data: List<DataItem>?) {
        binding.rvCategory.layoutManager = LinearLayoutManager(this)
        binding.rvCategory.adapter = DataAdapter(data, object : DataAdapter.onClickItem {
            override fun clicked(item: DataItem?) {
                val bundle = Bundle()
                bundle.putSerializable("dataItem", item)
                val intent = Intent(applicationContext, UpdateAddActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            }

            override fun delete(item: DataItem?) {
                presenter.hapusData(item?.staffId)
                startActivity(Intent(applicationContext, CrudActivity::class.java))
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
        binding.btnTambah.setOnClickListener {
            startActivity(Intent(applicationContext, UpdateAddActivity::class.java))
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
