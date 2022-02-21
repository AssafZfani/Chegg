package homework.chegg.com.chegghomework.di

import homework.chegg.com.chegghomework.ui.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { MainViewModel(get()) }
}

val cheggAppModules = listOf(
    appModule, networkModule, repositoryModule
)
