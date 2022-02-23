package homework.chegg.com.chegghomework.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import homework.chegg.com.chegghomework.data.events.articles.ResponsesEvent
import homework.chegg.com.chegghomework.data.local.Article
import homework.chegg.com.chegghomework.data.network.entity.responses.ErrorResponse
import homework.chegg.com.chegghomework.data.repository.article.ArticlesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch

class MainViewModel(private val articlesRepository: ArticlesRepository) : ViewModel() {

    val articlesLiveData = MutableLiveData<List<Article>>()
    val errorsLiveData = MutableLiveData<List<ErrorResponse>>()

    fun getArticles() = viewModelScope.launch(Dispatchers.IO) {
        val articleA = async { articlesRepository.getArticlesA() }
        val articleB = async { articlesRepository.getArticlesB() }
        val articleC = async { articlesRepository.getArticlesC() }
        val articleList = mutableListOf<Article>()
        val errorList = mutableListOf<ErrorResponse>()
        awaitAll(articleA, articleB, articleC).forEach {
            when (it) {
                is ResponsesEvent.SuccessArticles -> articleList.addAll(it.articleList)
                is ResponsesEvent.Error -> errorList.add(it.error)
                is ResponsesEvent.UncheckedError -> it.getMessage()
            }
        }
        articlesLiveData.postValue(articleList)
        errorsLiveData.postValue(errorList)
    }
}