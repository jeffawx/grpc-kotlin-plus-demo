package com.airwallex.grpc.demo

import com.airwallex.grpc.annotations.GrpcService
import com.airwallex.grpc.spring.server.AutoGrpcServiceImpl

/**
 * Simplest approach using well-known protobuf types.
 *
 * schema: "greeting1.proto"
 */
@GrpcService(protoJavaPackage = "demo")
interface Greeter1 {
    suspend fun sayHello(name: String): String
}

@AutoGrpcServiceImpl
class Greeter1Impl : Greeter1 {
    override suspend fun sayHello(name: String) = "Hello $name"
}
