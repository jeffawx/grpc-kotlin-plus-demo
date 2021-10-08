package com.airwallex.grpc.demo

import com.airwallex.grpc.annotations.GrpcClient
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import reactor.core.publisher.Flux

@SpringBootTest(
    "grpc.server.name=greet4",
    "grpc.server.port=-1", // random port
    "grpc.client.channels.greet4.in-process=true"
)
class Greeter4Test {

    @Autowired
    private lateinit var greeter: Greeter4Client

    @Test
    fun `test greeting`() {
        val names = Flux.just("Jeff", "Tony")
        assertEquals(listOf("Hello Jeff", "Hello Tony"), greeter.sayHello(names).collectList().block())
    }

    @GrpcClient(channel = "greet4")
    interface Greeter4Client : Greeter4
}
