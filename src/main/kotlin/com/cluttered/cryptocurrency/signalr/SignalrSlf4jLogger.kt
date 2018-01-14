package com.cluttered.cryptocurrency.signalr

import donky.microsoft.aspnet.signalr.client.LogLevel
import donky.microsoft.aspnet.signalr.client.LogLevel.*
import donky.microsoft.aspnet.signalr.client.Logger
import org.slf4j.LoggerFactory

object SignalrSlf4jLogger : Logger {

    private val LOG = LoggerFactory.getLogger("Signalr")

    override fun log(message: String, level: LogLevel) {
        when (level) {
            Critical -> LOG.error(message)
            Information -> LOG.info(message)
            Verbose -> LOG.debug(message)
        }
    }
}