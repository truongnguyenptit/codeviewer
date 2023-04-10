package org.jetbrains.codeviewer.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.codeviewer.ui.icons.CalendarMonth
import org.jetbrains.codeviewer.ui.icons.LocalFireDepartment
import org.jetbrains.codeviewer.ui.icons.Schedule
import org.jetbrains.codeviewer.ui.icons.Settings
import org.jetbrains.codeviewer.ui.settings.SettingsView
import org.jetbrains.codeviewer.ui.util.observeAsState
import org.jetbrains.codeviewer.viewmodel.ApplicationViewModel

@Composable
internal fun BottomNavigationView(viewModel: ApplicationViewModel, modifier: Modifier = Modifier) {
    val selectedTab by viewModel.observeSelectedTab.observeAsState()

    Scaffold(
        modifier = modifier,
        bottomBar = {
            BottomNavigation(elevation = 0.dp, backgroundColor = MaterialTheme.colors.primary) {
                viewModel.tabs.forEach { tab ->
                    val (title, icon) = when (tab) {
                        ApplicationViewModel.Tab.Schedule -> "Schedule" to Icons.Filled.CalendarMonth
                        ApplicationViewModel.Tab.MyAgenda -> "My Agenda" to Icons.Filled.Schedule
                        ApplicationViewModel.Tab.Sponsors -> "Sponsors" to Icons.Filled.LocalFireDepartment
                        ApplicationViewModel.Tab.Settings -> "Settings" to Icons.Filled.Settings
                    }
                    BottomNavigationItem(
                        icon = { Icon(imageVector = icon, contentDescription = null) },
                        label = { Text(text = title) },
                        selected = selectedTab == tab,
                        onClick = {
                            viewModel.selectedTab = tab
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            when (selectedTab) {
                ApplicationViewModel.Tab.Schedule -> SettingsView(viewModel.settings)
                ApplicationViewModel.Tab.MyAgenda -> SettingsView(viewModel.settings)
                ApplicationViewModel.Tab.Sponsors -> SettingsView(viewModel.settings)
                ApplicationViewModel.Tab.Settings -> SettingsView(viewModel.settings)
            }
        }
    }

//    val feedback by viewModel.observePresentedFeedback.observeAsState()
//    feedback?.let {
//        FeedbackDialog(it)
//    }
}
