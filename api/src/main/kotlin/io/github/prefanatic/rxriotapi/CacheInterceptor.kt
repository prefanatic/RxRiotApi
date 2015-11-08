package io.github.prefanatic.rxriotapi

import com.squareup.okhttp.Interceptor
import com.squareup.okhttp.Response
import java.util.concurrent.TimeUnit

class CacheInterceptor(val api: RxRiotApi): Interceptor {
    override public fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val time = System.currentTimeMillis()
        val staleIn = request.header("RxRiotApiStaleIn")?.toInt() ?: 0


        // Does it exist in the cache?
        if (api.cache?.exists(request.url()) == true) {
            println("Loading from cache in ${System.currentTimeMillis() - time}")
            val cacheResponse = api.cache?.load(request.url())
            if (cacheResponse != null) {
                return cacheResponse
            }
        }

        var response = chain.proceed(request)
        println("Received response in ${System.currentTimeMillis() - time}")

        if (api.cache != null && staleIn > 0)
            response = api.cache?.save(response, staleIn)

        return response
    }
}