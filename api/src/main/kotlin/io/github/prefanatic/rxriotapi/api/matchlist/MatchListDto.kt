package io.github.prefanatic.rxriotapi.api.matchlist

data class MatchList(val endIndex: Int, val matches: MutableList<MatchReference>, val startIndex: Int, val totalGames: Int)
data class MatchReference(val champion: Int, val lane: String, val matchId: Long, val platformId: String, val queue: String, val region: String, val role: String, val season: String, val timestamp: Long)