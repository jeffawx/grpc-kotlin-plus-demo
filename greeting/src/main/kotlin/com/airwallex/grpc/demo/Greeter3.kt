package com.airwallex.grpc.demo

import com.airwallex.grpc.annotations.GrpcService
import com.airwallex.grpc.spring.server.AutoGrpcServiceImpl
import com.airwallex.mapstruct.protobuf.ProtobufConfig
import org.mapstruct.Mapper
import reactor.core.publisher.Mono

/**
 * Using kotlin data class with mapstruct mapping.
 *
 * Also demonstrate other async types are supported, e.g. Mono/CompletableFuture/Deferred etc
 *
 * This is the most complex scenario which has an explicit mapping layer (Anti-Corruption Layer)
 *
 * schema: "greeting3.proto"
 */
@GrpcService(mapperInterface = GreeterMapper::class)
interface Greeter3 {
    fun sayHello(request: GreetRequest): Mono<GreetReply> // other async types are supported as well.
}

@AutoGrpcServiceImpl
class Greeter3Impl : Greeter3 {
    override fun sayHello(request: GreetRequest) =
        Mono.just(GreetReply("Hello ${request.name}"))
}

// Data class
data class GreetRequest(val name: String)
data class GreetReply(val message: String)

/**
 * Explicit mapping layer with mapstruct.
 *
 * This example uses default method names, can use custom method name with @GrpcMethod in service method.
 */
@Mapper(config = ProtobufConfig::class)
interface GreeterMapper {
    // for server
    fun sayHelloMapRequestFromProto(request: Greeting3.HelloRequest3): GreetRequest
    fun sayHelloMapResponseToProto(response: GreetReply): Greeting3.HelloReply3

    // for client
    fun sayHelloMapRequestToProto(request: GreetRequest): Greeting3.HelloRequest3
    fun sayHelloMapResponseFromProto(response: Greeting3.HelloReply3): GreetReply
}
