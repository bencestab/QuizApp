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
        populateDummyData()
        setUpViews()

    }

    private fun populateDummyData() {
        quizList.add(Quiz(id = "23-23-24",title="vhgdfi"))
        quizList.add(Quiz(id = "23-23-24",title="vlhgdfmi"))
        quizList.add(Quiz(id = "23-23-24",title="fdsami"))
        quizList.add(Quiz(id = "23-23-24",title="vlafdsai"))
        quizList.add(Quiz(id = "23-23-24",title="vlfdsai"))
        quizList.add(Quiz(id = "23-23-24",title="vlfdsai"))
    }


    fun setUpViews() {
        setUpDrawerLayout()
        setUpRecyclerView()
    }

    private fun setUpRecyclerView(){
        val quizRecyclerView = findViewById<RecyclerView>(R.id.quizRecyclerView)
        adapter = QuizAdapter(quizList)
        quizRecyclerView.adapter = adapter
        quizRecyclerView.layoutManager = GridLayoutManager(this,2)

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