package com.cluttered.cryptocurrency.services

import com.cluttered.cryptocurrency.signalr.SignalrSlf4jLogger
import donky.microsoft.aspnet.signalr.client.hubs.HubConnection
import org.slf4j.LoggerFactory

object SocketBittrexService {

    private val LOG = LoggerFactory.getLogger(SocketBittrexService::class.java)

    private val hubConnection = HubConnection(
            "https://socket.bittrex.com",
            null,
            true,
            SignalrSlf4jLogger)
    private val hubProxy = hubConnection.createHubProxy("CoreHub")

    fun start(runnable: Runnable) {
        hubConnection.error { error ->
            println("socket error: " + error)
        }

        hubConnection.connected(runnable)
        hubConnection.start()
    }
}