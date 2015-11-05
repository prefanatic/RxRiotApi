package io.github.prefanatic.rxriotapi.summoner

import retrofit.http.GET
import retrofit.http.Path
import retrofit.http.Query
import rx.Observable

interface SummonerInterface {
    @GET("api/lol/{region}/v1.4/summoner/by-name/{summonerNames}")
    fun byName(
            @Path("region") region: String,
            @Path("summonerNames") names: String,
            @Query("api_key") apiKey: String
    ): Observable<MutableMap<String, Summoner>>

    @GET("api/lol/{region}/v1.4/summoner/{summonerIds}")
    fun byIds(
            @Path("region") region: String,
            @Path("summonerIds") ids: String,
            @Query("api_key") apiKey: String
    ): Observable<MutableMap<String, Summoner>>

    @GET("api/lol/{region}/v1.4/summoner/{summonerIds}/masteries")
    fun getMasteries(
            @Path("region") region: String,
            @Path("summonerIds") ids: String,
            @Query("api_key") apiKey: String
    ): Observable<MutableMap<String, MasteryPages>>

    @GET("/api/lol/{region}/v1.4/summoner/{summonerIds}/name")
    fun getNames(
            @Path("region") region: String,
            @Path("summonerIds") ids: String,
            @Query("api_key") apiKey: String
    ): Observable<MutableMap<String, String>>

    @GET("api/lol/{region}/v1.4/summoner/{summonerIds}/runes")
    fun getRunes(
            @Path("region") region: String,
            @Path("summonerIds") ids: String,
            @Query("api_key") apiKey: String
    ): Observable<MutableMap<String, RunePages>>

}