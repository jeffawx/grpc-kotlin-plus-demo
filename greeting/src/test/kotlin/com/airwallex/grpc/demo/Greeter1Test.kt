package com.airwallex.grpc.demo

import com.airwallex.grpc.annotations.GrpcClient
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(
    "grpc.server.name=greet1",
    "grpc.server.port=-1", // 0 for random port, -1 for in-process server
    "grpc.client.channels.greet1.in-process=true"
)
class Greeter1Test {

    @Autowired
    private lateinit var greeter: Greeter1Client

    @Test
    fun `test greeting`() = runBlocking {
        val name = "Jeff"
        assertEquals("Hello $name", greeter.sayHello(name))
    }

    @GrpcClient(channel = "greet1")
    interface Greeter1Client : Greeter1
}
