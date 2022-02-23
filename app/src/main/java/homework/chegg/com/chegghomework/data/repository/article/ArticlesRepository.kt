package homework.chegg.com.chegghomework.data.repository.article

import homework.chegg.com.chegghomework.data.events.articles.ArticlesEvent

interface ArticlesRepository {
    suspend fun getArticlesA(): ArticlesEvent
    suspend fun getArticlesB(): ArticlesEvent
    suspend fun getArticlesC(): ArticlesEvent
}
