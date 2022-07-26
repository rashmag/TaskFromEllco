package com.example.taskfromellco.domain.model

data class ArticalDomainModel(
    val id: Int = UNDEFINED_ID,
    val author: String? = null,
    val content: String,
    val description: String,
    val publishedAt: String,
//    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String,
    var isFavorite: Boolean
) {
    companion object {
        private const val UNDEFINED_ID = -1
        const val EMPTY_NAME = "Имя"
    }
}