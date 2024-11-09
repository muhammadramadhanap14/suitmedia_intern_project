package com.example.suitmedia_internship_project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.app.AppCompatActivity
import com.example.suitmedia_internship_project.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

//    private lateinit var binding: ActivityMainBinding
//    private lateinit var userAdapter: UserAdapter
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        userAdapter = UserAdapter { user ->
//            // Handle item click here
//        }
//
//        binding.recyclerView.apply {
//            layoutManager = LinearLayoutManager(this@MainActivity)
//            adapter = userAdapter
//        }
//
//        fetchUsers(1)
//    }
//
//    private fun fetchUsers(page: Int) {
//        RetrofitInstance.apiService.getUsers(page, 10).enqueue(object : Callback<UserResponse> {
//            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
//                if (response.isSuccessful) {
//                    val users = response.body()?.data
//                    userAdapter.submitList(users)
//                }
//            }
//
//            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
//                // Handle failure
//            }
//        })
//    }
}