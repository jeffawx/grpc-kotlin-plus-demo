package com.airwallex.grpc.demo

import com.airwallex.grpc.annotations.GrpcService
import com.airwallex.grpc.spring.server.AutoGrpcServiceImpl

/**
 * Using kotlin DSL instead of protobuf java builder.
 *
 * schema: "greeting2.proto"
 */
@GrpcService
interface Greeter2 {
    suspend fun sayHello(request: Greeting2.HelloRequest): Greeting2.HelloReply
}

@AutoGrpcServiceImpl
class Greeter2Impl : Greeter2 {
    override suspend fun sayHello(request: Greeting2.HelloRequest) =
        helloReply {
            message = "Hello ${request.name}"
        }
}
