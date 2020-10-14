package it.alexs.newsapp.extensions

import it.alexs.newsapp.model.ResultWrapper
import retrofit2.HttpException

inline fun <T, R> T.resultWrapperCatching(block: T.() -> R): ResultWrapper<R>{
    return try {
        ResultWrapper.Success(block())
    } catch (throwable: Throwable){
        when(throwable){
            is HttpException -> ResultWrapper.Error(ResultWrapper.GenericError(throwable.code(), throwable.message()))
            else -> ResultWrapper.Error(ResultWrapper.GenericError(500, "Errore imprevisto"))
        }
    }
}