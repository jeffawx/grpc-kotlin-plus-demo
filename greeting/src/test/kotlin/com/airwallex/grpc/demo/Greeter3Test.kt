package com.airwallex.grpc.demo

import com.airwallex.grpc.annotations.GrpcClient
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.TestPropertySource

@TestPropertySource(
    properties = [
        "grpc.client.channels.greeter3.in-process=true",
        "grpc.client.channels.greeter3.server-name=test",
    ]
)
class Greeter3Test : BaseTest() {

    @Autowired
    @GrpcClient
    private lateinit var greeter3: Greeter3

    @Test
    fun `test greeting`() {
        val name = "Jeff"
        assertEquals("Hello $name", greeter3.sayHello(GreetRequest(name)).block()!!.message)
    }
}
