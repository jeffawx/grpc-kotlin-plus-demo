package com.airwallex.grpc.demo

import com.airwallex.grpc.annotations.GrpcClient
import com.airwallex.grpc.demo.GreeterGrpc.GreeterBlockingStub
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.TestPropertySource

@TestPropertySource(
    properties = [
        "grpc.client.channels.greeter.in-process=true",
        "grpc.client.channels.greeter.server-name=test",
    ]
)
class Greeter0Test : BaseTest() {

    @Autowired
    @GrpcClient
    private lateinit var greeter: GreeterBlockingStub

    @Test
    fun `test greeting`() {
        val name = "Jeff"
        val request = Greeting0.HelloRequest.newBuilder().setName(name).build()
        assertEquals("Hello $name", greeter.sayHello(request).message)
    }
}
