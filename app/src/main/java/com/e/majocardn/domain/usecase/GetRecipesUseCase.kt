package com.e.majocardn.domain.usecase

import com.e.majocardn.data.repository.RecipeRepository
import com.e.majocardn.domain.model.Recipe
import javax.inject.Inject

class GetRecipesUseCase @Inject constructor(
    private val repo: RecipeRepository
) {
    suspend operator fun invoke(): List<Recipe> =
        repo.fetchRecipes()
}
