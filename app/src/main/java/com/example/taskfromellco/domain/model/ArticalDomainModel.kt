package com.example.taskfromellco.domain.model

data class ArticalDomainModel(
    val id: Int = UNDEFINED_ID,
    val author: String? = null,
    val content: String? = null,
    val description: String? = null,
    val publishedAt: String? = null,
//    val source: Source,
    val title: String? = null,
    val url: String? = null,
    val urlToImage: String? = null,
    var isFavorite: Boolean
) {
    companion object {
        private const val UNDEFINED_ID = -1
        const val EMPTY_NAME = "Имя"
        const val EMPTY = ""
    }
}