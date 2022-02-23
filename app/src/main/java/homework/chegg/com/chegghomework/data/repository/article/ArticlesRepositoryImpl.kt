package homework.chegg.com.chegghomework.data.repository.article

import homework.chegg.com.chegghomework.data.events.articles.ArticlesEvent
import homework.chegg.com.chegghomework.data.local.Article
import homework.chegg.com.chegghomework.data.network.service.CheggRetrofitService
import homework.chegg.com.chegghomework.data.repository.ApiResult
import homework.chegg.com.chegghomework.data.repository.BaseRepository

class ArticlesRepositoryImpl(
    private var cheggRetrofitService: CheggRetrofitService,
) : BaseRepository(), ArticlesRepository {

    override suspend fun getArticlesA() = with(getApiResult {
        cheggRetrofitService.getArticlesA()
    }) {
        when (this) {
            is ApiResult.Success -> ArticlesEvent.SuccessArticles(data.getArticleList())
            is ApiResult.SuccessWithoutResponse -> ArticlesEvent.UncheckedError
            is ApiResult.Error -> ArticlesEvent.Error(error)
        }
    }

    override suspend fun getArticlesB() = with(getApiResult {
        cheggRetrofitService.getArticlesB()
    }) {
        when (this) {
            is ApiResult.Success -> ArticlesEvent.SuccessArticles(data.getArticleList())
            is ApiResult.SuccessWithoutResponse -> ArticlesEvent.UncheckedError
            is ApiResult.Error -> ArticlesEvent.Error(error)
        }
    }

    override suspend fun getArticlesC() = with(getApiResult {
        cheggRetrofitService.getArticlesC()
    }) {
        when (this) {
            is ApiResult.Success -> ArticlesEvent.SuccessArticles(data.map {
                Article(it.topLine, it.subLine1 + it.subline2, it.image)
            })
            is ApiResult.SuccessWithoutResponse -> ArticlesEvent.UncheckedError
            is ApiResult.Error -> ArticlesEvent.Error(error)
        }
    }
}
