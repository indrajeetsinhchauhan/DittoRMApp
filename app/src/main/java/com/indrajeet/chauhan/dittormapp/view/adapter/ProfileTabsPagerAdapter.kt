package com.indrajeet.chauhan.dittormapp.view.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.indrajeet.chauhan.dittormapp.view.fragment.ProfileBookmarksFragment
import com.indrajeet.chauhan.dittormapp.view.fragment.ProfileDownloadsFragment
import com.indrajeet.chauhan.dittormapp.view.fragment.ProfileHistoryFragment

class ProfileTabsPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ProfileBookmarksFragment.newInstance()
            1 -> ProfileDownloadsFragment.newInstance()
            else -> ProfileHistoryFragment.newInstance()
        }
    }

    override fun getItemCount(): Int {
        return NUM_TABS // Specify the number of tabs
    }


    companion object {
        private const val NUM_TABS = 3 // Example: Adjust the number of tabs as needed
    }
}