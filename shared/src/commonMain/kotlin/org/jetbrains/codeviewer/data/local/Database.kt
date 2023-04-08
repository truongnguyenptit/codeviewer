package org.jetbrains.codeviewer.data.local


import io.ktor.http.HttpMethod.Companion.Patch
import org.jetbrains.codeviewer.domain.models.Person
import org.jetbrains.codeviewer.share.cache.AppDatabase

internal class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = AppDatabase(databaseDriverFactory.createDriver())
    private val dbQuery = database.appDatabaseQueries

    internal fun clearDatabase() {
        dbQuery.transaction {
            dbQuery.removeAllPerson()
        }
    }

    internal fun getAllPersons(): List<Person> {
        return dbQuery.selectAllPersonsInfo(::mapPeopleSelecting).executeAsList()
    }

    private fun mapPeopleSelecting(
        name: String?,
        height: String?,
        mass: String?,
        url: String?,
    ): Person {
        return Person(
            name,
            height,
            mass,
            url
        )
    }

    internal fun createPeople(persons: List<Person>) {
        dbQuery.transaction {
            persons.forEach { person ->
                insertPerson(person)
            }
        }
    }

    private fun insertPerson(person: Person) {
        dbQuery.insertPerson(
            person.name,
            person.height,
            person.mass,
            person.url,
        )
    }
}