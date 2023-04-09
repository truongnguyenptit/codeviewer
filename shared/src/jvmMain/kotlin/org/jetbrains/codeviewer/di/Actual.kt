//package org.jetbrains.codeviewer.di
//
//import com.squareup.sqldelight.sqlite.driver.JdbcSqliteDriver
//import jdk.nashorn.internal.runtime.regexp.joni.Syntax.Java
//import org.jetbrains.codeviewer.share.cache.AppDatabase
//import org.koin.dsl.module
//
//actual fun platformModule() = module {
//    single {
//        val driver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
//            .also { AppDatabase.Schema.create(it) }
//        StarWarsDatabaseWrapper(AppDatabase(driver))
//    }
////    single { Java.create() }
//}
