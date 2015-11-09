package io.github.prefanatic.rxriotapi

import org.junit.Test

class FeaturedGameTest {
    val api = RxRiotApi(API_KEY)
    @Test fun featuredGames() {
        api.featuredGameApi.getFeaturedGame()
                .flatMapIterable { it.gameList }
                .subscribe { println(it) }
    }
}