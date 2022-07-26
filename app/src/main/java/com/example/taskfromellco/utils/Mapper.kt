package com.example.taskfromellco.utils

import android.util.Log
import com.example.taskfromellco.data.local_db.MainModelEntity
import com.example.taskfromellco.data.remote_db.ArticleModel
import com.example.taskfromellco.domain.model.ArticalDomainModel

class MainMapper {

    fun mapArticalDomainModelToMainModel(articalDomainModel: ArticalDomainModel): MainModelEntity = MainModelEntity(
        author = articalDomainModel.author ?: ArticalDomainModel.EMPTY_NAME,
        content = articalDomainModel.content,
        description = articalDomainModel.description,
        title = articalDomainModel.title,
        url = articalDomainModel.url,
        urlToImage = articalDomainModel.urlToImage,
        publishedAt = articalDomainModel.publishedAt,
        isFavorite = articalDomainModel.isFavorite
    )
    fun mapArticalDomainModelToMainModelDelete(articalDomainModel: ArticalDomainModel): MainModelEntity = MainModelEntity(
        id = articalDomainModel.id,
        author = articalDomainModel.author ?: ArticalDomainModel.EMPTY_NAME,
        content = articalDomainModel.content,
        description = articalDomainModel.description,
        title = articalDomainModel.title,
        url = articalDomainModel.url,
        urlToImage = articalDomainModel.urlToImage,
        publishedAt = articalDomainModel.publishedAt,
        isFavorite = articalDomainModel.isFavorite
    )

    fun mapMainModelToArticalDomainModel(mainModelEntity: MainModelEntity): ArticalDomainModel {
        Log.d("test3","id = ${mainModelEntity.id}")
        return ArticalDomainModel(
            id = mainModelEntity.id,
            author = mainModelEntity.author,
            content = mainModelEntity.content,
            description = mainModelEntity.description,
            title = mainModelEntity.title,
            url = mainModelEntity.url,
            urlToImage = mainModelEntity.urlToImage,
            publishedAt = mainModelEntity.publishedAt,
            isFavorite = mainModelEntity.isFavorite
        )
    }

    fun mapArticleModelToArticalDomainModel(articleModel: ArticleModel): ArticalDomainModel = ArticalDomainModel(
        author = articleModel.author,
        content = articleModel.content,
        description = articleModel.description,
        title = articleModel.title,
        url = articleModel.url,
        urlToImage = articleModel.urlToImage,
        publishedAt = articleModel.publishedAt,
        isFavorite = articleModel.isFavorite
    )

    fun mapListMainModelToListEntity(list: List<MainModelEntity>) = list.map {
        mapMainModelToArticalDomainModel(it)
    }
}