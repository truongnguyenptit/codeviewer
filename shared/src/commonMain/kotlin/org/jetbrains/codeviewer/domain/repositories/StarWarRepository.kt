package org.jetbrains.codeviewer.domain.repositories

import org.jetbrains.codeviewer.domain.models.Person

interface StarWarRepository {
    suspend fun getPersonById(forceReload: Boolean, peopleId: Int): Person
}