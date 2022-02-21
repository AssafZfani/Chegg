package homework.chegg.com.chegghomework.data.repository

import homework.chegg.com.chegghomework.data.network.entity.responses.ErrorResponse

sealed class ApiResult<out T> {
    data class Success<out T>(val data: T) : ApiResult<T>()
    object SuccessWithoutResponse : ApiResult<Nothing>()
    data class Error(val error: ErrorResponse) : ApiResult<Nothing>()
}