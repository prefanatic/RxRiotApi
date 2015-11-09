package io.github.prefanatic.rxriotapi.common.cache

import com.squareup.okhttp.Response
import java.net.URL

class MemoryCacheImpl : Cache {
    override fun save(response: Response, staleIn: Int): Response {
        throw UnsupportedOperationException()
    }

    override fun load(url: URL): Response? {
        throw UnsupportedOperationException()
    }

    override fun exists(url: URL): Boolean {
        throw UnsupportedOperationException()
    }
}