package com.example.quizapp.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.R
import com.example.quizapp.adapters.OptionAdapter
import com.example.quizapp.models.Question

class QuestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        bindViews()
    }

    private fun bindViews() {
        val question = Question(
            description = "Mi magyarorszag fovarosa?",
            option1 = "Ozd",
            option2 = "Budapest",
            option3 = "Eger",
            option4 = "Tiszakeszke",
            answer = "Ozd"
        )

        val description = findViewById<TextView>(R.id.description)
        description.text = question.description

        val optionAdapter = OptionAdapter(this, question)
        val optionList = findViewById<RecyclerView>(R.id.optionList)
        optionList.layoutManager = LinearLayoutManager(this)
        optionList.adapter = optionAdapter
        optionList.setHasFixedSize(true)
    }


}