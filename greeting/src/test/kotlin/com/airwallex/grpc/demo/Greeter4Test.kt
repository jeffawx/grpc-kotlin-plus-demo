package com.airwallex.grpc.demo

import com.airwallex.grpc.annotations.GrpcClient
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.TestPropertySource
import reactor.core.publisher.Flux

@TestPropertySource(
    properties = [
        "grpc.client.channels.greeter4.in-process=true",
        "grpc.client.channels.greeter4.server-name=test",
    ]
)
class Greeter4Test : BaseTest() {

    @Autowired
    @GrpcClient
    private lateinit var greeter4: Greeter4

    @Test
    fun `test greeting`() {
        val names = Flux.just("Jeff", "Tony")
        assertEquals(listOf("Hello Jeff", "Hello Tony"), greeter4.sayHello(names).collectList().block())
    }
}
