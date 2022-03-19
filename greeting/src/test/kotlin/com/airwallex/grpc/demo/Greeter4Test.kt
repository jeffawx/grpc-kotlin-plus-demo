package com.airwallex.grpc.demo

import com.airwallex.grpc.annotations.GrpcClient
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.TestPropertySource

@TestPropertySource(
    properties = [
        "grpc.client.channels.greeter4.in-process=true",
        "grpc.client.channels.greeter4.server-name=test",
    ]
)
class Greeter4Test : BaseTest() {

    @Autowired
    @GrpcClient(id = "greeter4")
    private lateinit var greeter4: Greeter4Rpc

    @Test
    fun `test greeting`() = runBlocking {
        val names = flowOf("Jeff", "Tony")
        assertEquals(listOf("Hello Jeff", "Hello Tony"), greeter4.sayHello(names).toList())
    }
}
