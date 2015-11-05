package io.github.prefanatic.rxriotapi.game

data class RecentGames(val games: MutableList<Game>, val summonerId: Long)
data class Game(val championId: Int, val createDate: Long, val fellowPlayers: MutableList<Player>, val gameId: Long, val gameMode: String, val gameType: String,
                val invalid: Boolean, val ipEarned: Int, val level: Int, val mapId: Int, val spell1: Int, val spell2: Int, val stats: RawStats, val subType: String,
                val teamId: Int)
data class Player(val championId: Int, val summonerId: Long, val teamId: Int)
data class RawStats(val assists: Int, val barracksKilled: Int, val championsKilled: Int, val combatPlayerScore: Int, val consumablesPurchased: Int, val damageDealtToPlayer: Int,
                    val doubleKills: Int, val firstBlood: Int, val gold: Int, val goldEarned: Int, val goldSpent: Int, val item0: Int, val item1: Int, val item2: Int, val item3: Int,
                    val item4: Int, val item5: Int, val item6: Int, val itemsPurchased: Int, val killingSprees: Int, val largestCriticalStrike: Int, val largestKillingSpree: Int,
                    val largestMultiKill: Int, val legendaryItemsCreated: Int, val level: Int, val magicDamageDealtToPlayer: Int, val magicDamageDealtToChampions: Int, val magicDamageTaken: Int,
                    val minionsDenied: Int, val minionsKilled: Int, val neutralMinionsKilled: Int, val neutralMinionsKilledEnemyJungle: Int, val neutralMinionsKilledYourJungle: Int,
                    val nexusKilled: Boolean, val nodeCapture: Int, val nodeCaptureAssist: Int, val nodeNeutralize: Int, val nodeNeutralizeAssist: Int, val numDeaths: Int,
                    val numItemsBought: Int, val objectivePlayerScore: Int, val pentaKills: Int, val physicalDamageDealtToPlayer: Int, val physicalDamageDealtToChampions: Int,
                    val physicalDamageTaken: Int, val playerPosition: Int, val playerRole: Int, val quadraKills: Int, val sightWardsBought: Int, val spell1Cast: Int, val spell2Cast: Int,
                    val spell3Cast: Int, val spell4Cast: Int, val summonSpell1Cast: Int, val summonSpell2Cast: Int, val superMonsterKilled: Int, val team: Int, val teamObjective: Int,
                    val timePlayed: Int, val totalDamageDealt: Int, val totalDamageDealtToChampions: Int, val totalDamageTaken: Int, val totalHeal: Int, val totalPlayerScore: Int,
                    val totalScoreRank: Int, val totalTimeCrowdControlDealt: Int, val totalUnitsHealed: Int, val tripleKills: Int, val trueDamagDealtToPlayer: Int,
                    val trueDamageDealtToChampions: Int, val trueDamageTaken: Int, val turretsKilled: Int, val unrealKills: Int, val victoryPointsTotal: Int, val visionWardsBought: Int,
                    val wardKilled: Int, val wardPlaced: Int, val win: Boolean)