package homework.chegg.com.chegghomework.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import homework.chegg.com.chegghomework.R
import homework.chegg.com.chegghomework.data.local.Article
import homework.chegg.com.chegghomework.databinding.ItemListArticleBinding

class ArticlesAdapter : ListAdapter<Article, ArticlesAdapter.ArticleViewHolder>(ArticlesDiff()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        LayoutInflater.from(parent.context)
            .let { ItemListArticleBinding.inflate(it, parent, false) }
            .let { ArticleViewHolder(it) }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ArticleViewHolder(private val binding: ItemListArticleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Article) = with(binding) {
            articleTitleTv.text = item.title
            articleContentTv.text = item.content
            Glide.with(root.context).load(item.pic).error(R.drawable.ic_article)
                .into(articleImageIv)
        }
    }
}