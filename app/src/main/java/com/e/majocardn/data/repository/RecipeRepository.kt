package com.e.majocardn.data.repository

import com.e.majocardn.domain.model.Recipe

interface RecipeRepository {
    suspend fun fetchRecipes(): List<Recipe>
}