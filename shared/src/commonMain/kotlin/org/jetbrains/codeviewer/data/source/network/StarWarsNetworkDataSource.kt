package org.jetbrains.codeviewer.data.source.network

import org.jetbrains.codeviewer.StarWarsApi
import org.jetbrains.codeviewer.domain.models.Person

class StarWarsNetworkDataSource(private val starWarsService: StarWarsApi) {
    suspend fun getPersonByIdResponse(peopleId: Int): Person {
        return starWarsService.getPersonByIdResponse(peopleId)
    }
}