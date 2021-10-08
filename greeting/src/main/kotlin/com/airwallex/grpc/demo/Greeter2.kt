package com.airwallex.grpc.demo

import com.airwallex.grpc.annotations.GrpcService
import com.airwallex.grpc.demo.Greeting2.HelloReply2
import com.airwallex.grpc.demo.Greeting2.HelloRequest2
import com.airwallex.grpc.spring.server.AutoGrpcServiceImpl

/**
 * Using kotlin DSL instead of protobuf java builder.
 *
 * schema: "greeting2.proto"
 */
@GrpcService
interface Greeter2 {
    suspend fun sayHello(request: HelloRequest2): HelloReply2
}

@AutoGrpcServiceImpl
class Greeter2Impl : Greeter2 {
    override suspend fun sayHello(request: HelloRequest2) =
        helloReply2 {
            message = "Hello ${request.name}"
        }
}
