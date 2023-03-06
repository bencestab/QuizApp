package com.example.quizapp.adapters

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.R
import com.example.quizapp.activites.QuestionActivity
import com.example.quizapp.utils.ColorPicker
import com.example.quizapp.utils.IconPicker



class QuizAdapter(val quizzes: List<String>): RecyclerView.Adapter<QuizAdapter.QuizViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.quiz_item, parent, false)
        return QuizViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuizViewHolder, position: Int) {
        val context = holder.itemView.context
        holder.quizTitle.text = quizzes[position]
        holder.quizView.setCardBackgroundColor(Color.parseColor(ColorPicker.getColor()))
        holder.quizIcon.setImageResource(IconPicker.getIcon())
        holder.itemView.setOnClickListener{
            Toast.makeText(context,quizzes[position], Toast.LENGTH_SHORT).show()
            val intent = Intent(context, QuestionActivity::class.java)
            intent.putExtra("DATE", quizzes[position])
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return quizzes.size
    }

    class QuizViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var quizIcon = itemView.findViewById<ImageView>(R.id.quizIcon)
        var quizTitle = itemView.findViewById<TextView>(R.id.quizTitle)
        var quizView = itemView.findViewById<CardView>(R.id.quizView)


    }
}