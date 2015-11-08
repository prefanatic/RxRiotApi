package io.github.prefanatic.rxriotapi

import com.google.gson.JsonObject
import com.google.gson.JsonParser
import com.google.gson.stream.JsonReader
import com.squareup.okhttp.*
import java.io.File
import java.net.URL
import java.nio.charset.Charset

abstract class Cache {
    val TYPE = "application/json; charset=UTF-8"

    public fun save(response: Response, staleIn: Int): Response {
        val body = response.body().string()
        val file = urlToFile(response.request().url())

        val container = JsonObject()
        container.addProperty("staleAt", staleIn + System.currentTimeMillis())
        container.addProperty("contents", body)

        file.writeBytes(container.toString().toByteArray())

        return response.newBuilder()
                .body(ResponseBody.create(response.body().contentType(), body))
                .build()
    }

    public fun load(url: URL): Response? {
        val file = urlToFile(url)
        if (!file.exists()) throw NoSuchFileException(file, reason = "Did not check if exists before calling load.")

        val data = file.readText()
        val container = JsonParser().parse(data).asJsonObject
        val staleAt = container.get("staleAt").asLong

        if (System.currentTimeMillis() > staleAt) {
            println("Contents have gone stale.")
            file.delete()
            return null
        } else {
            println("Contents will become stale in ${staleAt - System.currentTimeMillis()} milliseconds.")
        }

        return Response.Builder()
                .request(Request.Builder().url(url).build())
                .protocol(Protocol.HTTP_1_1)
                .code(200)
                .body(ResponseBody.create(MediaType.parse(TYPE), container.get("contents").asString))
                .build()
    }

    public abstract fun getCacheDir(): File

    public fun exists(url: URL): Boolean = urlToFile(url).exists()

    private fun urlToFile(url: URL): File {
        val strUrl = url.path.replace("/", "_").toLowerCase()

        return File(getCacheDir(), strUrl)
    }
}