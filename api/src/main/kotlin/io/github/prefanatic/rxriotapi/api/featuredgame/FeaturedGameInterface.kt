package io.github.prefanatic.rxriotapi.api.featuredgame

import retrofit.http.GET
import retrofit.http.Path
import retrofit.http.Query
import rx.Observable

interface FeaturedGameInterface {
    @GET("observer-mode/rest/featured")
    public fun getFeaturedGames(
            @Query("api_key") apiKey: String
    ): Observable<FeaturedGames>
}