package io.github.prefanatic.rxriotapi

import com.squareup.okhttp.OkHttpClient
import io.github.prefanatic.rxriotapi.api.champion.ChampionInterface
import io.github.prefanatic.rxriotapi.api.currentgame.CurrentGameInterface
import io.github.prefanatic.rxriotapi.api.featuredgame.FeaturedGameInterface
import io.github.prefanatic.rxriotapi.api.game.GameInterface
import io.github.prefanatic.rxriotapi.api.league.LeagueInterface
import io.github.prefanatic.rxriotapi.api.match.MatchInterface
import io.github.prefanatic.rxriotapi.api.matchlist.MatchListInterface
import io.github.prefanatic.rxriotapi.api.staticdata.StaticDataInterface
import io.github.prefanatic.rxriotapi.api.stats.StatsInterface
import io.github.prefanatic.rxriotapi.api.status.StatusInterface
import io.github.prefanatic.rxriotapi.api.summoner.SummonerInterface
import io.github.prefanatic.rxriotapi.api.team.TeamInterface
import io.github.prefanatic.rxriotapi.common.cache.Cache
import io.github.prefanatic.rxriotapi.common.resolvePlatform
import io.github.prefanatic.rxriotapi.common.resolveRegion
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
    private val matchInterface: MatchInterface
    private val matchListInterface: MatchListInterface
    private val statsInterface: StatsInterface
    private val teamInterface: TeamInterface

    public val championApi = ChampionApi()
    public val currentGameApi by lazy { CurrentGameApi() }
    public val featuredGameApi by lazy { FeaturedGameApi() }
    public val gameApi by lazy { GameApi() }
    public val leagueApi by lazy { LeagueApi() }
    public val statusApi by lazy { StatusApi() }
    public val matchApi by lazy { MatchApi() }
    public val matchListApi by lazy { MatchListApi() }
    public val statsApi by lazy { StatsApi() }
    public val teamApi by lazy { TeamApi() }
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
        matchInterface = retrofit.create(MatchInterface::class.java)
        matchListInterface = retrofit.create(MatchListInterface::class.java)
        statsInterface = retrofit.create(StatsInterface::class.java)
        teamInterface = retrofit.create(TeamInterface::class.java)
    }

    /* ***************************
    Champion Api
    ****************************** */
    inner class ChampionApi internal constructor() {
        public fun getChampions() = championInterface.getChampions(_region, apiKey)
        public fun getChampionById(id: String) = championInterface.getChampionById(_region, id, apiKey)
    }

    /* ***************************
    Current Game Api
    ****************************** */
    inner class CurrentGameApi internal constructor() {
        public fun getGame(summonerId: String) = currentGameInterface.getCurrentGame(_platform, summonerId, apiKey)
    }

    inner class FeaturedGameApi internal constructor() {
        public fun getFeaturedGame() = featuredGameInterface.getFeaturedGames(apiKey)
    }

    inner class GameApi internal constructor() {
        public fun getRecentGames(summonerId: String) = gameInterface.getGames(_region, summonerId, apiKey)
    }

    inner class LeagueApi internal constructor() {
        public fun getLeaguesBySummonerIds(ids: String) = leagueInterface.leagueBySummoner(_region, ids, apiKey)
        public fun getLeagueEntriesBySummonerIds(ids: String) = leagueInterface.leagueEntryBySummoner(_region, ids, apiKey)
        public fun getLeaguesByTeamIds(ids: String) = leagueInterface.leagueByTeamId(_region, ids, apiKey)
        public fun getLeaguesEntriesByTeamIds(ids: String) = leagueInterface.leagueEntryByTeamId(_region, ids, apiKey)
        public fun getChallenger() = leagueInterface.challenger(_region, apiKey)
        public fun getMaster() = leagueInterface.master(_region, apiKey)
    }

    // Well this isn't using the standard base URL that retrofit is getting.  :'(
    inner class StatusApi internal constructor() {
        //public fun getShards() = statusInterface.shards(apiKey)
        //public fun getShardsByRegion() = statusInterface.getRegionShards(_region, apiKey)
    }

    inner class MatchApi internal constructor() {
        public fun getMatchById(matchId: Long) = matchInterface.getMatchById(_region, matchId, apiKey)
        public fun getMatchByIdWithTimeline(matchId: Long) = matchInterface.getMatchById(_region, matchId, apiKey, true)
    }

    inner class MatchListApi internal constructor() {
        public fun getMatchList(summonerId: Long) = matchListInterface.getMatchList(_region, summonerId, apiKey)
        // TODO: We probably should use a builder pattern for getMatchList - has too many filter options!
    }

    inner class StatsApi internal constructor() {
        public fun getRankedStats(summonerId: Long) = statsInterface.getRankedStats(_region, summonerId, apiKey)
        public fun getSummaryStats(summonerId: Long) = statsInterface.getSummaryStats(_region, summonerId, apiKey)
    }

    inner class TeamApi internal constructor() {
        public fun getTeamsBySummonerIds(summonerIds: String) = teamInterface.getTeamBySummonerId(_region, summonerIds, apiKey)
        public fun getTeamsById(teamIds: String) = teamInterface.getTeamById(_region, teamIds, apiKey)
    }

    /* ***************************
    Static Data Api
    ****************************** */
    inner class StaticApi internal constructor() {
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
    inner class SummonerApi internal constructor() {
        public fun getByName(names: String) = summonerInterface.byName(_region, names, apiKey)
        public fun getById(ids: String) = summonerInterface.byIds(_region, ids, apiKey)
        public fun getNamesById(ids: String) = summonerInterface.getNames(_region, ids, apiKey)
        public fun getMasteriesById(ids: String) = summonerInterface.getMasteries(_region, ids, apiKey)
        public fun getRunesById(ids: String) = summonerInterface.getRunes(_region, ids, apiKey)
    }
}