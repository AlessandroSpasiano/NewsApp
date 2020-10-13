package it.alexs.newsapp.model

sealed class ResultWrapper<out T: Any> {
    data class Success<out T: Any>(val value: T): ResultWrapper<T>()
    data class Error(val error: GenericError): ResultWrapper<Nothing>()

    data class GenericError(val code: Int, val message: String)
}
