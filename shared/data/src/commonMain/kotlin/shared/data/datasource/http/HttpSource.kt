package shared.data.datasource.http

import shared.data.datasource.DataSource
import io.ktor.client.HttpClient
import io.ktor.client.network.sockets.ConnectTimeoutException
import io.ktor.client.network.sockets.SocketTimeoutException
import io.ktor.client.plugins.BrowserUserAgent
import io.ktor.client.plugins.HttpRedirect
import io.ktor.client.plugins.HttpRequestRetry
import io.ktor.client.plugins.HttpRequestTimeoutException
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.websocket.WebSockets
import io.ktor.client.request.headers
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

/**
 * A data source implementation that utilizes OkHttp as the underlying HTTP client.
 *
 * @param retries The number of retries to attempt in case of network errors.
 * @param timeout The timeout value for network operations, in milliseconds.
 * @param retryInterval The interval between retry attempts, in milliseconds.
 */
class HttpSource(
    private val retries: Int = 0,
    private val timeout: Long = 15_000L,
    private val retryInterval: Long = 3_000L
) : DataSource {

    /** https://ktor.io/docs/client-create-multiplatform-application.html */
    val ktor by lazy {
        HttpClient {
            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                        useAlternativeNames = false
                    }
                )
            }
            install(WebSockets)
            install(HttpRedirect)
            install(HttpTimeout) {
                requestTimeoutMillis = timeout
                connectTimeoutMillis = timeout
                socketTimeoutMillis = timeout
            }
            if (retries > 0) {
                install(HttpRequestRetry) {
                    retryOnServerErrors(retries)
                    retryOnException(retries, true)
                }
            }
            BrowserUserAgent()
            defaultRequest {
                headers {
                    contentType(ContentType.Application.Json)
                }
            }
        }
    }

}

fun Throwable.isHttpTimeoutException(): Boolean {
    val exception = this
    return exception is HttpRequestTimeoutException ||
            exception is ConnectTimeoutException ||
            exception is SocketTimeoutException
}