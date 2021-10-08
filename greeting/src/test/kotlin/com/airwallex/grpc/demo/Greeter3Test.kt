package com.airwallex.grpc.demo

import com.airwallex.grpc.annotations.GrpcClient
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(
    "grpc.server.name=greet3",
    "grpc.server.port=-1", // random port
    "grpc.client.channels.greet3.in-process=true"
)
class Greeter3Test {

    @Autowired
    private lateinit var greeter: Greeter3Client

    @Test
    fun `test greeting`() {
        val name = "Jeff"
        assertEquals("Hello $name", greeter.sayHello(GreetRequest(name)).block()!!.message)
    }

    @GrpcClient(channel = "greet3")
    interface Greeter3Client : Greeter3
}
