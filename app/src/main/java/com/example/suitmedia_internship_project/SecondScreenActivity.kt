package com.example.suitmedia_internship_project

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondScreenActivity : AppCompatActivity() {

    private lateinit var welcomeText: TextView
    private lateinit var userNameText: TextView
    private lateinit var selectedUserLabel: TextView
    private lateinit var chooseUserButton: Button
    private lateinit var backButton: ImageButton
    private var userName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen)

        welcomeText = findViewById(R.id.welcome_text)
        userNameText = findViewById(R.id.user_name_text)
        selectedUserLabel = findViewById(R.id.selected_user_label)
        chooseUserButton = findViewById(R.id.choose_user_button)
        backButton = findViewById(R.id.back_button)

        // Ambil nama dari intent dan tampilkan pada userNameText
        userName = intent.getStringExtra("userName")
        userNameText.text = userName ?: "User"

        // Tambahkan aksi ketika tombol "Choose a User" ditekan
        chooseUserButton.setOnClickListener {
            val intent = Intent(this, ThirdScreenActivity::class.java)
            intent.putExtra("userName", userName) // Pass the userName to the next activity
            startActivityForResult(intent, 100)
        }

        // Set click listener for back button to go to FirstScreenActivity
        backButton.setOnClickListener {
            val intent = Intent(this, FirstScreenActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100 && resultCode == Activity.RESULT_OK) {
            val selectedUserName = data?.getStringExtra("selectedUserName")
            selectedUserLabel.text = "Selected User Name:\n$selectedUserName"
        }
    }
}