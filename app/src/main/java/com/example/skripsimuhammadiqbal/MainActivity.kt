package com.example.skripsimuhammadiqbal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.skripsimuhammadiqbal.Beranda.BerandaFragment
import com.example.skripsimuhammadiqbal.Penjualan.PenjualanFragment
import com.example.skripsimuhammadiqbal.Profil.ProfilFragment
import com.example.skripsimuhammadiqbal.Riwayat.RiwayatFragment
import com.example.skripsimuhammadiqbal.TambahProduk.TambahProdukFragment
import com.example.skripsimuhammadiqbal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(BerandaFragment())

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.beranda -> replaceFragment(BerandaFragment())
                R.id.penjualan -> replaceFragment(PenjualanFragment())
                R.id.tambah -> replaceFragment(TambahProdukFragment())
                R.id.profile -> replaceFragment(ProfilFragment())
                R.id.riwayat -> replaceFragment(RiwayatFragment())
                else -> {

                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }
}