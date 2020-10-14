package it.alexs.newsapp.model

sealed class ResultWrapper<out T> {
    data class Success<out T>(val value: T): ResultWrapper<T>()
    data class Error(val error: GenericError): ResultWrapper<Nothing>()

    data class GenericError(val code: Int, val message: String)
}
