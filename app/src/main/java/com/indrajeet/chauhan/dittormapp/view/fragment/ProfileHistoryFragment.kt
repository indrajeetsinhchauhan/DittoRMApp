package com.indrajeet.chauhan.dittormapp.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.indrajeet.chauhan.dittormapp.databinding.FragmentProfileHistoryBinding

class ProfileHistoryFragment : Fragment() {

    private var _binding: FragmentProfileHistoryBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance(): ProfileHistoryFragment {
            return ProfileHistoryFragment()
            // If you need to pass arguments to the fragment, use a Bundle here
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentProfileHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
//        recyclerView.layoutManager = LinearLayoutManager(context)
//        recyclerView.adapter = YourAdapter() // Replace YourAdapter with your actual adapter class
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Avoid memory leaks
    }
}