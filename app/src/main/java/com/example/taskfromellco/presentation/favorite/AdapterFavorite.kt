package com.example.taskfromellco.presentation.favorite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.taskfromellco.R
import com.example.taskfromellco.databinding.ItemRecyclerViewBinding
import com.example.taskfromellco.domain.model.ArticalDomainModel

class AdapterFavorite(
    private val removeFavorite: (ArticalDomainModel) -> Unit
) :
    ListAdapter<ArticalDomainModel, AdapterFavorite.ViewHolder>(DIFF_UTIL) {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemRecyclerViewBinding.bind(view)

        fun bind(
            item: ArticalDomainModel,
            removeFavorite: (ArticalDomainModel) -> Unit
        ) =
            with(binding) {
                nameItem.text = item.author
                descriptionItem.text = item.description
                dateItem.text = item.publishedAt
                Glide.with(binding.root).load(item.urlToImage).into(imageItem)

                favotireItem.setOnClickListener {
//                    if (item.isFavorite) {
//                        favotireitem.setImageDrawable(favotireitem.context.getDrawable(R.drawable.active_favorite))
//                        item.isFavorite = true
//                        removeFavorite.invoke(item)
//                    } else {
//                        favotireitem.setImageDrawable(favotireitem.context.getDrawable(R.drawable.not_active_favorite))
//                        item.isFavorite = false
                        removeFavorite.invoke(item)
//                    }
                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), removeFavorite)
    }

    companion object {
        private val DIFF_UTIL = object : DiffUtil.ItemCallback<ArticalDomainModel>() {
            override fun areItemsTheSame(
                oldItem: ArticalDomainModel,
                newItem: ArticalDomainModel
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: ArticalDomainModel,
                newItem: ArticalDomainModel
            ): Boolean {
                return oldItem == newItem
            }

        }
    }
}