package com.example.quizapp.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.R
import com.example.quizapp.adapters.QuizAdapter
import com.example.quizapp.models.Quiz
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {

    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    lateinit var adapter: QuizAdapter
    private var quizList = mutableListOf<Quiz>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ValamiData()
        setUpViews()

    }

    private fun ValamiData() {
        quizList.add(Quiz(id = "Quiz1", title = "Quiz1"))
        quizList.add(Quiz(id = "Quiz2", title = "Quiz2"))
        quizList.add(Quiz(id = "Quiz3", title = "Quiz3"))
        quizList.add(Quiz(id = "Quiz4", title = "Quiz4"))
    }

    fun setUpViews() {
        setUpDrawerLayout()
        setUpRecyclerView()
    }

  fun setUpRecyclerView(){
        val quizRecyclerView = findViewById<RecyclerView>(R.id.quizRecyclerView)
        quizRecyclerView.layoutManager = GridLayoutManager(this,1)
        adapter = QuizAdapter(quizList.map { it.title })
      quizRecyclerView.adapter = adapter

    }

    fun setUpDrawerLayout(){
        val appBar = findViewById<MaterialToolbar>(R.id.appBar)
        val mainDrawer = findViewById<DrawerLayout>(R.id.mainDrawer)
        setSupportActionBar(appBar)
        actionBarDrawerToggle = ActionBarDrawerToggle(this, mainDrawer,
            R.string.app_name,
            R.string.app_name)
        actionBarDrawerToggle.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}