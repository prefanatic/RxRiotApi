package io.github.prefanatic.rxriotapi.match

data class RawStats(val assists: Int, val championsKilled: Int, val combatPlayerScore: Int, val deaths: Int, val doubleKills: Int, val firstBlood: Int, val gold: Int, val goldEarned: Int, val goldSpent: Int, val item0: Int, val item1: Int, val item2: Int, val item3: Int,
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