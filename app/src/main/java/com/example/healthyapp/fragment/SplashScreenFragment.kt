package com.example.healthyapp.fragment

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.healthyapp.R
import com.example.healthyapp.SecondActivity
import com.example.healthyapp.utils.SharedPrefManager
import kotlinx.coroutines.currentCoroutineContext

class SplashScreenFragment : Fragment(R.layout.fragment_splash_screen) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        object : CountDownTimer(3000, 1000){
            override fun onTick(p0: Long) { }

            override fun onFinish() {
                val sharedPrefManager = SharedPrefManager(requireContext())
                if (sharedPrefManager.getBoolean()){
                    requireActivity().startActivity(Intent(requireContext(), SecondActivity::class.java))
                    requireActivity().finish()
                }else{
                    val navOptions = NavOptions.Builder().setPopUpTo(R.id.splashScreenFragment, true).build()
                    findNavController().navigate(R.id.action_splashScreenFragment_to_firstTabFragment, null, navOptions)
                }
            }
        }.start()
    }

}