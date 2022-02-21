package homework.chegg.com.chegghomework.data.network.service

import homework.chegg.com.chegghomework.Consts
import homework.chegg.com.chegghomework.data.network.entity.responses.articles.ArticleAResponse
import homework.chegg.com.chegghomework.data.network.entity.responses.articles.ArticleBResponse
import homework.chegg.com.chegghomework.data.network.entity.responses.articles.ArticleC
import retrofit2.Response
import retrofit2.http.GET

interface CheggRetrofitService {

    @GET(Consts.DATA_SOURCE_A_URL)
    suspend fun getArticlesA(): Response<ArticleAResponse>

    @GET(Consts.DATA_SOURCE_B_URL)
    suspend fun getArticlesB(): Response<ArticleBResponse>

    @GET(Consts.DATA_SOURCE_C_URL)
    suspend fun getArticlesC(): Response<List<ArticleC>>
}