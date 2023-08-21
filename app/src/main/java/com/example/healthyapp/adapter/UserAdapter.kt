package com.example.healthyapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.healthyapp.databinding.ItemLayoutBinding
import com.example.healthyapp.model.User

class UserAdapter: ListAdapter<User, UserAdapter.VHolder>(DiffCallBack()) {
    private class DiffCallBack: DiffUtil.ItemCallback<User>(){
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHolder {
        return VHolder(ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class VHolder(private val binding: ItemLayoutBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(user: User){
            binding.textName.text = user.name
            binding.textFamilyName.text = user.familyName
            binding.textFathersName.text = user.fathersName
            binding.textGender.text = user.gender
            binding.textAge.text = user.age.toString()
            binding.textSickness.text = user.sickness
            binding.textDate.text = user.date
        }
    }
}