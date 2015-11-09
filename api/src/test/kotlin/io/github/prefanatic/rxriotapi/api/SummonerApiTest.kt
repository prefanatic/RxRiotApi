package io.github.prefanatic.rxriotapi.api

import io.github.prefanatic.rxriotapi.API_KEY
import io.github.prefanatic.rxriotapi.RxRiotApi
import org.junit.Test

class SummonerApiTest {
    val api = RxRiotApi(API_KEY)

    @Test fun getRunesFromSummoner() {
        api.summonerApi.getByName("prefanatic")
                .flatMapIterable { it.values }
                .flatMap { api.summonerApi.getRunesById(it.id.toString()) }
                .flatMapIterable { it.values }
                .flatMapIterable { it.pages }
                .subscribe( {println(it)}, {println(it)})
    }

    @Test fun getMasteriesFromSummoner() {
        api.summonerApi.getByName("prefanatic")
                .flatMapIterable { it.values }
                .flatMap { api.summonerApi.getMasteriesById(it.id.toString()) }
                .flatMapIterable { it.values }
                .flatMapIterable { it.pages }
                .subscribe { println(it) }
    }
}