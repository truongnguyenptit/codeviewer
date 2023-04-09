package org.jetbrains.codeviewer.di

import com.squareup.sqldelight.android.AndroidSqliteDriver
import org.jetbrains.codeviewer.share.cache.AppDatabase
import org.koin.dsl.module

actual fun platformModule() = module {
    single {
        val driver = AndroidSqliteDriver(AppDatabase.Schema, get(), "app.db")
//            AndroidSqliteDriver(AppDatabase.Schema, get(), "peopleinspace.db")

        StarWarsDatabaseWrapper(AppDatabase(driver))
    }
//    single { Android.create() }
}