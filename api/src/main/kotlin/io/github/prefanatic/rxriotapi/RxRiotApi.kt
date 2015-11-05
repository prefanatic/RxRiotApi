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

const val API_KEY = "7668418c-0f05-41c9-965c-f3e503d9f42a"

class RxRiotApi {
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

    /* ***************************
    Champion Api
    ****************************** */
    inner class ChampionApi {
        public fun getChampions() = championInterface.getChampions("na", API_KEY)
        public fun getChampionById(id: String) = championInterface.getChampionById("na", id, API_KEY)
    }

    /* ***************************
    Current Game Api
    ****************************** */
    inner class CurrentGameApi {
        public fun getGame(summonerId: String) = currentGameInterface.getCurrentGame("NA1", summonerId, API_KEY)
    }

    inner class FeaturedGameApi {
        public fun getFeaturedGame() = featuredGameInterface.getFeaturedGames(API_KEY)
    }

    inner class GameApi {
        public fun getRecentGames(summonerId: String) = gameInterface.getGames("na", summonerId, API_KEY)
    }

    inner class LeagueApi {
        public fun getLeaguesBySummonerIds(ids: String) = leagueInterface.leagueBySummoner("na", ids, API_KEY)
        public fun getLeagueEntriesBySummonerIds(ids: String) = leagueInterface.leagueEntryBySummoner("na", ids, API_KEY)
        public fun getLeaguesByTeamIds(ids: String) = leagueInterface.leagueByTeamId("na", ids, API_KEY)
        public fun getLeaguesEntriesByTeamIds(ids: String) = leagueInterface.leagueEntryByTeamId("na", ids, API_KEY)
        public fun getChallenger() = leagueInterface.challenger("na", API_KEY)
        public fun getMaster() = leagueInterface.master("na", API_KEY)
    }

    // Well this isn't using the standard base URL that retrofit is getting.  :'(
    inner class StatusApi {
        //public fun getShards() = statusInterface.shards(API_KEY)
        //public fun getShardsByRegion() = statusInterface.getRegionShards("na", API_KEY)
    }

    /* ***************************
    Static Data Api
    ****************************** */
    inner class StaticApi {
        public fun getChampions() = staticDataInterface.getChampions("na", API_KEY)
        public fun getChampionById(id: String) = staticDataInterface.getChampionById("na", id, API_KEY)
        public fun getItems() = staticDataInterface.getItems("na", API_KEY)
        public fun getItemById(id: String) = staticDataInterface.getItemById("na", id, API_KEY)
        public fun getLanguageStrings() = staticDataInterface.getLanguageStrings("na", API_KEY)
        public fun getLanguages() = staticDataInterface.getLanguages("na", API_KEY)
        public fun getMaps() = staticDataInterface.getMaps("na", API_KEY)
        public fun getMasteries() = staticDataInterface.getMasteries("na", API_KEY)
        public fun getMasteryById(id: String) = staticDataInterface.getMasteryById("na", id, API_KEY)
        public fun getRealm() = staticDataInterface.getRealm("na", API_KEY)
        public fun getRunes() = staticDataInterface.getRunes("na", API_KEY)
        public fun getRuneById(id: String) = staticDataInterface.getRuneById("na", id, API_KEY)
        public fun getSummonerSpells() = staticDataInterface.getSummonerSpells("na", API_KEY)
        public fun getSummonerSpellById(id: String) = staticDataInterface.getSummonerSpellById("na", id, API_KEY)
        public fun getVersions() = staticDataInterface.getVersions("na", API_KEY)
    }

    /* ***************************
    START --- Summoner Api
    ****************************** */
    inner class SummonerApi {
        public fun summonersByName(names: String) = summonerInterface.byName("na", names, API_KEY)
        public fun summonersById(ids: String) = summonerInterface.byIds("na", ids, API_KEY)
        public fun getSummonerNamesById(ids: String) = summonerInterface.getNames("na", ids, API_KEY)
        public fun masteriesFromSummonerIds(ids: String) = summonerInterface.getMasteries("na", ids, API_KEY)
        public fun runesFromSummonerIds(ids: String) = summonerInterface.getRunes("na", ids, API_KEY)
    }
}