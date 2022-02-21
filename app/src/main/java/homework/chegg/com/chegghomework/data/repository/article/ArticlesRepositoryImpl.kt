package homework.chegg.com.chegghomework.data.repository.article

import homework.chegg.com.chegghomework.data.events.articles.ResponsesEvent
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
            is ApiResult.Success -> ResponsesEvent.SuccessArticlesA(data)
            is ApiResult.SuccessWithoutResponse -> ResponsesEvent.UncheckedError
            is ApiResult.Error -> ResponsesEvent.Error(error)
        }
    }

    override suspend fun getArticlesB() = with(getApiResult {
        cheggRetrofitService.getArticlesB()
    }) {
        when (this) {
            is ApiResult.Success -> ResponsesEvent.SuccessArticlesB(data)
            is ApiResult.SuccessWithoutResponse -> ResponsesEvent.UncheckedError
            is ApiResult.Error -> ResponsesEvent.Error(error)
        }
    }

    override suspend fun getArticlesC() = with(getApiResult {
        cheggRetrofitService.getArticlesC()
    }) {
        when (this) {
            is ApiResult.Success -> ResponsesEvent.SuccessArticlesC(data)
            is ApiResult.SuccessWithoutResponse -> ResponsesEvent.UncheckedError
            is ApiResult.Error -> ResponsesEvent.Error(error)
        }
    }
}
