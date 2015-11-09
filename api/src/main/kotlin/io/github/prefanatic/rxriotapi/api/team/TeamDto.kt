package io.github.prefanatic.rxriotapi.api.team

data class Team(val createDate: Long, val fullId: String, val lastGameDate: Long, val lastJoinDate: Long, val lastJoinedRankedTeamQueueDate: Long, val matchHistory: MutableList<MatchHistorySummary>,
                val modifyDate: Long, val name: String, val roster: Roster, val secondLastJoinDate: Long, val status: String, val tag: String, val teamStatDetails: MutableList<TeamStatDetail>,
                val thirdLastJoinDate: Long)
data class MatchHistorySummary(val assists: Int, val date: Long, val deaths: Int, val gameId: Long, val gameMode: String, val invalid: Boolean, val kills: Int,
                               val mapId: Int, val opposingTeamKills: Int, val opposingTeamName: String, val win: Boolean)
data class Roster(val memberList: MutableList<TeamMemberInfo>, val ownerId: Long)
data class TeamStatDetail(val averageGamesPlayed: Int, val losses: Int, val teamStatType: String, val wins: Int)
data class TeamMemberInfo(val inviteDate: Long, val joinDate: Long, val playerId: Long, val status: String)