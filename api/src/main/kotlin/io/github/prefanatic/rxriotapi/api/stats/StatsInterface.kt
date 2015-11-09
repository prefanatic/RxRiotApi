package io.github.prefanatic.rxriotapi.api.stats

import retrofit.http.GET
import retrofit.http.Path
import retrofit.http.Query
import rx.Observable

interface StatsInterface {
    @GET("api/lol/{region}/v1.3/stats/by-summoner/{summonerId}/ranked")
    fun getRankedStats(
            @Path("region") region: String,
            @Path("summonerId") summonerId: Long,
            @Query("api_key") apiKey: String,
            @Query("season") season: String? = null
    ): Observable<RankedStats>

    @GET("api/lol/{region}/v1.3/stats/by-summoner/{summonerId}/summary")
    fun getSummaryStats(
            @Path("region") region: String,
            @Path("summonerId") summonerId: Long,
            @Query("api_key") apiKey: String,
            @Query("season") season: String? = null
    ): Observable<PlayerStatsSummaryList>
}