package io.github.prefanatic.rxriotapi

import io.github.prefanatic.rxriotapi.champion.ChampionInterface
import io.github.prefanatic.rxriotapi.currentgame.CurrentGameInterface
import io.github.prefanatic.rxriotapi.featuredgame.FeaturedGameInterface
import io.github.prefanatic.rxriotapi.game.GameInterface
import io.github.prefanatic.rxriotapi.league.LeagueInterface
import io.github.prefanatic.rxriotapi.staticdata.StaticDataInterface
import io.github.prefanatic.rxriotapi.status.StatusInterface
import io.github.prefanatic.rxriotapi.summoner.SummonerInterface
import retrofit.GsonConverterFactory
import retrofit.Retrofit
import retrofit.RxJavaCallAdapterFactory

public class RxRiotApi(var apiKey: String = "", var region: Int = Region.NA) {
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

    init {
        retrofit = Retrofit.Builder()
                .baseUrl("https://na.api.pvp.net/")
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

    private fun resolveRegion(): String {
        with (Region) {
            when (region) {
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

    private fun resolvePlatform(): String {
        with (Region) {
            when (region) {
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
        public fun getChampions() = championInterface.getChampions("na", apiKey)
        public fun getChampionById(id: String) = championInterface.getChampionById("na", id, apiKey)
    }

    /* ***************************
    Current Game Api
    ****************************** */
    inner class CurrentGameApi {
        public fun getGame(summonerId: String) = currentGameInterface.getCurrentGame("NA1", summonerId, apiKey)
    }

    inner class FeaturedGameApi {
        public fun getFeaturedGame() = featuredGameInterface.getFeaturedGames(apiKey)
    }

    inner class GameApi {
        public fun getRecentGames(summonerId: String) = gameInterface.getGames("na", summonerId, apiKey)
    }

    inner class LeagueApi {
        public fun getLeaguesBySummonerIds(ids: String) = leagueInterface.leagueBySummoner("na", ids, apiKey)
        public fun getLeagueEntriesBySummonerIds(ids: String) = leagueInterface.leagueEntryBySummoner("na", ids, apiKey)
        public fun getLeaguesByTeamIds(ids: String) = leagueInterface.leagueByTeamId("na", ids, apiKey)
        public fun getLeaguesEntriesByTeamIds(ids: String) = leagueInterface.leagueEntryByTeamId("na", ids, apiKey)
        public fun getChallenger() = leagueInterface.challenger("na", apiKey)
        public fun getMaster() = leagueInterface.master("na", apiKey)
    }

    // Well this isn't using the standard base URL that retrofit is getting.  :'(
    inner class StatusApi {
        //public fun getShards() = statusInterface.shards(apiKey)
        //public fun getShardsByRegion() = statusInterface.getRegionShards("na", apiKey)
    }

    /* ***************************
    Static Data Api
    ****************************** */
    inner class StaticApi {
        public fun getChampions() = staticDataInterface.getChampions("na", apiKey)
        public fun getChampionById(id: String) = staticDataInterface.getChampionById("na", id, apiKey)
        public fun getItems() = staticDataInterface.getItems("na", apiKey)
        public fun getItemById(id: String) = staticDataInterface.getItemById("na", id, apiKey)
        public fun getLanguageStrings() = staticDataInterface.getLanguageStrings("na", apiKey)
        public fun getLanguages() = staticDataInterface.getLanguages("na", apiKey)
        public fun getMaps() = staticDataInterface.getMaps("na", apiKey)
        public fun getMasteries() = staticDataInterface.getMasteries("na", apiKey)
        public fun getMasteryById(id: String) = staticDataInterface.getMasteryById("na", id, apiKey)
        public fun getRealm() = staticDataInterface.getRealm("na", apiKey)
        public fun getRunes() = staticDataInterface.getRunes("na", apiKey)
        public fun getRuneById(id: String) = staticDataInterface.getRuneById("na", id, apiKey)
        public fun getSummonerSpells() = staticDataInterface.getSummonerSpells("na", apiKey)
        public fun getSummonerSpellById(id: String) = staticDataInterface.getSummonerSpellById("na", id, apiKey)
        public fun getVersions() = staticDataInterface.getVersions("na", apiKey)
    }

    /* ***************************
    START --- Summoner Api
    ****************************** */
    inner class SummonerApi {
        public fun summonersByName(names: String) = summonerInterface.byName("na", names, apiKey)
        public fun summonersById(ids: String) = summonerInterface.byIds("na", ids, apiKey)
        public fun getSummonerNamesById(ids: String) = summonerInterface.getNames("na", ids, apiKey)
        public fun masteriesFromSummonerIds(ids: String) = summonerInterface.getMasteries("na", ids, apiKey)
        public fun runesFromSummonerIds(ids: String) = summonerInterface.getRunes("na", ids, apiKey)
    }
}