package org.jetbrains.codeviewer.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.codeviewer.ui.theme.DroidconTheme
import org.jetbrains.codeviewer.viewmodel.ApplicationViewModel

@Composable
internal fun MainComposeView(viewModel: ApplicationViewModel, modifier: Modifier = Modifier) {
    DroidconTheme {
        BottomNavigationView(viewModel = viewModel, modifier = modifier)
    }
}
