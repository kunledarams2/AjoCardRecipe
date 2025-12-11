package com.e.majocardn

import com.e.majocardn.data.repository.RecipeRepository
import com.e.majocardn.domain.model.Recipe
import com.e.majocardn.domain.usecase.GetRecipesUseCase
import com.e.majocardn.presentation.RecipeState
import com.e.majocardn.presentation.RecipeViewModel
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test



@ExperimentalCoroutinesApi
class RecipeViewModelTest {

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    private val repo = mockk<RecipeRepository>()
    private val useCase = GetRecipesUseCase(repo)
    private lateinit var vm: RecipeViewModel

    @Before
    fun setup() {
        vm = RecipeViewModel(useCase)
    }

    @Test
    fun `load success updates state`() = runTest {
        coEvery { repo.fetchRecipes() } returns listOf(
            Recipe(
                                "516 kcal","47 g","Description...",0,"8 g",
                "Title","533143aaff604d567f8b4571",
                "https://img.hellofresh.com/...jpg",
                "Crispy Fish Goujons ","43 g",
                "https://img.hellofresh.com/...jpg","PT35M"
            )
        )

        vm.load()
        mainCoroutineRule.dispatcher.scheduler.advanceUntilIdle()

        val state = vm.state.value
        assertTrue(state is RecipeState.Success)
        assertEquals(1, (state as RecipeState.Success).recipes.size)
    }
}






//class RecipeViewModelTest {
//
//    private val repo = mockk<RecipeRepository>()
//    private val useCase = GetRecipesUseCase(repo)
//    private lateinit var vm: RecipeViewModel
//
//    @Before
//    fun setup() {
//        vm = RecipeViewModel(useCase)
//    }
//
//    @Test
//    fun `load success updates state`() = runTest {
//        // 1. Stub suspend function
//        coEvery { repo.fetchRecipes() } returns listOf(
//            Recipe(
//                "516 kcal","47 g","Description...",0,"8 g",
//                "Title","533143aaff604d567f8b4571",
//                "https://img.hellofresh.com/...jpg",
//                "Crispy Fish Goujons ","43 g",
//                "https://img.hellofresh.com/...jpg","PT35M"
//            )
//        )
//
//        // 2. Trigger loading
//        vm.load()
//
//        // 3. Let coroutines finish
//        advanceUntilIdle()
//
//        // 4. Check state
//        val state = vm.state.value
//        assertTrue(state is RecipeState.Success)
//        assertEquals(1, (state as RecipeState.Success).recipes.size)
//    }
//}



//@ExperimentalCoroutinesApi
//class RecipeViewModelTest {
//
//    @get:Rule
//    val coroutinesRule = MainCoroutineRule() // Your custom rule for test dispatcher
//
//    private val repo = mock<RecipeRepository>()
//    private val useCase = GetRecipesUseCase(repo)
//    private lateinit var vm: RecipeViewModel
//
//    @Test
//    fun `load success updates state`() = runTest {
//        // mock suspend function
//        coEvery { repo.fetchRecipes() } returns listOf(
//            Recipe(
//                "516 kcal","47 g","Description...",0,"8 g",
//                "Title","533143aaff604d567f8b4571",
//                "https://img.hellofresh.com/...jpg",
//                "Crispy Fish Goujons ","43 g",
//                "https://img.hellofresh.com/...jpg","PT35M"
//            )
//        )
//
//        vm = RecipeViewModel(useCase)
//
//        val state = vm.state.first()
//        assertTrue(state is RecipeState.Success)
//    }
//}







//@ExperimentalCoroutinesApi
//class RecipeViewModelTest {
//
//    @get:Rule
//    val coroutinesRule = MainCoroutineRule()
//
//    private val repo: RecipeRepository = mockk()
//    private val useCase = GetRecipesUseCase(repo)
//
//    private lateinit var vm: RecipeViewModel
//
//    @Before
//    fun setup() {
//        vm = RecipeViewModel(useCase)
//    }
//
//    @Test
//    fun `load success updates state`() = runTest {
//
//
//        whenever(repo.fetchRecipes()).thenReturn(
//            listOf(
//                Recipe(
//                    calories = "516 kcal",
//                    carbos = "47g",
//                    description = "There’s nothing like the simple things…",
//                    difficulty = 0,
//                    fats = "",
//                    headline = "Crispy Fish Goujons",
//                    id ="533143aaff604d567f8b4571",
//                    image = "https://img.hellofresh.com/f_auto,q_auto/hellofresh_s3/image/533143aaff604d567f8b4571.jpg",
//                    name = "with Sweet Potato Wedges and Minted Snap Peas",
//                    proteins = "8 g",
//                    thumb = "https://img.hellofresh.com/f_auto,q_auto,w_300/hellofresh_s3/image/533143aaff604d567f8b4571.jpg",
//                    time = "PT35M",
//                    country = "",
//
//                )
//            )
//        )
//
//        // WHEN
//        vm.load()
//
//        // THEN
//        val state = vm.state.first()
//        assertTrue(state is RecipeState.Success)
//    }
//}

