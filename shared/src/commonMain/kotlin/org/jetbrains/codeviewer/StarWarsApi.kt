package org.jetbrains.codeviewer

import de.jensklingenberg.ktorfit.Call
import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Path
import de.jensklingenberg.ktorfit.http.Query
import kotlinx.coroutines.flow.Flow
import org.jetbrains.codeviewer.domain.models.Person

interface StarWarsApi {
    @GET("people/{id}/")
    suspend fun getPersonByIdResponse(@Path("id") peopleId: Int): Flow<Person>

    @GET("people/{id}/")
    fun getPeopleByIdFlowResponse(@Path("id") peopleId: Int, @Query("hello") world: String?): Flow<Person>

    @GET("people/{id}/")
    fun getPeopleByIdCallResponse(@Path("id") peopleId: Int): Call<Person>

    @GET("people/{id}/")
    fun queryTest(@Path("id") peopleId: Int, @Query("hello") world: String?): Call<Person>
}