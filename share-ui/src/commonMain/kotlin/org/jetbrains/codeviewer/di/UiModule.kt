package org.jetbrains.codeviewer.di

import org.jetbrains.codeviewer.viewmodel.ApplicationViewModel
import org.jetbrains.codeviewer.viewmodel.settings.SettingsViewModel
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module

val uiModule = module {
    // MARK: View model factories.
    single {
        ApplicationViewModel(
            settingsFactory = get()
        )
    }

    single { SettingsViewModel.Factory(get()) }
}