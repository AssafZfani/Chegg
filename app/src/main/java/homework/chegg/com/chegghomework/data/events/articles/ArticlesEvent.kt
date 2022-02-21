package homework.chegg.com.chegghomework.data.events.articles

import homework.chegg.com.chegghomework.R
import homework.chegg.com.chegghomework.data.network.entity.responses.ErrorResponse
import homework.chegg.com.chegghomework.data.network.entity.responses.articles.ArticleA

sealed class ArticlesEvent {

    object Loading : ArticlesEvent()

    data class SuccessArticles(val articleList: List<ArticleA>) : ArticlesEvent()

    object UncheckedError : ArticlesEvent() {
        fun getMessage() = R.string.error_unchecked
    }

    data class Error(val error: ErrorResponse) : ArticlesEvent()
}