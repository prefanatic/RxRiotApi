package io.github.prefanatic.rxriotapi.api

import io.github.prefanatic.rxriotapi.API_KEY
import io.github.prefanatic.rxriotapi.RxRiotApi
import io.github.prefanatic.rxriotapi.`object`.MockDiskCache
import org.junit.Test
import rx.Observable

class StaticApiTest {
    private val api = RxRiotApi(API_KEY, cache = MockDiskCache())

    @Test
    fun testChampionQueryAverageTimeTaken() {
        var averageTime = 0L

        for (i in 0..10) {
            val startTime = System.currentTimeMillis()

            api.staticApi.getChampions()
                    .flatMapIterable { it.data.values }
                    .toBlocking()
                    .last { true }

            val taken = System.currentTimeMillis() - startTime

            println("Took $taken milliseconds to complete call $i")

            averageTime += taken
        }

        averageTime /= 11

        println("Average time taken is $averageTime milliseconds.")
    }

    @Test
    fun getChampionById() {
        api.staticApi.getChampionById("1")
                .subscribe { println(it) }
    }

    @Test
    fun getItems() {
        api.staticApi.getItems()
                .flatMapIterable { it.data.values }
                .subscribe { println(it) }
    }

    @Test
    fun getItemById() {
        api.staticApi.getItemById("3089")
                .subscribe { println(it) }
    }

    @Test
    fun getLanguageStrings() {
        api.staticApi.getLanguageStrings()
                .subscribe { println(it) }
    }

    @Test
    fun getMaps() {
        api.staticApi.getMaps()
                .flatMapIterable { it.data.values }
                .subscribe { println(it) }
    }

    @Test
    fun getMasteries() {
        api.staticApi.getMaps()
                .flatMapIterable { it.data.values }
                .subscribe { println(it) }
    }

    @Test
    fun getMasteryById() {
        api.staticApi.getMasteryById("4244")
                .subscribe { println(it) }
    }

    @Test
    fun getRealm() {
        api.staticApi.getRealm()
                .subscribe { println(it) }
    }

    @Test
    fun getRunes() {
        api.staticApi.getRunes()
                .flatMapIterable { it.data.values }
                .subscribe { println(it) }
    }

    @Test fun getRuneById() {
        api.staticApi.getRuneById("5295")
                .subscribe { println(it) }
    }

    @Test fun getSummonerSpells() {
        api.staticApi.getSummonerSpells()
                .flatMapIterable { it.data.values }
                .subscribe { println(it) }
    }

    @Test fun getSummonerSpellById() {
        api.staticApi.getSummonerSpellById("4")
                .subscribe { println(it) }
    }

    @Test fun getVersions() {
        api.staticApi.getVersions()
                .flatMap { Observable.from(it) }
                .subscribe { println(it) }
    }
}
