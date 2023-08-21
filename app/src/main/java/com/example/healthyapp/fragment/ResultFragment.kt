package com.example.healthyapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.healthyapp.R
import com.example.healthyapp.adapter.UserAdapter
import com.example.healthyapp.database.UserDataBase
import com.example.healthyapp.databinding.FragmentRegisterBinding
import com.example.healthyapp.databinding.FragmentResultBinding

class ResultFragment : Fragment(R.layout.fragment_result) {
    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentResultBinding.bind(view)
        val userAdapter = UserAdapter()
        binding.rv.apply {
            adapter = userAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        val db = UserDataBase(requireContext())
        userAdapter.submitList(db.dao.getAllUsers())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}