package com.example.quizapp.adapters
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.R
import com.example.quizapp.utils.ColorPicker
import com.example.quizapp.utils.IconPicker

class QuizAdapter(val quizzes: List<String>): RecyclerView.Adapter<QuizAdapter.QuizViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.quiz_item, parent, false)
        return QuizViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuizViewHolder, position: Int) {
        holder.quizTitle.text = quizzes[position]
        holder.quizView.setCardBackgroundColor(Color.parseColor(ColorPicker.getColor()))
        holder.quizIcon.setImageResource(IconPicker.getIcon())
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