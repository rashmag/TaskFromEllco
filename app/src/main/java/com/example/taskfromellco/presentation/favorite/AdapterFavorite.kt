package com.example.taskfromellco.presentation.favorite

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
import com.example.taskfromellco.domain.model.ArticalDomainModel.Companion.EMPTY_NAME

class AdapterFavorite(
    private val removeFavorite: (ArticalDomainModel) -> Unit,
    private val onClick: (ArticalDomainModel) -> Unit
) : ListAdapter<ArticalDomainModel, AdapterFavorite.ViewHolder>(DIFF_UTIL) {

    inner class ViewHolder(private val binding: ItemRecyclerViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            item: ArticalDomainModel
        ) = with(binding) {
            nameItem.text = item.author ?: EMPTY_NAME
            descriptionItem.text = item.description
            dateItem.text = String.format(
                dateItem.context.getString(R.string.date_publish_lenta),
                item.publishedAt?.substring(0, 10)
            )
            Glide.with(binding.root).load(item.urlToImage).into(imageItem)

            if (item.isFavorite) {
                favotireItem.setImageDrawable(favotireItem.context.getDrawable(R.drawable.active_favorite))
            } else {
                favotireItem.setImageDrawable(favotireItem.context.getDrawable(R.drawable.not_active_favorite))
            }
            favotireItem.setOnClickListener {
                removeFavorite.invoke(item)
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
        private val DIFF_UTIL = object : DiffUtil.ItemCallback<ArticalDomainModel>() {
            override fun areItemsTheSame(
                oldItem: ArticalDomainModel,
                newItem: ArticalDomainModel
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: ArticalDomainModel,
                newItem: ArticalDomainModel
            ): Boolean {
                return oldItem.author == newItem.author && oldItem.description == newItem.description &&
                        oldItem.author == newItem.author && oldItem.id == newItem.id &&
                        oldItem.content == newItem.content && oldItem.publishedAt == newItem.publishedAt &&
                        oldItem.url == newItem.url && oldItem.title == newItem.title &&
                        oldItem.urlToImage == newItem.urlToImage
            }
        }
    }
}