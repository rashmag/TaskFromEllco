package com.example.taskfromellco.utils

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.taskfromellco.data.local_db.MainModelEntity
import com.example.taskfromellco.data.remote_db.ArticleModel
import com.example.taskfromellco.domain.model.ArticalDomainModel

class MainMapper {

    fun mapArticalDomainModelToMainModel(articalDomainModel: ArticalDomainModel): MainModelEntity = MainModelEntity(
        author = articalDomainModel.author ?: ArticalDomainModel.EMPTY_NAME,
        content = articalDomainModel.content ?:ArticalDomainModel.EMPTY,
        description = articalDomainModel.description ?:ArticalDomainModel.EMPTY,
        title = articalDomainModel.title ?:ArticalDomainModel.EMPTY,
        url = articalDomainModel.url ?:ArticalDomainModel.EMPTY,
        urlToImage = articalDomainModel.urlToImage ?:ArticalDomainModel.EMPTY,
        publishedAt = articalDomainModel.publishedAt ?:ArticalDomainModel.EMPTY,
        isFavorite = articalDomainModel.isFavorite
    )
    fun mapArticalDomainModelToMainModelDelete(articalDomainModel: ArticalDomainModel): MainModelEntity = MainModelEntity(
        id = articalDomainModel.id,
        author = articalDomainModel.author ?: ArticalDomainModel.EMPTY_NAME,
        content = articalDomainModel.content ?:ArticalDomainModel.EMPTY,
        description = articalDomainModel.description ?:ArticalDomainModel.EMPTY,
        title = articalDomainModel.title ?:ArticalDomainModel.EMPTY,
        url = articalDomainModel.url ?:ArticalDomainModel.EMPTY,
        urlToImage = articalDomainModel.urlToImage ?:ArticalDomainModel.EMPTY,
        publishedAt = articalDomainModel.publishedAt ?:ArticalDomainModel.EMPTY,
        isFavorite = articalDomainModel.isFavorite
    )

    fun mapMainModelToArticalDomainModel(mainModelEntity: MainModelEntity): ArticalDomainModel {
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

    fun mapArticleDomainModelToArticalModel(articalDomainModel: ArticalDomainModel): ArticleModel = ArticleModel(
        author = articalDomainModel.author ?: ArticalDomainModel.EMPTY_NAME,
        content = articalDomainModel.content ?:ArticalDomainModel.EMPTY,
        description = articalDomainModel.description ?:ArticalDomainModel.EMPTY,
        title = articalDomainModel.title ?:ArticalDomainModel.EMPTY,
        url = articalDomainModel.url ?:ArticalDomainModel.EMPTY,
        urlToImage = articalDomainModel.urlToImage ?:ArticalDomainModel.EMPTY,
        publishedAt = articalDomainModel.publishedAt ?:ArticalDomainModel.EMPTY,
        isFavorite = articalDomainModel.isFavorite
    )

    fun mapListMainModelToListEntity(list: LiveData<List<MainModelEntity>>) = list.map {
        it.map {
            mapMainModelToArticalDomainModel(it)
        }
    }
}