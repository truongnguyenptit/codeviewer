package org.jetbrains.codeviewer.domain.usecases


abstract class UseCase<in Params, out Type> where Type : Any {

    abstract suspend fun run(params: Params): Type

    suspend operator fun invoke(params: Params) = run(params)
}