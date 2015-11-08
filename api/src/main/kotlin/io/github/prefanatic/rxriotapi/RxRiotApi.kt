package io.github.prefanatic.rxriotapi

import com.squareup.okhttp.OkHttpClient
import io.github.prefanatic.rxriotapi.api.champion.ChampionInterface
import io.github.prefanatic.rxriotapi.api.currentgame.CurrentGameInterface
import io.github.prefanatic.rxriotapi.api.featuredgame.FeaturedGameInterface
import io.github.prefanatic.rxriotapi.api.game.GameInterface
import io.github.prefanatic.rxriotapi.api.league.LeagueInterface
import io.github.prefanatic.rxriotapi.api.staticdata.StaticDataInterface
import io.github.prefanatic.rxriotapi.api.status.StatusInterface
import io.github.prefanatic.rxriotapi.api.summoner.SummonerInterface
import retrofit.GsonConverterFactory
import retrofit.Retrofit
import retrofit.RxJavaCallAdapterFactory

public class RxRiotApi(var apiKey: String = "", region: Int = Region.NA, var cache: Cache? = null) {
    private val retrofit: Retrofit

    private val summonerInterface: SummonerInterface
    private val staticDataInterface: StaticDataInterface
    private val championInterface: ChampionInterface
    private val currentGameInterface: CurrentGameInterface
    private val featuredGameInterface: FeaturedGameInterface
    private val gameInterface: GameInterface
    private val leagueInterface: LeagueInterface
    private val statusInterface: StatusInterface

    public val championApi by lazy { ChampionApi() }
    public val currentGameApi by lazy { CurrentGameApi() }
    public val featuredGameApi by lazy { FeaturedGameApi() }
    public val gameApi by lazy { GameApi() }
    public val leagueApi by lazy { LeagueApi() }
    public val statusApi by lazy { StatusApi() }
    public val staticApi by lazy { StaticApi() }
    public val summonerApi by lazy { SummonerApi() }

    private var _region: String
    private var _platform: String

    init {
        _region = resolveRegion(region)
        _platform = resolvePlatform(region)

        val okhttp = OkHttpClient()

        with(okhttp) {
            interceptors().add(CacheInterceptor(this@RxRiotApi))
        }

        retrofit = Retrofit.Builder()
                .baseUrl("https://$_region.api.pvp.net/")
                .client(okhttp)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        summonerInterface = retrofit.create(SummonerInterface::class.java)
        staticDataInterface = retrofit.create(StaticDataInterface::class.java)
        championInterface = retrofit.create(ChampionInterface::class.java)
        currentGameInterface = retrofit.create(CurrentGameInterface::class.java)
        featuredGameInterface = retrofit.create(FeaturedGameInterface::class.java)
        gameInterface = retrofit.create(GameInterface::class.java)
        leagueInterface = retrofit.create(LeagueInterface::class.java)
        statusInterface = retrofit.create(StatusInterface::class.java)
    }

    private fun resolveRegion(i: Int): String {
        with (Region) {
            when (i) {
                BR -> return "br"
                EUNE -> return "eune"
                EUW -> return "euw"
                KR -> return "kr"
                LAN -> return "lan"
                LAS -> return "las"
                NA -> return "na"
                OCE -> return "oce"
                TR -> return "tr"
                RU -> return "ru"
                PBE -> return "pbe"
                else -> return "global" // Never gets hit, but just incase.
            }
        }
    }

    private fun resolvePlatform(i: Int): String {
        with (Region) {
            when (i) {
                BR -> return "br1"
                EUNE -> return "eun1"
                EUW -> return "euw1"
                KR -> return "kr"
                LAN -> return "la1"
                LAS -> return "la2"
                NA -> return "na1"
                OCE -> return "oc1"
                TR -> return "tr1"
                RU -> return "ru"
                PBE -> return "pbe1"
                else -> return "global" // Never gets hit, but just incase.
            }
        }
    }

    /* ***************************
    Champion Api
    ****************************** */
    inner class ChampionApi {
        public fun getChampions() = championInterface.getChampions(_region, apiKey)
        public fun getChampionById(id: String) = championInterface.getChampionById(_region, id, apiKey)
    }

    /* ***************************
    Current Game Api
    ****************************** */
    inner class CurrentGameApi {
        public fun getGame(summonerId: String) = currentGameInterface.getCurrentGame(_platform, summonerId, apiKey)
    }

    inner class FeaturedGameApi {
        public fun getFeaturedGame() = featuredGameInterface.getFeaturedGames(apiKey)
    }

    inner class GameApi {
        public fun getRecentGames(summonerId: String) = gameInterface.getGames(_region, summonerId, apiKey)
    }

    inner class LeagueApi {
        public fun getLeaguesBySummonerIds(ids: String) = leagueInterface.leagueBySummoner(_region, ids, apiKey)
        public fun getLeagueEntriesBySummonerIds(ids: String) = leagueInterface.leagueEntryBySummoner(_region, ids, apiKey)
        public fun getLeaguesByTeamIds(ids: String) = leagueInterface.leagueByTeamId(_region, ids, apiKey)
        public fun getLeaguesEntriesByTeamIds(ids: String) = leagueInterface.leagueEntryByTeamId(_region, ids, apiKey)
        public fun getChallenger() = leagueInterface.challenger(_region, apiKey)
        public fun getMaster() = leagueInterface.master(_region, apiKey)
    }

    // Well this isn't using the standard base URL that retrofit is getting.  :'(
    inner class StatusApi {
        //public fun getShards() = statusInterface.shards(apiKey)
        //public fun getShardsByRegion() = statusInterface.getRegionShards(_region, apiKey)
    }

    /* ***************************
    Static Data Api
    ****************************** */
    inner class StaticApi {
        public fun getChampions() = staticDataInterface.getChampions(_region, apiKey)
        public fun getChampionById(id: String) = staticDataInterface.getChampionById(_region, id, apiKey)
        public fun getItems() = staticDataInterface.getItems(_region, apiKey)
        public fun getItemById(id: String) = staticDataInterface.getItemById(_region, id, apiKey)
        public fun getLanguageStrings() = staticDataInterface.getLanguageStrings(_region, apiKey)
        public fun getLanguages() = staticDataInterface.getLanguages(_region, apiKey)
        public fun getMaps() = staticDataInterface.getMaps(_region, apiKey)
        public fun getMasteries() = staticDataInterface.getMasteries(_region, apiKey)
        public fun getMasteryById(id: String) = staticDataInterface.getMasteryById(_region, id, apiKey)
        public fun getRealm() = staticDataInterface.getRealm(_region, apiKey)
        public fun getRunes() = staticDataInterface.getRunes(_region, apiKey)
        public fun getRuneById(id: String) = staticDataInterface.getRuneById(_region, id, apiKey)
        public fun getSummonerSpells() = staticDataInterface.getSummonerSpells(_region, apiKey)
        public fun getSummonerSpellById(id: String) = staticDataInterface.getSummonerSpellById(_region, id, apiKey)
        public fun getVersions() = staticDataInterface.getVersions(_region, apiKey)
    }

    /* ***************************
    START --- Summoner Api
    ****************************** */
    inner class SummonerApi {
        public fun summonersByName(names: String) = summonerInterface.byName(_region, names, apiKey)
        public fun summonersById(ids: String) = summonerInterface.byIds(_region, ids, apiKey)
        public fun getSummonerNamesById(ids: String) = summonerInterface.getNames(_region, ids, apiKey)
        public fun masteriesFromSummonerIds(ids: String) = summonerInterface.getMasteries(_region, ids, apiKey)
        public fun runesFromSummonerIds(ids: String) = summonerInterface.getRunes(_region, ids, apiKey)
    }
}