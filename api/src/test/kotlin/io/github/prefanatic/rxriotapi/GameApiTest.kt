package io.github.prefanatic.rxriotapi

import org.junit.Test

class GameApiTest {
    val api = RxRiotApi()
    @Test fun getGames() {
        api.gameApi.getRecentGames("29149754")
                .flatMapIterable { it.games }
                .subscribe { println(it) }
    }
}