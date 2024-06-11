package com.example.testapp.datasource.config

import shared.data.datasource.config.DelegateConfigSource

/**
 * This class represents a configuration source for application settings.
 * It delegates to an underlining source and provides methods to retrieve various configuration values
 * without keys passed.
 */
class AppConfigSource : DelegateConfigSource(
    // delegate
) {
    fun getHttpTimeout(): Long = getLong("http_timeout") { 30_000 }
    fun getHttpRetryCount(): Int = getInt("http_retry_count") { 3 }
}