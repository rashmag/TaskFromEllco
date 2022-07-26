package com.example.taskfromellco.utils

import com.example.taskfromellco.data.remote_db.ArticleModel
import com.example.taskfromellco.data.utils.MainModel
import com.example.taskfromellco.domain.model.ArticalDomainModel

class MainMapper {

    fun mapArticalDomainModelToMainModel(articalDomainModel: ArticalDomainModel): MainModel = MainModel(
        id = articalDomainModel.id,
        author = articalDomainModel.author,
        content = articalDomainModel.content,
        description = articalDomainModel.description,
        source = articalDomainModel.source,
        title = articalDomainModel.title,
        url = articalDomainModel.url,
        urlToImage = articalDomainModel.urlToImage,
        publishedAt = articalDomainModel.publishedAt
    )

    fun mapMainModelToArticalDomainModel(mainModel: MainModel): ArticalDomainModel = ArticalDomainModel(
        id = mainModel.id,
        author = mainModel.author,
        content = mainModel.content,
        description = mainModel.description,
        source = mainModel.source,
        title = mainModel.title,
        url = mainModel.url,
        urlToImage = mainModel.urlToImage,
        publishedAt = mainModel.publishedAt,
        isFavorite = NOT_ACTIVE_FAVORITE
    )

    fun mapArticleModelToArticalDomainModel(articleModel: ArticleModel): ArticalDomainModel = ArticalDomainModel(
        id = UNDEFINED,
        author = articleModel.author,
        content = articleModel.content,
        description = articleModel.description,
        source = articleModel.source,
        title = articleModel.title,
        url = articleModel.url,
        urlToImage = articleModel.urlToImage,
        publishedAt = articleModel.publishedAt,
        isFavorite = NOT_ACTIVE_FAVORITE
    )

    fun mapListMainModelToListEntity(list: List<MainModel>) = list.map {
        mapMainModelToArticalDomainModel(it)
    }

    companion object{
        private const val UNDEFINED = -1
        private const val NOT_ACTIVE_FAVORITE = false
    }
}