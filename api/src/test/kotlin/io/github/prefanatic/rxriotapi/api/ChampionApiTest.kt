package io.github.prefanatic.rxriotapi

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.fail

class ChampionApiTest {
    val api = RxRiotApi(API_KEY)

    @Test fun getChampions() {
        api.championApi.getChampions()
                .flatMapIterable { it.champions }
                .subscribe { println(it) }
    }

    @Test fun getChampionById() {
        api.championApi.getChampionById("1")
                .doOnError { fail(it.message) }
                .subscribe { assertEquals(it.id, 1L) }
    }
}