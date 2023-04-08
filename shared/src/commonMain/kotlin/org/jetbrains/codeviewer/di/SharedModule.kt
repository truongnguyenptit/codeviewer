package org.jetbrains.codeviewer.di


import de.jensklingenberg.ktorfit.Ktorfit
import de.jensklingenberg.ktorfit.converter.builtin.CallResponseConverter
import de.jensklingenberg.ktorfit.converter.builtin.FlowResponseConverter
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import org.jetbrains.codeviewer.StarWarsApi
import org.jetbrains.codeviewer.data.source.network.StarWarsNetworkDataSource
import org.jetbrains.codeviewer.data.source.StarWarsRepositoryImpl
import org.jetbrains.codeviewer.domain.repositories.StarWarRepository
import org.jetbrains.codeviewer.domain.usecases.GetPersonByIdUseCase
import org.jetbrains.codeviewer.presentation.LoadPersonPresenter
import org.koin.core.module.Module
import org.koin.dsl.module
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

fun commonModule(enableNetworkLogs: Boolean) = module {
    single {
        Ktorfit.Builder()
            .baseUrl("https://swapi.dev/api/")
            .httpClient(HttpClient {
                install(ContentNegotiation) {
                    json(Json { isLenient = true; ignoreUnknownKeys = true; prettyPrint = true })
                }
                if (enableNetworkLogs) {
                    install(Logging) {
                        level = LogLevel.BODY
                        logger = object : Logger {
                            override fun log(message: String) {
                                Napier.i(tag = "Http Client", message = message)
                            }
                        }
                    }.also {
                        Napier.base(DebugAntilog())
                    }
                }
            })
            .responseConverter(FlowResponseConverter(), CallResponseConverter())
            .build()
    }
    /**
     * Creates a http client for Ktor that is provided to the
     * API client via constructor injection
     */
//    single {
//        HttpClient(engineFactory = CIO) {
//            expectSuccess = true
//            addDefaultResponseValidation()
//
//            defaultRequest {
//                url {
//                    protocol = URLProtocol.HTTPS
//                    host = "https://swapi.dev/api/"
////                    parameters.append("api_key", BuildKonfig.API_KEY)
////                    parameters.append("language", getAppLanguage(settingsPresenter = get()))
//                }
//            }
//
//            if (enableNetworkLogs) {
//                install(Logging) {
//                    level = LogLevel.HEADERS
//                    logger = object : Logger {
//                        override fun log(message: String) {
//                            Napier.i(tag = "Http Client", message = message)
//                        }
//                    }
//                }.also {
//                    Napier.base(DebugAntilog())
//                }
//            }
//
//            install(ContentNegotiation) {
//                json(
//                    Json {
//                        ignoreUnknownKeys = true
//                        isLenient = true
//                    }
//                )
//            }
//        }
//    }
    single<StarWarsApi> { get<Ktorfit>().create() }
    single { StarWarsNetworkDataSource(get()) }
    single<StarWarRepository> { StarWarsRepositoryImpl(get()) }
    single { GetPersonByIdUseCase(get()) }
    single { LoadPersonPresenter() }
}

expect fun platformModule(): Module