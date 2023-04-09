package org.jetbrains.codeviewer.domain.usecases

import kotlinx.coroutines.flow.Flow
import org.jetbrains.codeviewer.domain.models.Person
import org.jetbrains.codeviewer.domain.repositories.StarWarRepository

class GetPersonByIdUseCase(private val starWarsRepository: StarWarRepository) :
    UseCase<Person>() {

    override suspend fun run(params: Map<String, Any?>): Person {
        val forceReload = params["forceReload"] as Boolean
        val personId = params["personId"] as Int
        return starWarsRepository.getPersonById(forceReload, personId)
    }
}