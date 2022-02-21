package homework.chegg.com.chegghomework.ui

import androidx.recyclerview.widget.DiffUtil
import homework.chegg.com.chegghomework.data.local.Article

class ArticlesDiff : DiffUtil.ItemCallback<Article>() {

    override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem == newItem
    }
}