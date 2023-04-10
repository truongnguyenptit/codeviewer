package org.jetbrains.codeviewer

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.codeviewer.platform._HomeFolder
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import org.brightify.hyperdrive.multiplatformx.LifecycleGraph
import org.jetbrains.codeviewer.presentation.LoadPersonPresenter
import org.jetbrains.codeviewer.ui.theme.Colors
import org.jetbrains.codeviewer.viewmodel.ApplicationViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.io.File
import java.io.FileOutputStream

class MainActivity : ComponentActivity(), KoinComponent {

//    fun greet(): String {
//        return Greeting().greeting()
//    }

//    private val loadPersonPresenter: LoadPersonPresenter by inject()
//
    private val applicationViewModel: ApplicationViewModel by inject()

    private val root = LifecycleGraph.Root(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Box() {
                Text("Hahalolo")
                MainView(viewModel = applicationViewModel)
            }

        }
//        copyAssets()
//        _HomeFolder = filesDir
//        loadPersonPresenter.loadPeople(true, 3)
//        setContent {
//            val state = loadPersonPresenter.getPeople.collectAsState()
//
//            Log.d(MainActivity::class.java.simpleName, state.value.toString())
//            MainView(state.value)
//        }
    }

//    private fun copyAssets() {
//        for (filename in assets.list("data")!!) {
//            assets.open("data/$filename").use { assetStream ->
//                val file = File(filesDir, filename)
//                FileOutputStream(file).use { fileStream ->
//                    assetStream.copyTo(fileStream)
//                }
//            }
//        }
//    }
}