package io.github.prefanatic.rxriotapi.api.featuredgame

import io.github.prefanatic.rxriotapi.api.common.BannedChampion

data class FeaturedGames(val clientRefreshInterval: Long, val gameList: MutableList<FeaturedGameInfo>)
data class FeaturedGameInfo(val bannedChampions: MutableList<BannedChampion>, val gameId: Long, val gameLength: Long, val gameMode: String, val gameQueueConfigId: Long, val gameStartTime: Long,
                            val mapId: Long, val observers: Observer, val participants: MutableList<Participant>, val platformId: String)
data class Observer(val encryptionKey: String)
data class Participant(val bot: Boolean, val championId: Long, val profileIconId: Long, val spell1Id: Long, val spell2Id: Long, val summonerName: String, val teamId: Long)