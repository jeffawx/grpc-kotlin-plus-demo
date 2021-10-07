package com.airwallex.grpc.demo

import com.airwallex.grpc.annotations.GrpcClient
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(
    "grpc.server.name=greet",
    "grpc.server.port=-1",
    "grpc.client.channels.greet.in-process=true"
)
class GreeterTest {

    @Autowired
    private lateinit var greeter: GreeterClient

    @Test
    fun `test greeting`() = runBlocking {
        val name = "Jeff"
        assertEquals("Hello $name", greeter.sayHello(name))
    }

    @GrpcClient(channel = "greet")
    interface GreeterClient : Greeter
}
