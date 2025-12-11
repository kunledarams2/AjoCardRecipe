package com.e.majocardn.presentation.views

import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.e.majocardn.R
import com.e.majocardn.presentation.RecipeState
import com.e.majocardn.presentation.RecipeViewModel
import com.e.majocardn.presentation.views.adapter.RecipesAdapter
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val vm: RecipeViewModel by viewModels()
    private val adapter = RecipesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val progress = findViewById<ProgressBar>(R.id.progressBar)

        val errorTxt = findViewById<TextView>(R.id.tvError)
        val recycler = findViewById<RecyclerView>(R.id.recyclerView)

        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch {
            vm.state.collect { state ->
                when (state) {
                    is RecipeState.Loading -> {
                        progress.isVisible = true
                        errorTxt.isVisible = false
                    }
                    is RecipeState.Success -> {
                        progress.isVisible = false
                        adapter.submit(state.recipes)
                    }
                    is RecipeState.Error -> {
                        progress.isVisible = false
                        errorTxt.isVisible = true
                        errorTxt.text = state.message
                    }
                }
            }
        }
    }
}
