package com.example.skripsimuhammadiqbal.OnBoarding

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.skripsimuhammadiqbal.Dataclass.Boarding
import com.example.skripsimuhammadiqbal.MainActivity
import com.example.skripsimuhammadiqbal.R
import com.example.skripsimuhammadiqbal.databinding.ActivityWalkThroughBinding
import com.google.android.material.tabs.TabLayoutMediator


const val PARAM_BOARDING = "PARAM_BOARDING"
const val PREF_NAME = "MyAppPreferences"
const val KEY_ONBOARDING_COMPLETED = "onboarding_completed"

class WalkThroughActivity : FragmentActivity() {

    private val TAG = "OnBoardingActivity"


    private val boardingList: List<Boarding> = mutableListOf(
        Boarding(
            R.drawable.ic_cancel_pick_up,
            R.drawable.ic_cancel_pick_up,
            "1",
            "2"
        ),
        Boarding(
            R.drawable.ic_cancel_pick_up,
            0,
            "1",
            "2"
        ),
        Boarding(
            R.drawable.ic_cancel_pick_up,
            0,
            "1",
            ""
        ),
        Boarding(
            R.drawable.ic_cancel_pick_up,
            0,
            "",
            "",
            true
        ),
    )

    private lateinit var binding: ActivityWalkThroughBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWalkThroughBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val pagerAdapter = ScreenSlidePagerAdapter(this)


        with(binding) {
            pager.adapter = pagerAdapter
            pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)

                    val item = boardingList[position]

                    with(binding) {
                        btnStart.isVisible = item.isLast
                        layoutButton.isVisible = !item.isLast

                    }
                }
            })
            pager.apply {
                (getChildAt(0) as RecyclerView).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
            }
            TabLayoutMediator(tabIndicator, pager) { _, _ ->

            }.attach()

            btnSkip.setOnClickListener {
                finishBoard()
                startMainActivity()
            }

            btnNext.setOnClickListener {
                val item = boardingList[pager.currentItem]
                if (!item.isLast)
                    pager.currentItem = pager.currentItem + 1
            }

            btnStart.setOnClickListener {
                finishBoard()
                startMainActivity()
            }
        }
        if (isOnboardingCompleted()) {
            startMainActivity()
        }
    }

    private fun finishBoard() {
        val sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putBoolean(KEY_ONBOARDING_COMPLETED, true)
        editor.apply()
    }

    private fun isOnboardingCompleted(): Boolean {
        val sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean(KEY_ONBOARDING_COMPLETED, false)
    }

    private fun startMainActivity() {
      val intent = Intent (this,MainActivity::class.java)
        startActivity(intent)
    }

    override fun onBackPressed() {
        if (binding.pager.currentItem == 0) {
            super.onBackPressed()
        } else {
            binding.pager.currentItem = binding.pager.currentItem - 1
        }
    }

    private inner class ScreenSlidePagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

        override fun getItemCount(): Int = boardingList.size

        override fun createFragment(position: Int): Fragment {

            val fragment = OnBoarding1Fragment()
            fragment.arguments = bundleOf(PARAM_BOARDING to boardingList[position])

            return fragment
        }
    }


}