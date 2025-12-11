package com.e.majocardn.data.remote

import com.e.majocardn.domain.model.Recipe
import retrofit2.http.GET

interface RecipeApi {
    @GET("android-test/recipes.json")
    suspend fun getRecipes(): List<Recipe>
}