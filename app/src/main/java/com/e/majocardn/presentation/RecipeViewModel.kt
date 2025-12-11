package com.e.majocardn.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.e.majocardn.domain.usecase.GetRecipesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(
    private val getRecipesUseCase: GetRecipesUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<RecipeState>(RecipeState.Loading)
    val state: StateFlow<RecipeState> = _state

    init {
        load()
    }

    fun load() {
        viewModelScope.launch {
            try {
                val data = getRecipesUseCase()
                _state.value = RecipeState.Success(data)
            } catch (e: Exception) {
                _state.value = RecipeState.Error(e.localizedMessage ?: "Unknown error")
            }
        }
    }
}


