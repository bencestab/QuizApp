package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpviews()
    }

    fun setUpviews() {
        setUpDrawerLayout()
    }

    fun setUpDrawerLayout(){
        val appBar = findViewById<MaterialToolbar>(R.id.appBar)
        val maindrawer = findViewById<DrawerLayout>(R.id.mainDrawer)
        setSupportActionBar(appBar)
        actionBarDrawerToggle = ActionBarDrawerToggle(this, maindrawer, R.string.app_name, R.string.app_name)
        actionBarDrawerToggle.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}