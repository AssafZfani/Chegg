package homework.chegg.com.chegghomework.utils

import homework.chegg.com.chegghomework.R
import homework.chegg.com.chegghomework.data.network.entity.responses.ErrorResponse
import homework.chegg.com.chegghomework.data.repository.ApiResult

object ErrorUtils {

    fun getInternetError() = ErrorResponse(
        internetError = true,
        title = R.string.error_no_internet_title,
        message = R.string.error_no_internet_message,
        button = R.string.error_no_internet_button
    ).let { ApiResult.Error(it) }

    fun getUnAuthorisedError() =
        ErrorResponse(
            sessionExpired = true,
            title = R.string.error_auth_title,
            message = R.string.error_auth_message,
            button = R.string.error_auth_button
        ).let { ApiResult.Error(it) }

    fun getDefaultError() = ErrorResponse().let { ApiResult.Error(it) }
}