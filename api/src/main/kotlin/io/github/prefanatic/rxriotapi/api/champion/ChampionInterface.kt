package io.github.prefanatic.rxriotapi.api.champion

import retrofit.http.GET
import retrofit.http.Path
import retrofit.http.Query
import rx.Observable

interface ChampionInterface {
    @GET("api/lol/{region}/v1.2/champion")
    public fun getChampions(
            @Path("region") region: String,
            @Query("api_key") apiKey: String
    ): Observable<ChampionList>

    @GET("api/lol/{region}/v1.2/champion/{id}")
    public fun getChampionById(
            @Path("region") region: String,
            @Path("id") id: String,
            @Query("api_key") apiKey: String
    ): Observable<Champion>
}