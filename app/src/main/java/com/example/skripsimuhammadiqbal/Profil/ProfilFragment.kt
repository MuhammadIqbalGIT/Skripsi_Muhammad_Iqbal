package com.example.skripsimuhammadiqbal.Profil

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.skripsimuhammadiqbal.Crud.CrudActivity
import com.example.skripsimuhammadiqbal.Crud.CrudCustomer.CrudCustomerActivity
import com.example.skripsimuhammadiqbal.R
import com.example.skripsimuhammadiqbal.databinding.FragmentProfilBinding
import com.example.skripsimuhammadiqbal.databinding.FragmentTambahProdukBinding

class ProfilFragment : Fragment() {
    private var _binding: FragmentProfilBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentProfilBinding.inflate(inflater, container, false)
        return binding.root



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnTambahCustomer.setOnClickListener {
            val intent = Intent(requireActivity(), CrudCustomerActivity::class.java)
            startActivity(intent)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
