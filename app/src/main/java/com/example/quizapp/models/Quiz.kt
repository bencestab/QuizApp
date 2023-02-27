package com.example.quizapp.models

data class Quiz (
    var id : String ="",
    var title : String ="",
    var question: MutableMap<String,Question> = mutableMapOf()
)