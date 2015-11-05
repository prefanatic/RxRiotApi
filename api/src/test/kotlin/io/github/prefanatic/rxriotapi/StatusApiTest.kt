package io.github.prefanatic.rxriotapi

import org.junit.Test

class StatusApiTest {
    val api = RxRiotApi()
    @Test fun shards() {
        api.statusApi.getShards()
                .flatMapIterable { it }
                .subscribe { println(it) }
    }

    @Test fun regionShards() {
        api.statusApi.getShardsByRegion()
                .subscribe { println(it) }
    }
}
