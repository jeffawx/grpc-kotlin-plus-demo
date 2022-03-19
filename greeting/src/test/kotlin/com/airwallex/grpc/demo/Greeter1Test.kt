package com.airwallex.grpc.demo

import com.airwallex.grpc.annotations.GrpcClient
import com.github.michaelbull.result.get
import demo.Greeter1Rpc
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.TestPropertySource

@TestPropertySource(
    properties = [
        "grpc.client.channels.greeter1.in-process=true",
        "grpc.client.channels.greeter1.server-name=test",
    ]
)
class Greeter1Test : BaseTest() {

    @Autowired
    @GrpcClient(id = "greeter1")
    private lateinit var greeter1: Greeter1Rpc

    @Test
    fun `test greeting`() = runBlocking {
        val name = "Jeff"
        assertEquals("Hello $name", greeter1.sayHello(name).get())
    }
}
