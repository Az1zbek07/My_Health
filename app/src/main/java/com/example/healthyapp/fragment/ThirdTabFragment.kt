package com.example.healthyapp.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.healthyapp.R
import com.example.healthyapp.SecondActivity
import com.example.healthyapp.databinding.FragmentFirstTabBinding
import com.example.healthyapp.databinding.FragmentThirdTabBinding
import com.example.healthyapp.utils.SharedPrefManager

class ThirdTabFragment : Fragment(R.layout.fragment_third_tab) {
    private var _binding: FragmentThirdTabBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentThirdTabBinding.bind(view)

        binding.btnStart.setOnClickListener {
            val sharedPrefManager = SharedPrefManager(requireContext())
            sharedPrefManager.saveBoolean(true)

            val intent = Intent(requireActivity(), SecondActivity::class.java)
            requireActivity().startActivity(intent)
            requireActivity().finish()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}