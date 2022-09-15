package com.gabo.quiz7.other

sealed class ResponseHandler<T : Any> {
    data class Success<T : Any>(val data: T?) : ResponseHandler<T>()
    data class Error<T : Any>(val errorMsg: String?) : ResponseHandler<T>()
}