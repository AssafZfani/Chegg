package homework.chegg.com.chegghomework.data.network.entity.responses

import android.os.Parcelable
import androidx.annotation.StringRes
import homework.chegg.com.chegghomework.R
import kotlinx.parcelize.Parcelize

@Parcelize
data class ErrorResponse(
    val internetError: Boolean = false,
    val sessionExpired: Boolean = false,
    @StringRes val title: Int = R.string.error_default_title,
    @StringRes val message: Int = R.string.error_default_message,
    @StringRes val button: Int = R.string.error_default_button
) : Parcelable