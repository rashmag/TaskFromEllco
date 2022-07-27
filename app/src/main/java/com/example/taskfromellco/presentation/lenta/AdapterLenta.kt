package com.example.taskfromellco.presentation.lenta

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.taskfromellco.R
import com.example.taskfromellco.data.remote_db.ArticleModel
import com.example.taskfromellco.databinding.ItemRecyclerViewBinding
import com.example.taskfromellco.domain.model.ArticalDomainModel
import com.example.taskfromellco.utils.MainMapper


class AdapterLenta(
    private val isFavorite: (ArticalDomainModel) -> Unit,
    private val onClick: (ArticleModel) -> Unit
) :
    ListAdapter<ArticleModel, AdapterLenta.ViewHolder>(DIFF_UTIL) {

    inner class ViewHolder(private val binding: ItemRecyclerViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ArticleModel) = with(binding) {
            nameItem.text = item.author
            descriptionItem.text = item.description
            Glide.with(binding.root)
                .load(item.urlToImage)
                .into(imageItem)
            favotireItem.setOnClickListener {
                item.isFavorite = true
                isFavorite.invoke(
                    MainMapper().mapArticleModelToArticalDomainModel(item)
                )
                favotireItem.setImageDrawable(favotireItem.context.getDrawable(R.drawable.active_favorite))
            }
            itemView.setOnClickListener {
                onClick.invoke(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ItemRecyclerViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val DIFF_UTIL = object : DiffUtil.ItemCallback<ArticleModel>() {
            override fun areItemsTheSame(oldItem: ArticleModel, newItem: ArticleModel): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: ArticleModel, newItem: ArticleModel): Boolean {
                return oldItem.author == newItem.author && oldItem.description == newItem.description &&
                        oldItem.author == newItem.author && oldItem.urlToImage == newItem.urlToImage &&
                        oldItem.content == newItem.content && oldItem.publishedAt == newItem.publishedAt &&
                        oldItem.url == newItem.url && oldItem.title == newItem.title
            }
        }
    }
}