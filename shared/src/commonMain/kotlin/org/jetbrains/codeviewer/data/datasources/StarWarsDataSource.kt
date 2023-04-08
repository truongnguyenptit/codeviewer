package org.jetbrains.codeviewer.data.datasources

import kotlinx.coroutines.flow.Flow
import org.jetbrains.codeviewer.StarWarsApi
import org.jetbrains.codeviewer.domain.models.Person

class StarWarsDataSource(private val starWarsService: StarWarsApi) {

    suspend fun getPersonByIdResponse(peopleId: Int): Person {
        return starWarsService.getPersonByIdResponse(peopleId)
    }
}