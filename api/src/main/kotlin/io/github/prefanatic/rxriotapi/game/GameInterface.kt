package io.github.prefanatic.rxriotapi.game

import retrofit.http.GET
import retrofit.http.Path
import retrofit.http.Query
import rx.Observable

interface GameInterface {
    @GET("api/lol/{region}/v1.3/game/by-summoner/{summonerId}/recent")
    public fun getGames(
            @Path("region") region: String,
            @Path("summonerId") summonerId: String,
            @Query("api_key") apiKey: String
    ): Observable<RecentGames>
}