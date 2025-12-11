package com.e.majocardn.presentation

import com.e.majocardn.domain.model.Recipe

sealed class RecipeState {
    object Loading : RecipeState()
    data class Success(val recipes: List<Recipe>) : RecipeState()
    data class Error(val message: String) : RecipeState()
}