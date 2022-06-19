package com.airwallex.grpc.demo

import com.airwallex.grpc.annotations.GrpcClient
import com.airwallex.grpc.demo.Greeting3.HelloReply3
import com.airwallex.grpc.demo.Greeting3.HelloRequest3
import com.airwallex.mapstruct.protobuf.ProtobufConfig
import org.mapstruct.Mapper

@GrpcClient("greeter", name = "Greeter3", mapperInterface = GreeterMapper::class)
interface GreeterClient {
    suspend fun sayHello(request: GreetRequest): GreetReply
}

// Data class
class GreetRequest(val name: String)
class GreetReply(val message: String)

/**
 * Explicit mapping layer with mapstruct.
 *
 * This example uses default method names, can use custom method name with @GrpcMethod in service method.
 */
@Mapper(config = ProtobufConfig::class)
interface GreeterMapper {
    // for client
    fun sayHelloMapRequestToProto(request: GreetRequest): HelloRequest3
    fun sayHelloMapResponseFromProto(response: HelloReply3): GreetReply
}
