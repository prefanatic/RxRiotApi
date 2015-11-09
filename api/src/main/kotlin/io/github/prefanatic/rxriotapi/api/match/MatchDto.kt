package io.github.prefanatic.rxriotapi.api.match

import io.github.prefanatic.rxriotapi.api.common.BannedChampion
import io.github.prefanatic.rxriotapi.api.common.Mastery
import io.github.prefanatic.rxriotapi.api.common.Rune

data class MatchDetail(val mapId: Int, val matchCreation: Long, val matchDuration: Long, val matchId: Long, val matchMode: String, val matchType: String,
                       val matchVersion: String, val participantIdentities: MutableList<ParticipantIdentity>, val participants: MutableList<Participant>, val platformId: String,
                       val queueType: String, val region: String, val season: String, val teams: MutableList<Team>, val timeline: Timeline)
data class Participant(val championId: Int, val highestAchievedSeasonTier: String, val masteries: MutableList<Mastery>, val participantId: Int, val runes: MutableList<Rune>,
                       val spell1Id: Int, val spell2Id: Int, val stats: ParticipantStats, val teamId: Int, val timeline: ParticipantTimeline)
data class ParticipantIdentity(val participantId: Int, val player: Player)
data class Team(val bans: MutableList<BannedChampion>, val baronKills: Int, val dominionVictoryScore: Long, val dragonKills: Int, val firstBaron: Boolean, val firstBlood: Boolean,
                val firstdragon: Boolean, val firstInhibitor: Boolean, val firstTower: Boolean, val inhibitorKills: Int, val teamId: Int, val towerKills: Int, val vilemawKills: Int, val winner: Boolean)
data class Timeline(val frameInterval: Long, val frames: MutableList<Frame>)
data class ParticipantStats(val assists: Int, val champLevel: Int, val combatPlayerScore: Int, val deaths: Int, val doubleKills: Int, val firstBloodAssist: Boolean, val firstBloodKill: Boolean,
                            val firstInhibitorAssist: Boolean, val firstInhibitorKill: Boolean, val firstTowerAssist: Boolean, val firstTowerKill: Boolean, val goldEarned: Int, val goldSpent: Int,
                            val inhibitorKills: Int, val item0: Int, val item1: Int, val item2: Int, val item3: Int, val item4: Int, val item5: Int, val item6: Int, val killingSprees: Int,
                            val kills: Int, val largestCriticalStrike: Int, val largestKillingSpree: Int, val largestMultiKill: Int, val magicDamageDealt: Int, val magicDamageDealtToChampions: Int,
                            val magicDamageTaken: Int, val minionsKilled: Int, val neutralMinionsKilled: Int, val neutralMinionsKilledEnemyJungle: Int, val neutralMinionsKilledTeamJungle: Int,
                            val nodeCapture: Int, val nodeCaptureAssist: Int, val nodeNeutralize: Int, val nodeNeutralizeAssist: Int, val objectivePlayerScore: Int, val pentaKills: Int,
                            val physicalDamageDealt: Int, val physicalDamageDealtToChampions: Int, val physicalDamageTaken: Int, val quadraKills: Int, val sightWardsBoughtInGame: Int,
                            val teamObjective: Int, val totalDamageDealt: Int, val totalDamageDealtToChampions: Int, val totalDamageTaken: Int, val totalHeal: Int, val totalPlayerScore: Int,
                            val totalScoreRank: Int, val totalTimeCrowdControlDealt: Int, val totalUnitsHealed: Int, val towerKills: Int, val tripleKills: Int, val trueDamageDealt: Int,
                            val trueDamageDealtToChampions: Int, val trueDamageTaken: Int, val unrealKills: Int, val visionWardsBoughtInGame: Int, val wardsKilled: Int, val wardsPlaced: Int, val winner: Boolean)
data class ParticipantTimeline(val ancientGolemAssistsPerMinCounts: ParticipantTimelineData, val ancientGolemKillsPerMinCounts: ParticipantTimelineData, val assistedLaneDeathsPerMinDeltas: ParticipantTimelineData,
                               val assistedLaneKillsPerMinDeltas: ParticipantTimelineData, val baronAssistsPerMinCounts: ParticipantTimelineData, val baronKillsPerMinCounts: ParticipantTimelineData,
                               val creepsPerMinDeltas: ParticipantFrame, val csDiffPerMinDeltas: ParticipantTimelineData, val damageTakenDiffPerMinDeltas: ParticipantTimelineData, val damageTakenPerMinDeltas: ParticipantTimelineData,
                               val dragonAssistsPerMinCounts: ParticipantTimelineData, val dragonKillsPerMinCounts: ParticipantTimelineData, val elderLizardAssistsPerMinCounts: ParticipantTimelineData, val elderLizardKillsPerMinCounts: ParticipantTimelineData,
                               val goldPerMinDeltas: ParticipantTimelineData, val inhibitorAssistsPerMinCounts: ParticipantTimelineData, val inhibitorKillsPerMinCounts: ParticipantTimelineData, val lane: String, val role: String,
                               val towerAssistsPerMinCounts: ParticipantTimelineData, val towerKillsPerMinCounts: ParticipantTimelineData, val towerKillsPerMinDeltas: ParticipantTimelineData, val vilemawAssistsPerMinCounts: ParticipantTimelineData,
                               val vilemawKillsPerMinCounts: ParticipantTimelineData, val wardsPerMinDeltas: ParticipantTimelineData, val xpDiffPerMinDeltas: ParticipantTimelineData, val xpPerMinDeltas: ParticipantTimelineData)
data class Player(val matchHistoryUri: String, val profileIcon: Int, val summonerId: Long, val summonerName: String)
data class Frame(val events: MutableList<Event>, val participantFrames: MutableMap<String, ParticipantFrame>, val timestamp: Long)
data class ParticipantTimelineData(val tenToTwenty: Double, val thirtyToEnd: Double, val twentyToThirty: Double, val zeroToTen: Double)
data class Event(val ascendedType: String, val assistingParticipantIds: MutableList<Int>, val buildingType: String, val creatorId: Int, val eventType: String,
                 val itemAfter: Int, val itemBefore: Int, val itemId: Int, val killerId: Int, val laneType: String, val levelUpType: String, val monsterType: String,
                 val participantId: Int, val pointCaptured: String, val position: Position, val skillShot: Int, val teamId: Int, val timestamp: Long, val towerType: String,
                 val victimId: Int, val wardType: String)
data class ParticipantFrame(val currentGold: Int, val dominionScore: Int, val jungleMinionsKilled: Int, val level: Int, val minionsKilled: Int, val participantId: Int, val position: Position,
                            val teamScore: Int, val totalGold: Int, val xp: Int)
data class Position(val x: Int, val y: Int)