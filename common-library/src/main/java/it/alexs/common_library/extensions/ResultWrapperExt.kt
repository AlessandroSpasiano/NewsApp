package it.alexs.common_library.extensions

import retrofit2.HttpException

inline fun <T, R> T.resultWrapperCatching(block: T.() -> R): it.alexs.common_library.model.ResultWrapper<R> {
    return try {
        it.alexs.common_library.model.ResultWrapper.Success(block())
    } catch (throwable: Throwable){
        when(throwable){
            is HttpException -> it.alexs.common_library.model.ResultWrapper.Error(it.alexs.common_library.model.ResultWrapper.GenericError(throwable.code(), throwable.message()))
            else -> it.alexs.common_library.model.ResultWrapper.Error(it.alexs.common_library.model.ResultWrapper.GenericError(500, "Errore imprevisto"))
        }
    }
}