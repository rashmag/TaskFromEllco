package com.example.taskfromellco.domain.model

data class ArticalDomainModel(
    val id: Int = UNDEFINED,
    val author: String? = null,
    val content: String,
    val description: String,
    val publishedAt: String,
//    val source: SourceDomainModel,
    val title: String,
    val url: String,
    val urlToImage: String,
    var isFavorite: Boolean
) {
    companion object {
        private const val UNDEFINED = -1
        const val EMPTY_NAME = "Имя"
    }
}