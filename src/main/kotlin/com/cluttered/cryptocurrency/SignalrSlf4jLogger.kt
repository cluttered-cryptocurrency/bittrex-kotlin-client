package com.cluttered.cryptocurrency

import donky.microsoft.aspnet.signalr.client.LogLevel
import donky.microsoft.aspnet.signalr.client.Logger
import org.slf4j.LoggerFactory

class SignalrSlf4jLogger : Logger {

    companion object {
        private val LOG: org.slf4j.Logger = LoggerFactory.getLogger("donkey.mircrosoft.aspnet.signalr")
    }

    override fun log(message: String, level: LogLevel) {
        when (level) {
            LogLevel.Critical -> LOG.error(message)
            LogLevel.Information -> LOG.info(message)
            LogLevel.Verbose -> LOG.debug(message)
        }
    }
}