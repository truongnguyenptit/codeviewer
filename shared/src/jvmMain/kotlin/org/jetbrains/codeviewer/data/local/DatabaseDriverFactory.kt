package org.jetbrains.codeviewer.data.local

import com.squareup.sqldelight.sqlite.driver.JdbcDriver
import com.squareup.sqldelight.sqlite.driver.JdbcSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import org.jetbrains.codeviewer.share.cache.AppDatabase
import java.io.File

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        val databasePath = File(System.getProperty("java.io.tmpdir"), "app.db")
        val driver = JdbcSqliteDriver(url = "jdbc:sqlite:${databasePath.absolutePath}")
        AppDatabase.Schema.create(driver)

        return driver
//        return JdbcDriver("jdbc:sqlite:mydatabase.db").apply { schema.create(this) }
    }
}