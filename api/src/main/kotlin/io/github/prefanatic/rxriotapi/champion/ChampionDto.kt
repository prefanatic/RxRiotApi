package io.github.prefanatic.rxriotapi.champion

data class ChampionList(val champions: MutableList<Champion>)
data class Champion(val active: Boolean, val botEnabled: Boolean, val botMmEnabled: Boolean, val freeToPlay: Boolean, val id: Long, val rankedPlayEnabled: Boolean)