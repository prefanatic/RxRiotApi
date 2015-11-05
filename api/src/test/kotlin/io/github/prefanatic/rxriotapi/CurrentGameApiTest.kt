package io.github.prefanatic.rxriotapi

import org.junit.Test

class CurrentGameApiTest {
    val api = RxRiotApi(API_KEY)

    @Test fun getGameFromSummonerName() {
        api.summonerApi.summonersByName("craxyalpaca")
                .flatMapIterable { it.values }
                .first()
                .doOnNext { println("Found summoner ${it.name} (${it.id})") }
                .flatMap { api.currentGameApi.getGame(it.id.toString()) }
                .subscribe { println(it) }
    }
}