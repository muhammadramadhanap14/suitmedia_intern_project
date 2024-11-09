package com.example.suitmedia_internship_project

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ThirdScreenActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var userAdapter: UserAdapter
    private var currentPage = 1
    private var isLoading = false // Menambahkan flag loading untuk mencegah permintaan duplikat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_screen)

        recyclerView = findViewById(R.id.user_recycler_view)
        swipeRefreshLayout = findViewById(R.id.swipe_refresh_layout)

        // Inisialisasi adapter dan menambahkan listener untuk item klik
        userAdapter = UserAdapter { user ->
            val intent = Intent().apply {
                putExtra("selectedUserName", "${user.first_name} ${user.last_name}")
                putExtra("selectedUserEmail", user.email) // Add the email to the result
            }
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = userAdapter

        // Listener untuk SwipeRefreshLayout
        swipeRefreshLayout.setOnRefreshListener {
            currentPage = 1
            fetchUsers(reset = true) // Muat ulang data pengguna dengan reset
        }

        // Listener untuk mendeteksi scroll ke bawah untuk pagination
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                if (!isLoading && layoutManager.findLastCompletelyVisibleItemPosition() == userAdapter.itemCount - 1) {
                    currentPage++
                    fetchUsers()
                }
            }
        })

        // Menambahkan listener untuk back button
        val backButton = findViewById<ImageButton>(R.id.back_button)
        backButton.setOnClickListener {
            // Pindah ke SecondScreenActivity
            val intent = Intent(this, SecondScreenActivity::class.java)
            startActivity(intent)
            finish()  // Menutup ThirdScreenActivity setelah berpindah
        }

        fetchUsers() // Memuat data pengguna awal
    }

    private fun fetchUsers(reset: Boolean = false) {
        isLoading = true // Set flag isLoading menjadi true saat mulai memuat data
        val apiService = RetrofitInstance.apiService
        apiService.getUsers(currentPage, 10).enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if (response.isSuccessful) {
                    val users = response.body()?.data ?: emptyList()

                    if (reset) {
                        userAdapter.submitList(users) // Reset list jika halaman pertama
                    } else {
                        userAdapter.addUsers(users) // Tambahkan data baru jika bukan halaman pertama
                    }

                    // Cek jika data yang diterima kosong, kurangi currentPage
                    if (users.isEmpty()) {
                        currentPage--
                    }

                    swipeRefreshLayout.isRefreshing = false
                } else {
                    Toast.makeText(this@ThirdScreenActivity, "Gagal memuat data", Toast.LENGTH_SHORT).show()
                }
                isLoading = false // Set flag isLoading menjadi false setelah selesai memuat
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                swipeRefreshLayout.isRefreshing = false
                isLoading = false // Set flag isLoading menjadi false jika ada kegagalan
                Toast.makeText(this@ThirdScreenActivity, "Terjadi kesalahan: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}