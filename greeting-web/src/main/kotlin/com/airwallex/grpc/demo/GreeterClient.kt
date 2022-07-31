package com.airwallex.grpc.demo

import com.airwallex.grpc.annotations.GrpcClient
import com.airwallex.grpc.annotations.GrpcMethod
import com.airwallex.grpc.demo.Greeting3.HelloReply3
import com.airwallex.grpc.demo.Greeting3.HelloRequest3
import com.airwallex.mapstruct.protobuf.ProtobufConfig
import org.mapstruct.Mapper

@GrpcClient("greeter", name = "Greeter3")
interface GreeterClient {
    @GrpcMethod(
        requestMapper = GreetRequestMapper::class,
        requestMapperProtoType = HelloRequest3::class,
        responseMapper = GreetReplyMapper::class,
        responseMapperProtoType = HelloReply3::class
    )
    suspend fun sayHello(request: GreetRequest): GreetReply
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
