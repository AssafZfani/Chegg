package homework.chegg.com.chegghomework.data.network.entity.responses.articles

import com.google.gson.annotations.SerializedName
import homework.chegg.com.chegghomework.data.interfaces.IArticleResponse
import homework.chegg.com.chegghomework.data.local.Article

data class ArticleBResponse(val metadata: MetaData) : IArticleResponse {

    override fun getArticleList() = metadata.innerdata.map {
        Article(it.articlewrapper.header, it.articlewrapper.description, it.picture)
    }
}

data class MetaData(@SerializedName("this") val text: String, val innerdata: List<ArticleB>)

data class ArticleWrapper(val header: String, val description: String)

data class ArticleB(val aticleId: String, val articlewrapper: ArticleWrapper, val picture: String)