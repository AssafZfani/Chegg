package homework.chegg.com.chegghomework.data.interfaces

import homework.chegg.com.chegghomework.data.local.Article

interface IArticleResponse {

    fun getArticleList(): List<Article>
}
