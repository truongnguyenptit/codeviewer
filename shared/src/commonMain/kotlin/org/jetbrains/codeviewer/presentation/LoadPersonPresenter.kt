package org.jetbrains.codeviewer.presentation

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.jetbrains.codeviewer.domain.models.Person
import org.jetbrains.codeviewer.domain.usecases.GetPersonByIdUseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class LoadPersonPresenter : KoinComponent {
    private val getPersonByIdUseCase: GetPersonByIdUseCase by inject()

    private val _getPeople = MutableStateFlow<Person?>(null)
    val getPeople = _getPeople.asStateFlow()

    fun loadPeople(forceReload: Boolean, personId: Int) {
        kotlinx.coroutines.GlobalScope.launch {
            val map = mutableMapOf<String, Any?>()
            map["forceReload"] = forceReload
            map["personId"] = personId
            val result = getPersonByIdUseCase(map)
            _getPeople.value = result
            println("result " + result)
        }
    }
}