package com.example.suitmedia_internship_project

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class FirstScreenActivity : AppCompatActivity() {

    private lateinit var nameInput: EditText
    private lateinit var palindromeInput: EditText
    private lateinit var checkButton: Button
    private lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_screen)

        nameInput = findViewById(R.id.name_input)
        palindromeInput = findViewById(R.id.palindrome_input)
        checkButton = findViewById(R.id.check_button)
        nextButton = findViewById(R.id.next_button)

        checkButton.setOnClickListener {
            val sentence = palindromeInput.text.toString()

            // Validasi jika input kosong
            if (sentence.isBlank()) {
                showDialog("No Text Inputted")
            } else {
                // Cek apakah teks adalah palindrome
                if (isPalindrome(sentence)) {
                    showDialog("isPalindrome")
                } else {
                    showDialog("not palindrome")
                }
            }
        }

        nextButton.setOnClickListener {
            val userName = nameInput.text.toString()

            // Validasi: Pastikan nama tidak kosong
            if (userName.isBlank()) {
                // Tampilkan pesan kesalahan jika nama kosong
                showDialog("Please enter your name before proceeding.")
            } else {
                // Jika nama valid, lanjutkan ke SecondScreenActivity
                val intent = Intent(this, SecondScreenActivity::class.java)
                intent.putExtra("userName", userName)
                startActivity(intent)
            }
        }
    }

    private fun isPalindrome(sentence: String): Boolean {
        val cleanSentence = sentence.replace(Regex("[^A-Za-z0-9]"), "").lowercase()
        return cleanSentence == cleanSentence.reversed()
    }

    private fun showDialog(message: String) {
        AlertDialog.Builder(this)
            .setMessage(message)
            .setPositiveButton("OK", null)
            .show()
    }
}