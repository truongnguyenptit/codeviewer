package org.jetbrains.codeviewer

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.codeviewer.platform._HomeFolder
import MainView
import android.util.Log
import androidx.compose.runtime.collectAsState
import org.jetbrains.codeviewer.presentation.LoadPersonPresenter
import org.koin.android.ext.android.inject
import java.io.File
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {

//    fun greet(): String {
//        return Greeting().greeting()
//    }

    private val loadPersonPresenter: LoadPersonPresenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        copyAssets()
        _HomeFolder = filesDir
        loadPersonPresenter.loadPeople(2)
        setContent {
            val state = loadPersonPresenter.getPeople.collectAsState()

            Log.d(MainActivity::class.java.simpleName, state.value.toString())
            MainView(state.value)
        }
    }

    private fun copyAssets() {
        for (filename in assets.list("data")!!) {
            assets.open("data/$filename").use { assetStream ->
                val file = File(filesDir, filename)
                FileOutputStream(file).use { fileStream ->
                    assetStream.copyTo(fileStream)
                }
            }
        }
    }
}