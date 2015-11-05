package io.github.prefanatic.rxriotapi.status

data class ShardStatus(val hostname: String, val locales: MutableList<String>, val name: String, val region_tag: String, val services: MutableList<Service>, val slug: String)
data class Service(val incidents: MutableList<Incident>, val name: String, val slug: String, val status: String)
data class Incident(val active: Boolean, val created_at: String, val id: Long, val updates: MutableList<Message>)
data class Message(val author: String, val content: String, val created_at: String, val id: Long, val severity: String, val translations: MutableList<Translation>, val updated_at: String)
data class Translation(val content: String, val locale: String, val updated_at: String)
data class Shard(val hostname: String, val locales: MutableList<String>, val name: String, val region_tag: String, val slug: String)