package com.example.uiinxml.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uiinxml.databinding.ActivityDemoRecyclerviewBinding
import java.util.UUID

class DemoRecyclerViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDemoRecyclerviewBinding
    private val userAdapter = UserAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDemoRecyclerviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        val users = List(100){ index ->
            User(
                id = UUID.randomUUID().toString(),
                name = "#$index name",
                email = "vohuy19120_$index@gmail.com"
            )
        }
        userAdapter.setUsers(users)
    }

    private fun setupRecyclerView() {
        binding.rcvUser.run{
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = userAdapter
        }
    }
}