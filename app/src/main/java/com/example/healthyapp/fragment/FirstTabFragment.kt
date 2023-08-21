package com.example.healthyapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.healthyapp.R
import com.example.healthyapp.databinding.FragmentFirstTabBinding

class FirstTabFragment : Fragment(R.layout.fragment_first_tab) {
    private var _binding: FragmentFirstTabBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFirstTabBinding.bind(view)

        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_firstTabFragment_to_secondTabFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}