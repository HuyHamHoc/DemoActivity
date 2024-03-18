package com.example.uiinxml.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uiinxml.databinding.UserItemLayoutBinding

class UserAdapter : RecyclerView.Adapter<UserAdapter.VH>() {
    private var users : List<User> = emptyList()

    fun setUsers(users: List<User>) {
        this.users = users
        notifyDataSetChanged()
    }

    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding = UserItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
            )
        return VH(binding)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(users[position])
    }

    class VH(private val binding: UserItemLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(user: User) {
            binding.run {
                textView3.text = user.name
                textView4.text = user.email
            }
        }

    }
}