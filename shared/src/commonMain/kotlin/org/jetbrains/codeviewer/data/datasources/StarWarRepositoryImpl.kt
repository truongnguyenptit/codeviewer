package org.jetbrains.codeviewer.data.datasources

import io.ktor.client.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import org.jetbrains.codeviewer.StarWarsApi
import org.jetbrains.codeviewer.data.network.PeopleDto
import org.jetbrains.codeviewer.domain.models.Person
import org.jetbrains.codeviewer.domain.repositories.StarWarRepository

class StarWarsRepositoryImpl(private val starWarsDataSource: StarWarsDataSource) : StarWarRepository {

    override suspend fun getPersonById(peopleId: Int): Flow<Person> {
        return starWarsDataSource.getPersonByIdResponse(peopleId).map { person ->
            // Perform any additional processing or saving here
            person
        }
    }
}