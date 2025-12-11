package com.e.majocardn.data.repository

import com.e.majocardn.data.remote.RecipeApi
import com.e.majocardn.domain.model.Recipe
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(
    private val api: RecipeApi
) : RecipeRepository {

    override suspend fun fetchRecipes(): List<Recipe> {
        return api.getRecipes()
    }
}