package io.github.prefanatic.rxriotapi.api.league

import retrofit.http.GET
import retrofit.http.Path
import retrofit.http.Query
import rx.Observable

interface LeagueInterface {
    @GET("api/lol/{region}/v2.5/league/by-summoner/{summonerIds}")
    public fun leagueBySummoner(
            @Path("region") region: String,
            @Path("summonerIds") ids: String,
            @Query("api_key") apiKey: String
    ): Observable<MutableMap<String, League>>

    @GET("api/lol/{region}/v2.5/league/by-summoner/{summonerIds}/entry")
    public fun leagueEntryBySummoner(
            @Path("region") region: String,
            @Path("summonerIds") ids: String,
            @Query("api_key") apiKey: String
    ): Observable<MutableMap<String, League>>

    @GET("api/lol/{region}/v2.5/league/by-team/{teamIds}")
    public fun leagueByTeamId(
            @Path("region") region: String,
            @Path("teamIds") ids: String,
            @Query("api_key") apiKey: String
    ): Observable<MutableMap<String, League>>

    @GET("api/lol/{region}/v2.5/league/by-team/{teamIds}/entry")
    public fun leagueEntryByTeamId(
            @Path("region") region: String,
            @Path("teamIds") ids: String,
            @Query("api_key") apiKey: String
    ): Observable<MutableMap<String, League>>

    @GET("api/lol/{region}/v2.5/league/challenger")
    public fun challenger(
            @Path("region") region: String,
            @Query("api_key") apiKey: String,
            @Query("type") type: String = "RANKED_SOLO_5x5"
    ): Observable<League>

    @GET("api/lol/{region}/v2.5/league/challenger")
    public fun master(
            @Path("region") region: String,
            @Query("api_key") apiKey: String,
            @Query("type") type: String = "RANKED_SOLO_5x5"
    ): Observable<League>
}