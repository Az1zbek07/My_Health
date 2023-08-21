package com.example.healthyapp.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.healthyapp.R
import com.example.healthyapp.database.UserDao
import com.example.healthyapp.database.UserDataBase
import com.example.healthyapp.databinding.FragmentRegisterBinding
import com.example.healthyapp.model.User
import java.text.SimpleDateFormat
import java.util.*

class RegisterFragment : Fragment(R.layout.fragment_register) {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentRegisterBinding.bind(view)
        val db = UserDataBase(requireContext())

        binding.btnFinish.setOnClickListener {
            val name = binding.editName.text.toString().trim()
            val familyName = binding.editFamilyName.text.toString().trim()
            val fathersName = binding.editFathersName.text.toString().trim()
            val gender = binding.editGender.text.toString().trim()
            val age = binding.editAge.text.toString().trim()
            val sickness = binding.editSickness.text.toString().trim()

            if (
                name.isNotBlank() &&
                familyName.isNotBlank() &&
                fathersName.isNotBlank() &&
                gender.isNotBlank() &&
                age.isNotBlank() &&
                sickness.isNotBlank()
            ){
                controlVisibility(binding.editName, false)
                controlVisibility(binding.editFamilyName, false)
                controlVisibility(binding.editFathersName, false)
                controlVisibility(binding.editGender, false)
                controlVisibility(binding.editAge, false)
                controlVisibility(binding.editSickness, false)
                controlVisibility(binding.btnFinish, false)
                controlVisibility(binding.pr, true)


                val sdf = SimpleDateFormat("dd.MM.yyyy")
                val date = sdf.format(Date())
                val user = User(0, name, familyName, fathersName, gender, age.toInt(), sickness, date)
                db.dao.saveUser(user)

                object : CountDownTimer(1500, 1000){
                    override fun onTick(p0: Long) {   }

                    override fun onFinish() {
                        controlVisibility(binding.editName, true)
                        controlVisibility(binding.editFamilyName, true)
                        controlVisibility(binding.editFathersName, true)
                        controlVisibility(binding.editGender, true)
                        controlVisibility(binding.editAge, true)
                        controlVisibility(binding.editSickness, true)
                        controlVisibility(binding.btnFinish, true)
                        controlVisibility(binding.pr, false)

                        binding.editName.text?.clear()
                        binding.editFamilyName.text?.clear()
                        binding.editFathersName.text?.clear()
                        binding.editAge.text?.clear()
                        binding.editGender.text?.clear()
                        binding.editSickness.text?.clear()

                        val builder = AlertDialog.Builder(requireContext())
                        builder.setTitle("Done")
                            .setMessage("You have registrationed successfully!")
                            .setPositiveButton("OK", null)
                            .show()
                            .create()
                    }
                }.start()

            }else{
                Toast.makeText(requireContext(), "Please enter all data", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun controlVisibility(view: View, isVisible: Boolean) {
        view.isVisible = isVisible
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}