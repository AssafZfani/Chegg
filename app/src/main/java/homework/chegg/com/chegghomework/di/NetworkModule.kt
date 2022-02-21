package homework.chegg.com.chegghomework.di

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import homework.chegg.com.chegghomework.Consts
import homework.chegg.com.chegghomework.data.network.interceptor.CacheInterceptor
import homework.chegg.com.chegghomework.data.network.interceptor.LoggingInterceptor
import homework.chegg.com.chegghomework.data.network.interceptor.NetworkInterceptor
import homework.chegg.com.chegghomework.data.network.interceptor.RetryInterceptor
import homework.chegg.com.chegghomework.data.network.service.CheggRetrofitService
import okhttp3.Cache
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

val networkModule = module {
    single { provideGson() }
    single { provideCache(androidApplication()) }
    single { provideHttpLoggingInterceptor() }
    single { provideNetworkInterceptor() }
    single { provideCacheInterceptor() }
    single { provideRetryInterceptor() }
    single { provideOkHttpClient(get(), get(), get(), get(), get()) }
    single { provideCheggService(get(), get()) }
}

fun provideGson(): Gson =
    GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").setPrettyPrinting().setLenient().create()

fun provideCache(context: Context) = Cache(File(context.cacheDir, "offlineCache"), 10 * 1024 * 1024)

fun provideHttpLoggingInterceptor() = LoggingInterceptor()

fun provideNetworkInterceptor() = NetworkInterceptor()

fun provideCacheInterceptor() = CacheInterceptor()

fun provideRetryInterceptor() = RetryInterceptor()

fun provideOkHttpClient(
    cache: Cache,
    loggingInterceptor: LoggingInterceptor,
    networkInterceptor: NetworkInterceptor,
    cacheInterceptor: CacheInterceptor,
    retryInterceptor: RetryInterceptor,
) = OkHttpClient.Builder().cache(cache)
    .addInterceptor(loggingInterceptor)
    .addNetworkInterceptor(networkInterceptor)
    .addInterceptor(cacheInterceptor)
    .addInterceptor(retryInterceptor).build()

private fun provideCheggService(
    gson: Gson,
    okHttpClient: OkHttpClient
): CheggRetrofitService =
    Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(gson))
        .baseUrl(Consts.BASE_URL)
        .client(okHttpClient)
        .build()
        .create(CheggRetrofitService::class.java)