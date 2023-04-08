package org.jetbrains.codeviewer.domain.usecases

import kotlinx.coroutines.flow.Flow
import org.jetbrains.codeviewer.domain.models.Person
import org.jetbrains.codeviewer.domain.repositories.StarWarRepository

class GetPersonByIdUseCase(private val starWarsRepository: StarWarRepository) :
    UseCase<Int, Person>() {

    override suspend fun run(params: Int): Person {
        return starWarsRepository.getPersonById(params)
    }
}