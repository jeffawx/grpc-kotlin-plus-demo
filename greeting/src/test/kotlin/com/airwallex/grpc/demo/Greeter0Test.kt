package com.airwallex.grpc.demo

import com.airwallex.grpc.GrpcServer
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(
    "grpc.server.name=greet0",
    "grpc.server.port=-1" // 0 for random port, -1 for in-process server
)
class Greeter0Test {

    @Test
    fun `test greeting`() {
        val channel = GrpcServer.inProcessChannel("greet0")
        val stub = GreeterGrpc.newBlockingStub(channel)

        val name = "Jeff"
        val request = Greeting0.HelloRequest.newBuilder().setName(name).build()
        assertEquals("Hello $name", stub.sayHello(request).message)

        channel.shutdown()
    }
}
