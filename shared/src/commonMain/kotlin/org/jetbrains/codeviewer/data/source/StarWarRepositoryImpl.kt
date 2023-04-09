package org.jetbrains.codeviewer.data.source

import org.jetbrains.codeviewer.data.source.network.StarWarsNetworkDataSource
import org.jetbrains.codeviewer.data.source.local.StarWarsLocalDataSource
import org.jetbrains.codeviewer.domain.models.Person
import org.jetbrains.codeviewer.domain.repositories.StarWarRepository

class StarWarsRepositoryImpl(private val network: StarWarsNetworkDataSource, private val local: StarWarsLocalDataSource) : StarWarRepository {
    override suspend fun getPersonById(forceReload: Boolean, peopleId: Int): Person {
        val cachedPersons = local.getAllPersons()
        return if (cachedPersons.isNotEmpty() && !forceReload) {
            println("Load from DB")
            cachedPersons[0]
        } else {
            network.getPersonByIdResponse(peopleId).also {
                local.clearDatabase()
                val listPeople = mutableListOf<Person>()
                listPeople.add(it)
                local.createPeople(listPeople)
            }
        }
    }
}