package io.github.prefanatic.rxriotapi.common.cache

import com.squareup.okhttp.Response
import java.net.URL

interface Cache {
    fun save(response: Response, staleIn: Int): Response
    fun load(url: URL): Response? // Result can be null if it is stale!
    fun exists(url: URL): Boolean
}