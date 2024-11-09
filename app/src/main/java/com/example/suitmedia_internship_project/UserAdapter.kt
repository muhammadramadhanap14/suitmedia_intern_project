package com.example.suitmedia_internship_project

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.suitmedia_internship_project.databinding.ItemUserBinding

class UserAdapter(private val onClick: (User) -> Unit) : ListAdapter<User, UserAdapter.UserViewHolder>(UserDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = getItem(position)
        holder.bind(user)
    }

    inner class UserViewHolder(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.userName.text = "${user.first_name} ${user.last_name}"
            binding.userEmail.text = user.email // Display email here

            Glide.with(binding.avatar.context)
                .load(user.avatar)
                .into(binding.avatar)

            itemView.setOnClickListener { onClick(user) }
        }
    }

    fun addUsers(users: List<User>) {
        val currentList = currentList.toMutableList()
        currentList.addAll(users)
        submitList(currentList)
    }
}