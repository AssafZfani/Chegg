package homework.chegg.com.chegghomework.di

import homework.chegg.com.chegghomework.data.repository.article.ArticlesRepository
import homework.chegg.com.chegghomework.data.repository.article.ArticlesRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<ArticlesRepository> { ArticlesRepositoryImpl(get()) }
}