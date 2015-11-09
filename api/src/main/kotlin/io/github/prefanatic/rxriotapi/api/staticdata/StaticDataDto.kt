package io.github.prefanatic.rxriotapi.api.staticdata

import io.github.prefanatic.rxriotapi.api.staticdata.dto.Stats
import io.github.prefanatic.rxriotapi.common.Dto
import java.io.Serializable

data class SummonerSpellList(val data: MutableMap<String, SummonerSpell>, val type: String, val version: String) : Dto, Serializable
data class SummonerSpell(val cooldown: MutableList<Double>, val cooldownBurn: String, val cost: MutableList<Int>, val costBurn: String, val costType: String,
                         val description: String, val effect: MutableList<MutableList<Double>>, val effectBurn: MutableList<String>, val id: Int, val image: Image,
                         val key: String, val leveltip: LevelTip, val maxrank: Int, val modes: MutableList<String>, val name: String, val range: Any, val rangeBurn: String,
                         val resource: String, val sanitizedDescription: String, val sanitizedTooltip: String, val summonerLevel: Int, val tooltip: String, val vars: MutableList<SpellVars>) : Dto, Serializable

data class RuneList(val basic: BasicData, val data: MutableMap<String, Rune>, val type: String, val version: String) : Dto, Serializable

data class BasicData(val colloq: String, val consumeOnFull: Boolean, val consumed: Boolean, val depth: Int, val description: String, val from: MutableList<String>, val gold: Gold,
                     val group: String, val hideFromAll: Boolean, val id: Int, val image: Image, val inStore: Boolean, val into: MutableList<String>, val maps: MutableMap<String, Boolean>,
                     val name: String, val plaintext: String, val requiredChampion: String, val rune: MetaData, val sanitizedDescription: String, val specialRecipe: Int, val stacks: Int,
                     val stats: BasicDataStats, val tags: MutableList<String>) : Dto, Serializable

data class Rune(val colloq: String, val consumeOnFull: Boolean, val consumed: Boolean, val depth: Int, val description: String, val from: MutableList<String>,
                val group: String, val hideFromAll: Boolean, val id: Int, val image: Image, val inStore: Boolean, val into: MutableList<String>, val maps: MutableMap<String, Boolean>,
                val name: String, val plaintext: String, val requiredChampion: String, val rune: MetaData, val sanitizedDescription: String, val specialRecipe: Int,
                val stacks: Int, val stats: BasicDataStats, val tags: MutableList<String>) : Dto, Serializable

data class Realm(val cdn: String, val css: String, val dd: String, val l: String, val lg: String, val n: MutableMap<String, String>, val profileiconmax: Int, val store: String, val v: String) : Dto

data class MasteryList(val data: MutableMap<String, Mastery>, val tree: MasteryTree, val type: String, val version: String) : Dto
data class Mastery(val description: MutableList<String>, val id: Int, val image: Image, val masteryTree: String, val name: String, val prereq: String, val ranks: Int, val sanitizedDescription: MutableList<String>) : Dto, Serializable
data class MasteryTree(val Defense: MutableList<MasteryTreeList>, val Offense: MutableList<MasteryTreeList>, val Utility: MutableList<MasteryTreeList>) : Dto, Serializable
data class MasteryTreeList(val masteryTreeItems: MutableList<MasteryTreeItem>) : Dto, Serializable
data class MasteryTreeItem(val masteryId: Int, val prereq: String) : Dto, Serializable

data class MapData(val data: MutableMap<String, MapDetails>, val type: String, val version: String) : Dto, Serializable
data class MapDetails(val image: Image, val mapId: Long, val mapName: String, val unpurchasableItemList: MutableList<Long>) : Dto, Serializable

data class LanguageStrings(val data: MutableMap<String, String>, val type: String, val version: String) : Dto, Serializable

data class ItemList(val basic: BasicDataStats, val data: MutableMap<String, Item>, val groups: MutableList<Group>, val tree: MutableList<ItemTree>, val type: String, val version: String)
data class Group(val MaxGroupOwnable: String, val key: String) : Dto, Serializable
data class Item(val colloq: String, val consumeOnFull: Boolean, val consumed: Boolean, val depth: Int, val description: String, val effect: MutableMap<String, String>,
                val gold: Gold, val group: String, val hideFromAll: Boolean, val id: Int, val image: Image, val inStore: Boolean, val into: MutableList<String>,
                val maps: MutableMap<String, Boolean>, val name: String, val plaintext: String, val requiredChampion: String, val rune: MetaData, val sanitizedDescription: String,
                val specialRecipe: Int, val stacks: Int, val stats: BasicDataStats, val tags: MutableList<String>) : Dto, Serializable

data class ItemTree(val header: String, val tags: MutableList<String>)
data class BasicDataStats(val FlatArmorMod: Double, val FlatAttackSpeedMod: Double, val FlatBlockMod: Double,
                          val FlatCritChanceMod: Double, val FlatCritDamageMod: Double,
                          val FlatEXPBonus: Double, val FlatEnergyPoolMod: Double,
                          val FlatEnergyRegenMod: Double, val FlatHPPoolMod: Double,
                          val FlatHPRegenMod: Double, val FlatMPPoolMod: Double,
                          val FlatMPRegenMod: Double, val FlatMagicDamageMod: Double,
                          val FlatMovementSpeedMod: Double, val FlatPhysicalDamageMod: Double,
                          val FlatSpellBlockMod: Double, val PercentArmorMod: Double,
                          val PercentAttackSpeedMod: Double, val PercentBlockMod: Double,
                          val PercentCritChanceMod: Double, val PercentCritDamageMod: Double,
                          val PercentDodgeMod: Double, val PercentEXPBonus: Double,
                          val PercentHPPoolMod: Double, val PercentHPRegenMod: Double,
                          val PercentLifeStealMod: Double, val PercentMPPoolMod: Double,
                          val PercentMPRegenMod: Double, val PercentMagicDamageMod: Double,
                          val PercentMovementSpeedMod: Double, val PercentPhysicalDamageMod: Double,
                          val PercentSpellBlockMod: Double, val PercentSpellVampMod: Double,
                          val rFlatArmorModPerLevel: Double, val rFlatArmorPenetrationMod: Double,
                          val rFlatArmorPenetrationModPerLevel: Double, val rFlatCritChanceModPerLevel: Double,
                          val rFlatCritDamageModPerLevel: Double, val rFlatDodgeMod: Double,
                          val rFlatDodgeModPerLevel: Double, val rFlatEnergyModPerLevel: Double,
                          val rFlatEnergyRegenModPerLevel: Double, val rFlatGoldPer10Mod: Double,
                          val rFlatHPModPerLevel: Double, val rFlatHPRegenModPerLevel: Double,
                          val rFlatMPModPerLevel: Double, val rFlatMPRegenModPerLevel: Double,
                          val rFlatMagicDamageModPerLevel: Double, val rFlatMagicPenetrationMod: Double,
                          val rFlatMagicPenetrationModPerLevel: Double, val rFlatMovementSpeedModPerLevel: Double,
                          val rFlatPhysicalDamageModPerLevel: Double, val rFlatSpellBlockModPerLevel: Double,
                          val rFlatTimeDeadMod: Double, val rFlatTimeDeadModPerLevel: Double,
                          val rPercentArmorPenetrationMod: Double, val rPercentArmorPenetrationModPerLevel: Double,
                          val rPercentAttackSpeedModPerLevel: Double, val rPercentCooldownMod: Double,
                          val rPercentCooldownModPerLevel: Double, val rPercentMagicPenetrationMod: Double,
                          val rPercentMagicPenetrationModPerLevel: Double, val rPercentMovementSpeedModPerLevel: Double,
                          val rPercentTimeDeadMod: Double, val rPercentTimeDeadModPerLevel: Double) : Dto, Serializable

data class Gold(val base: Int, val purchasable: Boolean, val sell: Int, val total: Int) : Dto, Serializable
data class MetaData(val isRune: Boolean, val tier: String, val type: String) : Dto, Serializable

data class ChampionList(val data: MutableMap<String, Champion>, val format: String, val keys: MutableMap<String, String>, val type: String, val version: String)
public data class Champion(val allytips: MutableList<String>, val blurb: String, val enemytips: MutableList<String>, val id: Int, val image: Image, val info: Info, val key: String,
                           val lore: String, val name: String, val partype: String, val passive: Passive, val recommended: MutableList<Recommended>, val skins: MutableList<Skin>,
                           val spells: MutableList<ChampionSpell>, val stats: Stats, val tags: MutableList<String>, val title: String) : Dto, Serializable

data class ChampionSpell(val altimages: MutableList<Image>, val cooldown: MutableList<Double>, val cooldownBurn: String, val cost: MutableList<Int>, val costBurn: String,
                         val costType: String, val description: String, val effect: MutableList<MutableList<Double>>, val effectBurn: MutableList<String>, val image: Image,
                         val key: String, val leveltip: LevelTip, val maxrank: Int, val name: String, val range: Any, val rangeBurn: String, val resource: String,
                         val sanitizedDescription: String, val sanitizedTooltip: String, val tooltip: String, val vars: MutableList<SpellVars>) : Dto, Serializable

data class Info(val attack: Int, val defense: Int, val difficulty: Int, val magic: Int) : Dto, Serializable
data class Passive(val description: String, val image: Image, val name: String, val sanitizedDescription: String) : Dto, Serializable
data class Image(val full: String, val group: String, val sprite: String, val h: Int, val w: Int, val x: Int, val y: Int) : Dto, Serializable
data class Recommended(val blocks: MutableList<Block>, val champion: String, val map: String, val mode: String, val priority: Boolean, val title: String, val type: String)
data class Skin(val id: Int, val name: String, val num: Int) : Dto, Serializable

data class LevelTip(val effect: MutableList<String>, val label: MutableList<String>) : Dto, Serializable
data class SpellVars(val coeff: MutableList<Double>, val dyn: String, val key: String, val link: String, val ranksWith: String) : Dto, Serializable
data class Block(val items: MutableList<BlockItem>, val recMath: Boolean, val type: String) : Dto, Serializable
data class BlockItem(val count: Int, val id: Int) : Dto, Serializable