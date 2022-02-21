package homework.chegg.com.chegghomework.data.repository.article

import homework.chegg.com.chegghomework.data.events.articles.ResponsesEvent

interface ArticlesRepository {
    suspend fun getArticlesA(): ResponsesEvent
    suspend fun getArticlesB(): ResponsesEvent
    suspend fun getArticlesC(): ResponsesEvent
}
