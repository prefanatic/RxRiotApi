package io.github.prefanatic.rxriotapi.api.status

import retrofit.http.GET
import retrofit.http.Query
import rx.Observable

interface StatusInterface {
    @GET("shards")
    public fun shards(
            @Query("api_key") apiKey: String
    ): Observable<MutableList<String>>

    @GET("shards/{region}")
    public fun getRegionShards(
            @Query("region") region: String,
            @Query("api_key") apiKey: String
    ): Observable<ShardStatus>
}