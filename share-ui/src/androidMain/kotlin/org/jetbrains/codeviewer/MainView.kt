package org.jetbrains.codeviewer

import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.codeviewer.ui.MainComposeView
import org.jetbrains.codeviewer.viewmodel.ApplicationViewModel

@Composable
fun MainView(viewModel: ApplicationViewModel) {
    MainComposeView(viewModel = viewModel, modifier = Modifier.systemBarsPadding())
}
