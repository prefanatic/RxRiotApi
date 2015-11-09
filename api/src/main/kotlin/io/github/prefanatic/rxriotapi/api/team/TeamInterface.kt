package io.github.prefanatic.rxriotapi.api.team

import retrofit.http.GET
import retrofit.http.Path
import retrofit.http.Query
import rx.Observable

interface TeamInterface {
    @GET("api/lol/{region}/v2.4/team/by-summoner/{summonerIds}")
    fun getTeamBySummonerId(
            @Path("region") region: String,
            @Path("summonerIds") summonerIds: String,
            @Query("api_key") apiKey: String
    ): Observable<MutableMap<String, MutableList<Team>>>

    @GET("api/lol/{region}/v2.4/team/{teamIds}")
    fun getTeamById(
            @Path("region") region: String,
            @Path("teamIds") teamIds: String,
            @Query("api_key") apiKey: String
    ): Observable<MutableMap<String, Team>>
}