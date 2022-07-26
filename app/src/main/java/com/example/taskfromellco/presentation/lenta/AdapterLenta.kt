package com.example.taskfromellco.presentation.lenta

import android.view.LayoutInflater
import android.view.View
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


class AdapterLenta(private val isFavorite: (ArticalDomainModel) -> Unit) :
    ListAdapter<ArticleModel, AdapterLenta.ViewHolder>(DIFF_UTIL) {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemRecyclerViewBinding.bind(view)

        fun bind(item: ArticleModel, isFavorite: (ArticalDomainModel) -> Unit) = with(binding) {
            nameItem.text = item.author
            descriptionItem.text = item.description
            Glide.with(binding.root)
                .load(item.urlToImage)
                .into(imageItem)
            dateItem.text = String.format(
                dateItem.context.getString(R.string.date_publish_lenta),
                item.publishedAt.substring(0, 10)
            )
            favotireItem.setOnClickListener {
                isFavorite.invoke(
                    MainMapper().mapArticleModelToArticalDomainModel(item)
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), isFavorite)
    }

    companion object {
        private val DIFF_UTIL = object : DiffUtil.ItemCallback<ArticleModel>() {
            override fun areItemsTheSame(oldItem: ArticleModel, newItem: ArticleModel): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: ArticleModel, newItem: ArticleModel): Boolean {
                return oldItem == newItem
            }

        }
    }
}