package io.github.prefanatic.rxriotapi

import java.io.File

class MockCache: Cache() {
    override public fun getCacheDir() = File("cache")
}