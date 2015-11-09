package io.github.prefanatic.rxriotapi

import org.junit.Test

class LeagueApiTest {
    val api = RxRiotApi(API_KEY)

    @Test fun challenger() {
        api.leagueApi.getChallenger()
                .subscribe { println(it) }
    }
}