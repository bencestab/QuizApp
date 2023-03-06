package com.example.quizapp.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.R
import com.example.quizapp.adapters.OptionAdapter
import com.example.quizapp.models.Question
import com.example.quizapp.models.Quiz
import com.google.firebase.firestore.FirebaseFirestore

class QuestionActivity : AppCompatActivity() {

    var quizzes : MutableList<Quiz>? = null
    var questions : MutableMap<String, Question>? = null
    var index = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        setUpFirestore()
    }

    private fun setUpFirestore() {
        val firestore = FirebaseFirestore.getInstance()
        val date = intent.getStringExtra("DATE")
        if (date != null) {
            firestore.collection("quizzes").whereEqualTo("title", date)
                .get()
                .addOnSuccessListener {
                    if(it != null && !it.isEmpty) {
                        quizzes = it.toObjects(Quiz::class.java)
                        questions = quizzes!![0].questions
                        bindViews()
                 }
                }
        }
    }

    private fun bindViews() {

        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val btnNext = findViewById<Button>(R.id.btnNext)
        val btnPrevious = findViewById<Button>(R.id.btnPrevious)

        btnPrevious.visibility = View.GONE
        btnSubmit.visibility = View.GONE
        btnNext.visibility = View.GONE

        if (index == 1) {
            btnNext.visibility = View.VISIBLE
        }else if(index == questions!!.size) {
            btnSubmit.visibility = View.VISIBLE
            btnPrevious.visibility = View.VISIBLE
        }else {
            btnNext.visibility = View.VISIBLE
            btnPrevious.visibility = View.VISIBLE
        }



        val question = questions!!["question$index"]
        question?.let {
            val description = findViewById<TextView>(R.id.description)
            description.text = it.description
            val optionAdapter = OptionAdapter(this, it)
            val optionList = findViewById<RecyclerView>(R.id.optionList)
            optionList.layoutManager = LinearLayoutManager(this)
            optionList.adapter = optionAdapter
            optionList.setHasFixedSize(true)
        }
    }
}