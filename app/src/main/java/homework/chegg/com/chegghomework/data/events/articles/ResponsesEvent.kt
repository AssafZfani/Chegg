package homework.chegg.com.chegghomework.data.events.articles

import homework.chegg.com.chegghomework.R
import homework.chegg.com.chegghomework.data.local.Article
import homework.chegg.com.chegghomework.data.network.entity.responses.ErrorResponse

sealed class ResponsesEvent {

    data class SuccessArticles(val articleList: List<Article>) : ResponsesEvent()

    object UncheckedError : ResponsesEvent() {
        fun getMessage() = R.string.error_unchecked
    }

    data class Error(val error: ErrorResponse) : ResponsesEvent()
}