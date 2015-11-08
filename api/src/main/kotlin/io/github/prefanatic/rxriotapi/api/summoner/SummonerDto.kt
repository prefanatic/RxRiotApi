package io.github.prefanatic.rxriotapi.api.summoner

data class Summoner(val id: Long, val name: String, val profileIconId: Int, val revisionDate: Long, val summonerLevel: Long)

data class MasteryPages(val summonerId: Long, val pages: MutableList<MasteryPage>)
data class MasteryPage(val current: Boolean, val id: Long, val name: String, val masteries: MutableList<Mastery>)
data class Mastery(val id: Int, val rank: Int)

data class RunePages(val summonerId: Long, val pages: MutableList<RunePage>)
data class RunePage(val current: Boolean, val id: Long, val name: String, val slots: MutableList<RuneSlot>)
data class RuneSlot(val runeId: Int, val runeSlotId: Int)