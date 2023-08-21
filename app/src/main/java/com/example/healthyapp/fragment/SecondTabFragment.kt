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
import com.example.healthyapp.databinding.FragmentSecondTabBinding

class SecondTabFragment : Fragment(R.layout.fragment_second_tab) {
    private var _binding: FragmentSecondTabBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSecondTabBinding.bind(view)
        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_secondTabFragment_to_thirdTabFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}