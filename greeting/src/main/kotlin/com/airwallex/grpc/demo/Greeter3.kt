package com.airwallex.grpc.demo

import com.airwallex.grpc.annotations.GrpcMethod
import com.airwallex.grpc.annotations.GrpcService
import com.airwallex.grpc.demo.Greeting3.HelloReply3
import com.airwallex.grpc.demo.Greeting3.HelloRequest3
import com.airwallex.mapstruct.protobuf.ProtobufConfig
import org.mapstruct.Mapper
import org.springframework.stereotype.Service
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
@GrpcService
interface Greeter3 {
    @GrpcMethod(
        requestMapper = GreetRequestMapper::class,
        requestMapperProtoType = HelloRequest3::class,
        responseMapper = GreetReplyMapper::class,
        responseMapperProtoType = HelloReply3::class
    )
    fun sayHello(request: GreetRequest): Mono<GreetReply> // other async types are supported as well.
}

@Service
class Greeter3Impl : Greeter3 {
    override fun sayHello(request: GreetRequest) =
        Mono.just(GreetReply("Hello ${request.name}"))
}

// Data class
class GreetRequest(val name: String)
class GreetReply(val message: String)

/**
 * Explicit mapping layer with mapstruct.
 */
@Mapper(config = ProtobufConfig::class)
interface GreetRequestMapper : com.airwallex.mapstruct.protobuf.MessageMapper<HelloRequest3, GreetRequest>

@Mapper(config = ProtobufConfig::class)
interface GreetReplyMapper : com.airwallex.mapstruct.protobuf.MessageMapper<HelloReply3, GreetReply>
