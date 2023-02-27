package com.example.quizapp.activites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.quizapp.R
import com.google.firebase.auth.FirebaseAuth


class LoginActivity : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)
        firebaseAuth = FirebaseAuth.getInstance()

        val loginClicked = findViewById<Button>(R.id.btn_Login)
        loginClicked.setOnClickListener{
            login()
        }

        val plsSignupClicked = findViewById<TextView>(R.id.textSignup)
        plsSignupClicked.setOnClickListener{
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    private fun login() {

        val email = findViewById<EditText>(R.id.textEmailAddress).text.toString()
        val password = findViewById<EditText>(R.id.textPassword).text.toString()

        if (email.isBlank() || password.isBlank()) {
            Toast.makeText(this, "Email and password cannot be empty", Toast.LENGTH_SHORT).show()
            return
        }

        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this){

            if (it.isSuccessful) {
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }else {
                Toast.makeText(this, "Authentication failed", Toast.LENGTH_SHORT).show()
            }
        }


    }
}