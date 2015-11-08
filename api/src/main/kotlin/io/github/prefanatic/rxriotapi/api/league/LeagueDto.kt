package io.github.prefanatic.rxriotapi.api.league

data class League(val entries: MutableList<LeagueEntry>, val name: String, val participantId: String, val queue: String, val tier: String)
data class LeagueEntry(val division: String, val isFreshBlood: Boolean, val isHotStreak: Boolean, val isInactive: Boolean, val isVeteran: Boolean,
                       val leaguePoints: Int, val losses: Int, val miniSeries: MiniSeries, val playerOrTeamId: String, val playerOrTeamName: String,
                       val wins: Int)
data class MiniSeries(val losses: Int, val progress: String, val target: Int, val wins: Int)