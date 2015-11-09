package io.github.prefanatic.rxriotapi.api.staticdata

import retrofit.http.*
import rx.Observable

/**
 * StaticDataInterface
 * Holds Retrofit control logic for RiotAPI Static-Data v1.2
 * Each API call caches by default for one full day.
 * Return values are Observables of the standard DTO object.
 */
interface StaticDataInterface {
    @Headers("RxRiotApiStaleIn: 86400000")
    @GET("api/lol/static-data/{region}/v1.2/champion")
    public fun getChampions(
            @Path("region") region: String,
            @Query("api_key") apiKey: String,
            @Query("champData") champData: String = "all"
    ): Observable<ChampionList>

    @Headers("RxRiotApiStaleIn: 86400000")
    @GET("api/lol/static-data/{region}/v1.2/champion/{id}")
    public fun getChampionById(
            @Path("region") region: String,
            @Path("id") id: String,
            @Query("api_key") apiKey: String,
            @Query("champData") champData: String = "all"
    ): Observable<Champion>

    @Headers("RxRiotApiStaleIn: 86400000")
    @GET("api/lol/static-data/{region}/v1.2/item")
    public fun getItems(
            @Path("region") region: String,
            @Query("api_key") apiKey: String,
            @Query("itemListData") itemListData: String = "all"
    ): Observable<ItemList>

    @Headers("RxRiotApiStaleIn: 86400000")
    @GET("api/lol/static-data/{region}/v1.2/item/{id}")
    public fun getItemById(
            @Path("region") region: String,
            @Path("id") id: String,
            @Query("api_key") apiKey: String,
            @Query("itemListData") itemListData: String = "all"
    ): Observable<Item>

    @Headers("RxRiotApiStaleIn: 86400000")
    @GET("api/lol/static-data/{region}/v1.2/language-strings")
    public fun getLanguageStrings(
            @Path("region") region: String,
            @Query("api_key") apiKey: String
    ): Observable<LanguageStrings>

    @Headers("RxRiotApiStaleIn: 86400000")
    @GET("api/lol/static-data/{region}/v1.2/languages")
    public fun getLanguages(
            @Path("region") region: String,
            @Query("api_key") apiKey: String
    ): Observable<MutableList<String>>

    @Headers("RxRiotApiStaleIn: 86400000")
    @GET("api/lol/static-data/{region}/v1.2/map")
    public fun getMaps(
            @Path("region") region: String,
            @Query("api_key") apiKey: String
    ): Observable<MapData>

    @Headers("RxRiotApiStaleIn: 86400000")
    @GET("api/lol/static-data/{region}/v1.2/mastery")
    public fun getMasteries(
            @Path("region") region: String,
            @Query("api_key") apiKey: String,
            @Query("masteryListData") masteryListData: String = "all"
    ): Observable<MasteryList>

    @Headers("RxRiotApiStaleIn: 86400000")
    @GET("api/lol/static-data/{region}/v1.2/mastery/{id}")
    public fun getMasteryById(
            @Path("region") region: String,
            @Path("id") id: String,
            @Query("api_key") apiKey: String,
            @Query("masteryListData") masteryListData: String = "all"
    ): Observable<Mastery>

    @Headers("RxRiotApiStaleIn: 86400000")
    @GET("api/lol/static-data/{region}/v1.2/realm")
    public fun getRealm(
            @Path("region") region: String,
            @Query("api_key") apiKey: String
    ): Observable<Realm>

    @Headers("RxRiotApiStaleIn: 86400000")
    @GET("api/lol/static-data/{region}/v1.2/rune")
    public fun getRunes(
            @Path("region") region: String,
            @Query("api_key") apiKey: String,
            @Query("runeListData") runeListData: String = "all"
    ): Observable<RuneList>

    @Headers("RxRiotApiStaleIn: 86400000")
    @GET("api/lol/static-data/{region}/v1.2/rune/{id}")
    public fun getRuneById(
            @Path("region") region: String,
            @Path("id") id: String,
            @Query("api_key") apiKey: String,
            @Query("runeListData") runeListData: String = "all"
    ): Observable<Rune>

    @Headers("RxRiotApiStaleIn: 86400000")
    @GET("api/lol/static-data/{region}/v1.2/summoner-spell")
    public fun getSummonerSpells(
            @Path("region") region: String,
            @Query("api_key") apiKey: String,
            @Query("spellData") spellData: String = "all"
    ): Observable<SummonerSpellList>

    @Headers("RxRiotApiStaleIn: 86400000")
    @GET("api/lol/static-data/{region}/v1.2/summoner-spell/{id}")
    public fun getSummonerSpellById(
            @Path("region") region: String,
            @Path("id") id: String,
            @Query("api_key") apiKey: String,
            @Query("spellData") spellData: String = "all"
    ): Observable<SummonerSpell>

    @Headers("RxRiotApiStaleIn: 86400000")
    @GET("api/lol/static-data/{region}/v1.2/versions")
    public fun getVersions(
            @Path("region") region: String,
            @Query("api_key") apiKey: String
    ): Observable<MutableList<String>>
}