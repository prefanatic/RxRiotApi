package io.github.prefanatic.rxriotapi.api.staticdata

import retrofit.http.*
import rx.Observable

interface StaticDataInterface {
    @GET("api/lol/static-data/{region}/v1.2/champion")
    public fun getChampions(
            @Path("region") region: String,
            @Query("api_key") apiKey: String,
            @Query("champData") champData: String = "all"
    ): Observable<ChampionList>

    @Headers("RxRiotApiStaleIn: 10000")
    @GET("api/lol/static-data/{region}/v1.2/champion/{id}")
    public fun getChampionById(
            @Path("region") region: String,
            @Path("id") id: String,
            @Query("api_key") apiKey: String,
            @Query("champData") champData: String = "all"
    ): Observable<Champion>

    @GET("api/lol/static-data/{region}/v1.2/item")
    public fun getItems(
            @Path("region") region: String,
            @Query("api_key") apiKey: String,
            @Query("itemListData") itemListData: String = "all"
    ): Observable<ItemList>

    @GET("api/lol/static-data/{region}/v1.2/item/{id}")
    public fun getItemById(
            @Path("region") region: String,
            @Path("id") id: String,
            @Query("api_key") apiKey: String,
            @Query("itemListData") itemListData: String = "all"
    ): Observable<Item>

    @GET("api/lol/static-data/{region}/v1.2/language-strings")
    public fun getLanguageStrings(
            @Path("region") region: String,
            @Query("api_key") apiKey: String
    ): Observable<LanguageStrings>

    @GET("api/lol/static-data/{region}/v1.2/languages")
    public fun getLanguages(
            @Path("region") region: String,
            @Query("api_key") apiKey: String
    ): Observable<MutableList<String>>

    @GET("api/lol/static-data/{region}/v1.2/map")
    public fun getMaps(
            @Path("region") region: String,
            @Query("api_key") apiKey: String
    ): Observable<MapData>

    @GET("api/lol/static-data/{region}/v1.2/mastery")
    public fun getMasteries(
            @Path("region") region: String,
            @Query("api_key") apiKey: String,
            @Query("masteryListData") masteryListData: String = "all"
    ): Observable<MasteryList>

    @GET("api/lol/static-data/{region}/v1.2/mastery/{id}")
    public fun getMasteryById(
            @Path("region") region: String,
            @Path("id") id: String,
            @Query("api_key") apiKey: String,
            @Query("masteryListData") masteryListData: String = "all"
    ): Observable<Mastery>

    @GET("api/lol/static-data/{region}/v1.2/realm")
    public fun getRealm(
            @Path("region") region: String,
            @Query("api_key") apiKey: String
    ): Observable<Realm>

    @GET("api/lol/static-data/{region}/v1.2/rune")
    public fun getRunes(
            @Path("region") region: String,
            @Query("api_key") apiKey: String,
            @Query("runeListData") runeListData: String = "all"
    ): Observable<RuneList>

    @GET("api/lol/static-data/{region}/v1.2/rune/{id}")
    public fun getRuneById(
            @Path("region") region: String,
            @Path("id") id: String,
            @Query("api_key") apiKey: String,
            @Query("runeListData") runeListData: String = "all"
    ): Observable<Rune>

    @GET("api/lol/static-data/{region}/v1.2/summoner-spell")
    public fun getSummonerSpells(
            @Path("region") region: String,
            @Query("api_key") apiKey: String,
            @Query("spellData") spellData: String = "all"
    ): Observable<SummonerSpellList>

    @GET("api/lol/static-data/{region}/v1.2/summoner-spell/{id}")
    public fun getSummonerSpellById(
            @Path("region") region: String,
            @Path("id") id: String,
            @Query("api_key") apiKey: String,
            @Query("spellData") spellData: String = "all"
    ): Observable<SummonerSpell>

    @GET("api/lol/static-data/{region}/v1.2/versions")
    public fun getVersions(
            @Path("region") region: String,
            @Query("api_key") apiKey: String
    ): Observable<MutableList<String>>
}