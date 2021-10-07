package com.airwallex.grpc.demo

import com.airwallex.grpc.annotations.GrpcService
import com.airwallex.grpc.spring.server.AutoGrpcServiceImpl

/**
 * Simplest approach using well-known protobuf types.
 *
 * schema: "greeting.proto"
 */
@GrpcService(protoJavaPackage = "demo")
interface Greeter {
    suspend fun sayHello(name: String): String
}

@AutoGrpcServiceImpl
class GreeterImpl : Greeter {
    override suspend fun sayHello(name: String) = "Hello $name"
}
