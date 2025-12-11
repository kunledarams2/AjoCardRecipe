# AjoCardRecipe
 A single-page Android application that fetches and displays a list of recipes from a remote JSON source:
 Source:
 https://hf-android-app.s3-eu-west-1.amazonaws.com/android-test/recipes.json
 ##Features

 1. Fetch recipes over HTTP
 2. Show loading & error states
 3. XML UI (RecyclerView)
 4. Clean Architecture (Use Cases, Repository)
 5. SOLID principles
 6. Unit tested (ViewModel + Use Case)
 7. Hilt for dependency injection
6. Offline-ready structure (repository abstraction)

## Screens

 Recipe List Page

 Displays name, image, calories, cooking time

 Clicking items can be extended for navigation

 States

 Loading spinner

 Success list

 Error 

## Architecture Overview
 Layers
 data/
 remote/ → Retrofit API
 repository/ → RecipeRepositoryImpl
 domain/
 model/ → Recipe
 repository/ → RecipeRepository
 usecase/ → GetRecipesUseCase
 presentation/
 viewmodel/ → RecipeViewModel
 ui/ → Activities & Adapters
 di/
 Hilt modules
