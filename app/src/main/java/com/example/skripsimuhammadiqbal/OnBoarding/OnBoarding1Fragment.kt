package com.example.skripsimuhammadiqbal.OnBoarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.skripsimuhammadiqbal.Dataclass.Boarding
import com.example.skripsimuhammadiqbal.R
import com.example.skripsimuhammadiqbal.databinding.FragmentOnBoarding1Binding


class OnBoarding1Fragment : Fragment() {

    private lateinit var binding: FragmentOnBoarding1Binding

    private lateinit var boarding: Boarding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requireArguments().let {
            boarding = it.get(PARAM_BOARDING) as Boarding
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentOnBoarding1Binding.inflate(inflater, container, false)

        with(binding) {
            img1.setImageResource(boarding.banner)
//            if (boarding.iconSrc != 0) {
//                img2.setImageResource(boarding.iconSrc)
//                img2.isVisible = true
//            } else
//                img2.isVisible = false
//            txtTitle.text = boarding.title
            txtDesc.text = boarding.desc
        }

        return binding.root
    }
}