package com.airwallex.grpc.demo

import com.airwallex.grpc.annotations.GrpcClient
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.TestPropertySource

@TestPropertySource(
    properties = [
        "grpc.client.channels.greeter2.in-process=true",
        "grpc.client.channels.greeter2.server-name=test",
    ]
)
class Greeter2Test : BaseTest() {

    @Autowired
    @GrpcClient
    private lateinit var greeter2: Greeter2

    @Test
    fun `test greeting`() = runBlocking {
        val n = "Jeff"
        assertEquals("Hello $n", greeter2.sayHello(helloRequest2 { name = n }).message)
    }
}
