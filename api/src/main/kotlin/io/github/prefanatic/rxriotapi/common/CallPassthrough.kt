package io.github.prefanatic.rxriotapi.common

fun <T> T.cacheFirst(f: T.() -> T): T {
    return f()
}