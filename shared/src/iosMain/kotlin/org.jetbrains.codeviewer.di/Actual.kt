package org.jetbrains.codeviewer.di

import com.russhwolf.settings.Settings
import com.russhwolf.settings.NSUserDefaultsSettings
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import io.ktor.client.engine.darwin.*
import org.jetbrains.codeviewer.share.cache.AppDatabase
import org.koin.core.KoinApplication
import org.koin.dsl.module
import platform.Foundation.NSUserDefaults

actual fun platformModule() = module {
    single {
        val driver = NativeSqliteDriver(AppDatabase.Schema, "app.db")
        StarWarsDatabaseWrapper(AppDatabase(driver))
    }
//    single { Darwin.create() }
}

fun initKoinIos(
    userDefaults: NSUserDefaults,
    doOnStartup: () -> Unit
): KoinApplication = initKoin{
    module {
        single<Settings> { NSUserDefaultsSettings(userDefaults) }
        single { doOnStartup }
    }
}
