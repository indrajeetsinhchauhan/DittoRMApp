package com.indrajeet.chauhan.dittormapp.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.indrajeet.chauhan.dittormapp.databinding.FragmentHomeBinding
import com.indrajeet.chauhan.dittormapp.view.adapter.MyAdapter
import com.indrajeet.chauhan.dittormapp.view.adapter.SliderAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.slider.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.slider.adapter = SliderAdapter()

        binding.horizontalRecyclerView1.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.horizontalRecyclerView1.adapter = MyAdapter()

        binding.horizontalRecyclerView2.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.horizontalRecyclerView2.adapter = MyAdapter()

        binding.horizontalRecyclerView3.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.horizontalRecyclerView3.adapter = MyAdapter()

        binding.horizontalRecyclerView4.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.horizontalRecyclerView4.adapter = MyAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}