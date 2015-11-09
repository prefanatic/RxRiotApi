package io.github.prefanatic.rxriotapi.api.stats

data class PlayerStatsSummaryList(val playerStatSummaries: MutableList<PlayerStatsSummary>, val summonerId: Long)
data class PlayerStatsSummary(val aggregatedStats: AggregatedStats, val losses: Int, val modifyDate: Long, val playerStatSummaryType: String, val wins: Int)
data class RankedStats(val champions: MutableList<ChampionStats>, val modifyDate: Long, val summonerId: Long)
data class ChampionStats(val id: Int, val stats: AggregatedStats)
data class AggregatedStats(val averageAssists: Int, val averageChampionsKilled: Int, val averageCombatPlayerScore: Int, val averageNodeCapture: Int, val averageNodeNeutralize: Int,
                           val averageNodeNeutralizeAssist: Int, val averageNumDeaths: Int, val averageObjectivePlayerScore: Int, val averageTeamObjective: Int, val averageTotalPlayerScore: Int,
                           val botGamesPlayed: Int, val killingSpree: Int, val maxAssists: Int, val maxChampionsKilled: Int, val maxLargestCriticalStrike: Int, val maxLargestKillingSpree: Int,
                           val maxNodeCapture: Int, val maxNodeCaptureAssist: Int, val maxNodeNeutralizeAssist: Int, val maxNumDeaths: Int, val maxObjectivePlayerScore: Int, val maxTeamObjective: Int,
                           val maxTimePlayed: Int, val maxTimeSpentLiving: Int, val maxTotalPlayerScore: Int, val mostChampionKillsPerSession: Int, val mostSpellsCast: Int, val normalGamesPlayed: Int,
                           val rankedPremadeGamesPlayed: Int, val rankedSoloGamesPlayed: Int, val totalAssists:Int, val totalChampionKills: Int, val totalDamageDealt: Int, val totalDamageTaken: Int,
                           val totalDeathsPerSession: Int, val totalDoubleKills: Int, val totalFirstBlood: Int, val totalGoldEarned: Int, val totalHeal: Int, val totalMagicDamageDealt: Int,
                           val totalMinionKills: Int, val totalNeutralMinionsKilled: Int, val totalNodeNeutralize: Int, val totalPentaKills: Int, val totalPhysicalDamageDealt: Int,
                           val totalQuadraKills: Int, val totalSessionsLost: Int, val totalSessionsPlayed: Int, val totalSessionsWon: Int, val totalTripleKills: Int, val totalTurretsKilled: Int,
                           val totalUnrealKills: Int)