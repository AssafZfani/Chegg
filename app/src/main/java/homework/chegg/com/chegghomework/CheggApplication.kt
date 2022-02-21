package homework.chegg.com.chegghomework

import android.annotation.SuppressLint
import android.app.Application
import homework.chegg.com.chegghomework.di.cheggAppModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import java.security.SecureRandom
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import javax.net.ssl.HttpsURLConnection
import javax.net.ssl.SSLContext
import javax.net.ssl.X509TrustManager

class CheggApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        trustEveryone()

        startKoin {
            androidContext(applicationContext)
            modules(cheggAppModules)
        }
    }

    @SuppressLint("BadHostnameVerifier", "CustomX509TrustManager", "TrustAllX509TrustManager")
    fun trustEveryone() {
        try {
            HttpsURLConnection.setDefaultHostnameVerifier { _, _ -> true }
            val context: SSLContext = SSLContext.getInstance("TLS")
            context.init(null, arrayOf<X509TrustManager>(object : X509TrustManager {
                @Throws(CertificateException::class)
                override fun checkClientTrusted(
                    chain: Array<X509Certificate?>?,
                    authType: String?
                ) {
                }

                @Throws(CertificateException::class)
                override fun checkServerTrusted(
                    chain: Array<X509Certificate?>?,
                    authType: String?
                ) {
                }

                override fun getAcceptedIssuers(): Array<X509Certificate?> {
                    return arrayOfNulls(0)
                }
            }), SecureRandom())
            HttpsURLConnection.setDefaultSSLSocketFactory(context.socketFactory)
        } catch (e: Exception) { // should never happen
            e.printStackTrace()
        }
    }
}