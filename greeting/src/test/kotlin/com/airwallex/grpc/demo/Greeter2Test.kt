package com.airwallex.grpc.demo

import com.airwallex.grpc.annotations.GrpcClient
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(
    "grpc.server.name=greet2",
    "grpc.server.port=-1",
    "grpc.client.channels.greet2.in-process=true"
)
class Greeter2Test {

    @Autowired
    private lateinit var greeter: Greeter2Client

    @Test
    fun `test greeting`() = runBlocking {
        val n = "Jeff"
        assertEquals("Hello $n", greeter.sayHello(helloRequest { name = n }).message)
    }

    @GrpcClient(channel = "greet2")
    interface Greeter2Client : Greeter2
}
