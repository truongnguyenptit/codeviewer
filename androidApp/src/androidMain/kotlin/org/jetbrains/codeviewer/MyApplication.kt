package org.jetbrains.codeviewer

import android.app.Application
import com.russhwolf.settings.ExperimentalSettingsApi
import org.jetbrains.codeviewer.di.initKoin
import org.jetbrains.codeviewer.di.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.Koin
import org.koin.core.KoinApplication
import org.koin.core.logger.Level
@OptIn(ExperimentalSettingsApi::class)
class MyApplication: Application() {

    lateinit var koin: KoinApplication

    override fun onCreate() {
        super.onCreate()
        val appModules = listOf(uiModule)
        koin = initKoin {
            androidLogger(level = if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(androidContext = this@MyApplication)
            modules(appModules)
        }
    }
}