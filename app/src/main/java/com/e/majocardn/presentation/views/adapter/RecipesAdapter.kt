package com.e.majocardn.presentation.views.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.e.majocardn.R
import com.e.majocardn.domain.model.Recipe

class RecipesAdapter(
//    private val items: List<Recipe>,
//    private val onRecipeClick: (Recipe) -> Unit
) : RecyclerView.Adapter<RecipesAdapter.RecipeViewHolder>() {

    private val items = mutableListOf<Recipe>()

    fun submit(data: List<Recipe>) {
        items.clear()
        items.addAll(data)
        notifyDataSetChanged()
    }

    inner class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val imgThumb: ImageView = itemView.findViewById(R.id.imgThumb)
        private val txtName: TextView = itemView.findViewById(R.id.txtName)
        private val txtHeadline: TextView = itemView.findViewById(R.id.txtHeadline)
        private val txtCalories: TextView = itemView.findViewById(R.id.txtCalories)
        private val txtTime: TextView = itemView.findViewById(R.id.txtTime)
        private val txtDifficulty: TextView = itemView.findViewById(R.id.txtDifficulty)

        fun bind(recipe: Recipe) {
            // load image
            Glide.with(imgThumb)
                .load(recipe.thumb)
                .into(imgThumb)

            txtName.text = recipe.name
            txtHeadline.text = recipe.headline
            txtCalories.text = recipe.calories
            txtTime.text = recipe.time
            txtDifficulty.text = difficultyToText(recipe.difficulty.toInt())

            itemView.setOnClickListener {
//                onRecipeClick(recipe)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recipe, parent, false)
        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    private fun difficultyToText(level: Int) = when(level) {
        0 -> "Easy"
        1 -> "Medium"
        else -> "Hard"
    }
}
