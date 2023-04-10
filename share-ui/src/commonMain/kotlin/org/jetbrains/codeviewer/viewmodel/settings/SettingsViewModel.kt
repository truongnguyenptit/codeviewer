package org.jetbrains.codeviewer.viewmodel.settings


import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.brightify.hyperdrive.multiplatformx.BaseViewModel
import org.jetbrains.codeviewer.domain.models.Person
import org.jetbrains.codeviewer.domain.usecases.GetPersonByIdUseCase
import org.jetbrains.codeviewer.presentation.LoadPersonPresenter
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import kotlin.time.Duration.Companion.days

class SettingsViewModel(
    val presenter: LoadPersonPresenter
) : BaseViewModel(), KoinComponent {

//    var isFeedbackEnabled by binding(
//        presenter.loadPeople(true, 3),
//        mapping = { it.isFeedbackEnabled },
//        set = { newValue ->
//            // TODO: Remove when `binding` supports suspend closures.
//            instanceLock.runExclusively {
//                settingsGateway.setFeedbackEnabled(newValue)
//            }
//        }
//    )
//    val observeIsFeedbackEnabled by observe(::isFeedbackEnabled)
//
//    var isRemindersEnabled by binding(
//        settingsGateway.settings(),
//        mapping = { it.isRemindersEnabled },
//        set = { newValue ->
//            // TODO: Remove when `binding` supports suspend closures.
//            instanceLock.runExclusively {
//                settingsGateway.setRemindersEnabled(newValue)
//            }
//        }
//    )
//    val observeIsRemindersEnabled by observe(::isRemindersEnabled)

//    var people: People? = null
//    val observePeople by observe(::people)

    private val getPersonByIdUseCase: GetPersonByIdUseCase by inject()

    private val _getPeople = MutableStateFlow<Person?>(null)
    val getPeople = _getPeople.asStateFlow()


    class Factory(
        val presenter: LoadPersonPresenter
    ) {

        fun create() = SettingsViewModel(presenter)
    }
}
