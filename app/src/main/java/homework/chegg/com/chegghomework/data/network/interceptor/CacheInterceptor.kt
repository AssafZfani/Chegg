package homework.chegg.com.chegghomework.data.network.interceptor

import homework.chegg.com.chegghomework.Consts
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response
import java.util.concurrent.TimeUnit

class CacheInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        return try {
            chain.proceed(request)
        } catch (e: Exception) {
            val requestSuffix = request.url.pathSegments.last().split("_").last()
            val cacheControl = CacheControl.Builder()
                .onlyIfCached()
                .maxStale(Consts.getCacheStaleTime(requestSuffix), TimeUnit.MINUTES)
                .build()
            val offlineRequest = chain.request().newBuilder().cacheControl(cacheControl).build()
            chain.proceed(offlineRequest)
        }
    }
}