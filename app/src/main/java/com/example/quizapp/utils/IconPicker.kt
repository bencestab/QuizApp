package com.example.quizapp.utils

import com.example.quizapp.R

object IconPicker {
    val icons = arrayOf(
        R.drawable.icon_plum,
        R.drawable.icon_graps,
        R.drawable.icon_peaches,
        R.drawable.icon_pineapple,
        R.drawable.icon_avocados
    )
    var currentIconIndex = 0

    fun getIcon(): Int {
        currentIconIndex = (currentIconIndex + 1) % icons.size
        return icons[currentIconIndex]
    }
}