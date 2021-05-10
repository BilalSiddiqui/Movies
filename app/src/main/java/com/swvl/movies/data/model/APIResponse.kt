package com.swvl.movies.data.model

sealed class APIResponse<out T> {
    data class Success<out T>(val value: T): APIResponse<T>()
    data class Failure(val message: String?): APIResponse<Nothing>()
}