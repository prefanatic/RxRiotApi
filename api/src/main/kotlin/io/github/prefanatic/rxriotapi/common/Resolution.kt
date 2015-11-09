package io.github.prefanatic.rxriotapi.common

import io.github.prefanatic.rxriotapi.Region

fun resolveRegion(i: Int): String {
    with (Region) {
        when (i) {
            BR -> return "br"
            EUNE -> return "eune"
            EUW -> return "euw"
            KR -> return "kr"
            LAN -> return "lan"
            LAS -> return "las"
            NA -> return "na"
            OCE -> return "oce"
            TR -> return "tr"
            RU -> return "ru"
            PBE -> return "pbe"
            else -> return "global" // Never gets hit, but just incase.
        }
    }
}

fun resolvePlatform(i: Int): String {
    with (Region) {
        when (i) {
            BR -> return "br1"
            EUNE -> return "eun1"
            EUW -> return "euw1"
            KR -> return "kr"
            LAN -> return "la1"
            LAS -> return "la2"
            NA -> return "na1"
            OCE -> return "oc1"
            TR -> return "tr1"
            RU -> return "ru"
            PBE -> return "pbe1"
            else -> return "global" // Never gets hit, but just incase.
        }
    }
}