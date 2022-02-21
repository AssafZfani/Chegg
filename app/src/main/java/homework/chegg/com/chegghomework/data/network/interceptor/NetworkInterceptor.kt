package homework.chegg.com.chegghomework.data.network.interceptor

import homework.chegg.com.chegghomework.Consts
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response
import java.util.concurrent.TimeUnit

class NetworkInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val cacheControl = request.header("Cache-Control")
        return if (cacheControl == null || cacheControl.contains("no-store") ||
            cacheControl.contains("no-cache") || cacheControl.contains("must-revalidate") ||
            cacheControl.contains("max-stale=0")
        ) {
            val requestSuffix = request.url.pathSegments.last().split("_").last()
            val cc =
                CacheControl.Builder()
                    .maxStale(Consts.getCacheStaleTime(requestSuffix), TimeUnit.MINUTES)
                    .build()
            request = request.newBuilder().cacheControl(cc).build()
            chain.proceed(request)
        } else {
            chain.proceed(request)
        }
    }


}