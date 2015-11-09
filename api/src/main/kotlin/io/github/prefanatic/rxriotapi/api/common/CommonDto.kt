package io.github.prefanatic.rxriotapi.api.common

data class Mastery(val masteryId: Int, val rank: Int)
data class Rune(val rank: Int, val runeId: Int, val count: Int)
data class BannedChampion(val championId: Int, val pickTurn: Int, val teamId: Int)