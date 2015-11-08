package io.github.prefanatic.rxriotapi.api.currentgame

data class CurrentGameInfo(val bannedChampions: MutableList<BannedChampion>, val gameId: Long, val gameLength: Long, val gameMode: String, val gameQueueConfigId: Long,
                           val gameStartTime: Long, val gameType: String, val mapId: Long, val observers: Observer, val participants: MutableList<CurrentGameParticipant>,
                           val platformId: String)
data class BannedChampion(val championId: Long, val pickTurn: Int, val teamId: Long)
data class CurrentGameParticipant(val bot: Boolean, val championId: Long, val masteries: MutableList<Mastery>, val profileIconId: Long, val runes: MutableList<Rune>,
                                  val spell1Id: Long, val spell2Id: Long, val summonerId: Long, val summonerName: String, val teamId: Long)
data class Observer(val encryptionKey: String)
data class Mastery(val masteryId: Long, val rank: Int)
data class Rune(val count: Int, val runeId: Long)
