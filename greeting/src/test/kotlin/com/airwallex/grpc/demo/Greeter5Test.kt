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
        "grpc.client.channels.greeter5.in-process=true",
        "grpc.client.channels.greeter5.server-name=test",
    ]
)
class Greeter5Test : BaseTest() {

    @Autowired
    @GrpcClient
    private lateinit var greeter5: Greeter5Rpc

    @Test
    fun `test greeting`() = runBlocking {
        val names = flowOf(Message("Jeff"), Message("Tony"))
        assertEquals(listOf("Hello Jeff", "Hello Tony"), greeter5.sayHello(names).toList().map { it.text })
    }
}
