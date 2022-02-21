package homework.chegg.com.chegghomework.data.network.entity.responses.articles

import com.google.gson.annotations.SerializedName

data class MetaData(
    @SerializedName("this")
    val text: String,
    val innerdata: List<ArticleB>
)
