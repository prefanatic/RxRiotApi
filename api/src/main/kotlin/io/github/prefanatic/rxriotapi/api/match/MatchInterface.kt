package io.github.prefanatic.rxriotapi.api.match

import retrofit.http.GET
import retrofit.http.Path
import retrofit.http.Query
import rx.Observable

interface MatchInterface {
    @GET("api/lol/{region}/v2.2/match/{matchId}")
    fun getMatchById(
            @Path("region") region: String,
            @Path("matchId") matchId: Long,
            @Query("api_key") apiKey: String,
            @Query("includeTimeline") includeTimeline: Boolean = false
    ): Observable<MatchDetail>
}