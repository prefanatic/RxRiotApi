package io.github.prefanatic.rxriotapi.currentgame

import retrofit.http.GET
import retrofit.http.Path
import retrofit.http.Query
import rx.Observable

interface CurrentGameInterface {
    @GET("observer-mode/rest/consumer/getSpectatorGameInfo/{platformId}/{summonerId}")
    public fun getCurrentGame(
            @Path("platformId") platformId: String,
            @Path("summonerId") summonerId: String,
            @Query("api_key") apiKey: String
    ): Observable<CurrentGameInfo>
}