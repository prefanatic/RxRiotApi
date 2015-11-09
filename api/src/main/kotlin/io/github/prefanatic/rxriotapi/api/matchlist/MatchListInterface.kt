package io.github.prefanatic.rxriotapi.api.matchlist

import retrofit.http.GET
import retrofit.http.Path
import retrofit.http.Query
import rx.Observable

interface MatchListInterface {
    @GET("api/lol/{region}/v2.2/matchlist/by-summoner/{summonerId}")
    fun getMatchList(
            @Path("region") region: String,
            @Path("summonerId") summonerId: Long,
            @Query("api_key") apiKey: String,
            @Query("championIds") championIds: String? = null,
            @Query("rankedQueues") rankedQueues: String? = null,
            @Query("seasons") seasons: String? = null,
            @Query("beginTime") beginTime: Long? = null,
            @Query("endTime") endTime: Long? = null,
            @Query("beginIndex") beginIndex: Int? = null,
            @Query("endIndex") endIndex: Int? = null
    ): Observable<MatchList>
}