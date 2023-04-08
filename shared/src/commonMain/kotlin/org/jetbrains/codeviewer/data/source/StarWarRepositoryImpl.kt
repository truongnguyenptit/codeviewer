package org.jetbrains.codeviewer.data.source

import org.jetbrains.codeviewer.data.source.network.StarWarsNetworkDataSource
import org.jetbrains.codeviewer.domain.models.Person
import org.jetbrains.codeviewer.domain.repositories.StarWarRepository

class StarWarsRepositoryImpl(private val starWarsDataSource: StarWarsNetworkDataSource) : StarWarRepository {

    override suspend fun getPersonById(peopleId: Int): Person {
        return starWarsDataSource.getPersonByIdResponse(peopleId)
    }
}