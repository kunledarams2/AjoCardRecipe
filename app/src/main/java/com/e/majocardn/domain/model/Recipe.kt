package com.e.majocardn.domain.model

data class Recipe(
    val calories: String,
    val carbos: String,
    val description: String,
    val difficulty: Long,
    val fats: String,
    val headline: String,
    val id: String,
    val image: String,
    val name: String,
    val proteins: String,
    val thumb: String,
    val time: String,
    val country: String? = null
)
