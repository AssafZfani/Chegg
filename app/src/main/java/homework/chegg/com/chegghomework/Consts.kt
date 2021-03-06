package homework.chegg.com.chegghomework

object Consts {
    const val BASE_URL = "https://chegg-mobile-promotions.cheggcdn.com/android/homework/"
    const val DATA_SOURCE_A_URL = BASE_URL + "android_homework_datasourceA.json"
    const val DATA_SOURCE_B_URL = BASE_URL + "android_homework_datasourceB.json"
    const val DATA_SOURCE_C_URL = BASE_URL + "android_homework_datasourceC.json"
    const val RETRY_COUNT = 3

    fun getCacheStaleTime(requestSuffix: String): Int = when (requestSuffix) {
        "datasourceA.json" -> 5
        "datasourceB.json" -> 30
        "datasourceC.json" -> 60
        else -> 15
    }
}