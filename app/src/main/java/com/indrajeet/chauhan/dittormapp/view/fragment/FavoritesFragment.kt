package com.indrajeet.chauhan.dittormapp.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.indrajeet.chauhan.dittormapp.databinding.FragmentFavoritesBinding
import com.indrajeet.chauhan.dittormapp.view.adapter.MyAdapter
import com.indrajeet.chauhan.dittormapp.view.adapter.TabLayoutRecyclerViewAdapter
import com.indrajeet.chauhan.dittormapp.view.layoutmanager.CircularLayoutManager

class FavoritesFragment : Fragment() {

    private var _binding: FragmentFavoritesBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    private val categories = listOf(
        "すべて",
        "女性ファッション",
        "女性ライフスタイル",
        "男性ファッション",
        "男性ライフスタイル",
        "ビューティー",
        "グルメ",
        "旅行",
        "エンタメ",
        "スポーツ",
        "テクノロジー",
        "ビジネス"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tabLayout = binding.fragmentFavoritesTabLayout
//        val tabRecyclerView = binding.fragmentFavoritesTabLayout
        val viewPager = binding.fragmentFavoritesViewpager

        val adapter = ViewPagerAdapter(this, categories)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = categories[position % categories.size]
        }.attach()

//         Start in the middle for infinite effect
        viewPager.setCurrentItem(categories.size/2, true)

//         This part is not needed. Also, the performance of the app is better without this code
//        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
//            override fun onTabSelected(tab: TabLayout.Tab?) {
//                viewPager.setCurrentItem(tab!!.position, true)
//            }
//
//            override fun onTabUnselected(tab: TabLayout.Tab?) {}
//
//            override fun onTabReselected(tab: TabLayout.Tab?) {}
//        })

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                val tabCount = adapter.itemCount
                if (position == 0) {
                    viewPager.setCurrentItem(tabCount - 1, false)
                } else if (position == tabCount - 1) {
                    viewPager.setCurrentItem(0, false)
                }
//                tabLayout.setScrollPosition(position % categories.size, 0f, true)
            }
        })

//        val tabAdapter = TabLayoutRecyclerViewAdapter(categories) {position ->
//            viewPager.setCurrentItem(position, true)
//        }
//
//        tabRecyclerView.apply {
////            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
//            layoutManager = CircularLayoutManager(context)
//            adapter = tabAdapter
//            scrollToPosition((categories.size/2))
//        }
//
//        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
//            override fun onPageSelected(position: Int) {
//                val centerPosition = position % categories.size
//                tabRecyclerView.smoothScrollToPosition(centerPosition)
//            }
//        })
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

class ViewPagerAdapter(fragment: Fragment, private val categories: List<String>) :
    FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return categories.size
    }

    override fun createFragment(position: Int): Fragment {
        val category = categories[position % categories.size]
        return FavoritesCategoryFragment.newInstance(category)
    }

}