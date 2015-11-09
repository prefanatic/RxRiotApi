package io.github.prefanatic.rxriotapi.api.staticdata.dto

import io.github.prefanatic.rxriotapi.common.Dto
import java.io.Serializable

data class Stats(val armor: Double, val armorperlevel: Double, val attackdamage: Double, val attackdamageperlevel: Double, val attackrange: Double, val attackspeedoffset: Double,
                 val attackspeedperlevel: Double, val crit: Double, val critperlevel: Double, val hp: Double, val hpperlevel: Double, val hpregen: Double, val hpregenperlevel: Double,
                 val movespeed: Double, val mp: Double, val mpperlevel: Double, val mpregen: Double, val mpregenperlevel: Double, val spellblock: Double, val spellblockperlevel: Double): Dto, Serializable {

}