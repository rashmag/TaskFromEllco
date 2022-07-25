package com.example.taskfromellco.domain.model

data class DBModel(
    val id:Int = UNDEFINED,
    val value: String
) {
    companion object{
        private const val UNDEFINED = -1
    }
}