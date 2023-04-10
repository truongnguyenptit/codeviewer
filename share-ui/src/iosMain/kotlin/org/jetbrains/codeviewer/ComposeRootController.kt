package org.jetbrains.codeviewer

import androidx.compose.ui.window.Application
import org.jetbrains.codeviewer.ui.MainComposeView
import org.jetbrains.codeviewer.viewmodel.ApplicationViewModel

fun getRootController(viewModel: ApplicationViewModel) = Application("MainComposeView") {
    MainComposeView(viewModel)
}
