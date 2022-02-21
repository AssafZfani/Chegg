package homework.chegg.com.chegghomework.data.events.articles

import homework.chegg.com.chegghomework.R
import homework.chegg.com.chegghomework.data.network.entity.responses.ErrorResponse
import homework.chegg.com.chegghomework.data.network.entity.responses.articles.ArticleAResponse
import homework.chegg.com.chegghomework.data.network.entity.responses.articles.ArticleBResponse
import homework.chegg.com.chegghomework.data.network.entity.responses.articles.ArticleC

sealed class ResponsesEvent {

    data class SuccessArticlesA(val articleAResponse: ArticleAResponse) : ResponsesEvent()

    data class SuccessArticlesB(val articleBResponse: ArticleBResponse) : ResponsesEvent()

    data class SuccessArticlesC(val articleCResponse: List<ArticleC>) : ResponsesEvent()

    object UncheckedError : ResponsesEvent() {
        fun getMessage() = R.string.error_unchecked
    }

    data class Error(val error: ErrorResponse) : ResponsesEvent()
}