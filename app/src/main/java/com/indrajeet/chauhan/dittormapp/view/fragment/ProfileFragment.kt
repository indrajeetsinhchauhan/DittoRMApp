package com.indrajeet.chauhan.dittormapp.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.indrajeet.chauhan.dittormapp.R
import com.indrajeet.chauhan.dittormapp.databinding.FragmentProfileBinding
import com.indrajeet.chauhan.dittormapp.view.adapter.ProfileTabsPagerAdapter

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    companion object {
        fun newInstance(): ProfileFragment {
            return ProfileFragment()
            // If you need to pass arguments to the fragment, use a Bundle here
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.profileViewPager.adapter = ProfileTabsPagerAdapter(this)

        TabLayoutMediator(binding.profileTabLayout, binding.profileViewPager) { tab, position ->
            tab.text = when (position) {
                0 -> resources.getText(R.string.title_bookmarks)
                1 -> resources.getText(R.string.title_download)
                else -> resources.getText(R.string.title_history)
            }
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}