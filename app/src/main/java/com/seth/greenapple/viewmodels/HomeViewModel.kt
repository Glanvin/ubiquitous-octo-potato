package com.seth.greenapple.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.seth.greenapple.R

class HomeViewModel: ViewModel() {

    private val drawableList = listOf(
        R.drawable.bocchi,
        R.drawable.cid,
        R.drawable.gojo,
        R.drawable.tanjiro
    )

    val items = mutableStateListOf<Pair<String, Int>>()

    init {
        generateItems()
    }

    private fun generateItems() {
        for (i in 1..50) {
            val randomDrawable = drawableList.random()
            items.add("Title $i" to randomDrawable)
        }
    }
}