package org.jetbrains.codeviewer.domain.repositories

import kotlinx.coroutines.flow.Flow
import org.jetbrains.codeviewer.data.network.PeopleDto
import org.jetbrains.codeviewer.domain.models.Person

interface StarWarRepository {
    suspend fun getPersonById(peopleId: Int): Flow<Person>
}