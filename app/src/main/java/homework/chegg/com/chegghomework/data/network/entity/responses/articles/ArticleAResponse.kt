package homework.chegg.com.chegghomework.data.network.entity.responses.articles

import homework.chegg.com.chegghomework.data.interfaces.IArticleResponse
import homework.chegg.com.chegghomework.data.local.Article

data class ArticleAResponse(val stories: List<ArticleA>) : IArticleResponse {

    override fun getArticleList() = stories.map { Article(it.title, it.subtitle, it.imageUrl) }
}

data class ArticleA(val title: String, val subtitle: String, val imageUrl: String)