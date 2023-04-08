package org.jetbrains.codeviewer

import de.jensklingenberg.ktorfit.converter.builtin.CallResponseConverter
import de.jensklingenberg.ktorfit.converter.builtin.FlowResponseConverter
import de.jensklingenberg.ktorfit.ktorfit
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import org.jetbrains.codeviewer.domain.models.Person
import org.jetbrains.codeviewer.platform.Platform

//val ktorfit = ktorfit {
//    baseUrl("https://swapi.dev/api/")
//    httpClient(HttpClient {
//        install(ContentNegotiation) {
//            json(Json { isLenient = true; ignoreUnknownKeys = true })
//        }
//    })
//    responseConverter(FlowResponseConverter(), CallResponseConverter())
//}
//
//
//val starWarsApi = ktorfit.create<StarWarsApi>()

//fun loadData() {
//    GlobalScope.launch {
//        val response: Person = starWarsApi.getPersonByIdResponse(3)
//        println("Ktorfit:"+ Platform().platform + ":" + response)
//    }
//}
//
//class Greeting {
//    fun greeting(): String {
//
//        loadData()
//        return "Hello, ${Platform().platform}! Look in the LogCat"
//    }
//
//
//}