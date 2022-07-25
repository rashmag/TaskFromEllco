package com.example.taskfromellco.data.utils

import com.example.taskfromellco.domain.model.DBModel

class MainMapper {

    fun mapDBModelToMainModel(dbModel: DBModel): MainModel = MainModel(
        id = dbModel.id,
        value = dbModel.value
    )

    fun mapMainModelToDBModel(mainModel: MainModel): DBModel = DBModel(
        id = mainModel.id,
        value = mainModel.value
    )

    fun mapListMainModelToListEntity(list: List<MainModel>) = list.map {
        mapMainModelToDBModel(it)
    }
}