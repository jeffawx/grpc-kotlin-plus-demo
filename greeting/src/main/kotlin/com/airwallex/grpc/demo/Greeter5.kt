package com.airwallex.grpc.demo

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.springframework.stereotype.Service

@Service
class Greeter5Impl : Greeter5Rpc {
    override fun sayHello(requests: Flow<Message>) =
        requests.map { Message("Hello ${it.text}") }
}

data class Message(val text: String)
