package com.indrajeet.chauhan.dittormapp.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.indrajeet.chauhan.dittormapp.databinding.FragmentFavoritesCategoryBinding
import com.indrajeet.chauhan.dittormapp.view.adapter.FavoritesCategoryAdapter

class FavoritesCategoryFragment : Fragment() {
    private var _binding: FragmentFavoritesCategoryBinding? = null
    private val binding get() = _binding!!

    private lateinit var category: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            category = it.getString(ARG_CATEGORY) ?: ""
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoritesCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = GridLayoutManager(context, 3)
        recyclerView.adapter = FavoritesCategoryAdapter()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        private const val ARG_CATEGORY = "category"

        fun newInstance(category: String) = FavoritesCategoryFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_CATEGORY, category)
            }
        }
    }
}
