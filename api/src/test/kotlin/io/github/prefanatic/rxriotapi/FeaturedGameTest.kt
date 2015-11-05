package io.github.prefanatic.rxriotapi

import org.junit.Test

class FeaturedGameTest {
    val api = RxRiotApi()
    @Test fun featuredGames() {
        api.featuredGameApi.getFeaturedGame()
                .flatMapIterable { it.gameList }
                .subscribe { println(it) }
    }
}