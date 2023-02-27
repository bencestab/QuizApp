package com.example.quizapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.R

class QuizAdapter(val quizzes: List<String>): RecyclerView.Adapter<QuizAdapter.QuizViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.quiz_item, parent, false)
        return QuizViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuizViewHolder, position: Int) {
        holder.quizTitle.text = quizzes[position]
    }

    override fun getItemCount(): Int {
        return quizzes.size
    }

    class QuizViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var cardContainer = itemView.findViewById<RelativeLayout>(R.id.cardContainer)
        var quizIcon = itemView.findViewById<ImageView>(R.id.quizIcon)
        var quizTitle = itemView.findViewById<TextView>(R.id.quizTitle)


    }
}