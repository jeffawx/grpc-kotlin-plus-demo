package com.airwallex.grpc.demo

import com.airwallex.grpc.demo.Greeting2.HelloRequest2
import com.airwallex.grpc.spring.server.AutoGrpcServiceImpl

@AutoGrpcServiceImpl
class Greeter2Impl : Greeter2Rpc {
    override suspend fun sayHello(request: HelloRequest2) =
        helloReply2 {
            message = "Hello ${request.name}"
        }
}
