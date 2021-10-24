package com.airwallex.grpc.demo

import com.airwallex.grpc.GrpcServer
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Greeter0Test : BaseTest() {

    @Test
    fun `test greeting`() {
        val channel = GrpcServer.inProcessChannel("test")
        val stub = GreeterGrpc.newBlockingStub(channel)

        val name = "Jeff"
        val request = Greeting0.HelloRequest.newBuilder().setName(name).build()
        assertEquals("Hello $name", stub.sayHello(request).message)

        channel.shutdown()
    }
}
