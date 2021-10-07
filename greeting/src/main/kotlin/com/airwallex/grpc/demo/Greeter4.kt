package com.airwallex.grpc.demo

import com.airwallex.grpc.annotations.GrpcService
import com.airwallex.grpc.spring.server.AutoGrpcServiceImpl
import reactor.core.publisher.Flux

/**
 * Streaming example.
 *
 * Although this example uses simple types, streaming also works for custom mapstruct mapping.
 *
 * schema: "greeting4.proto"
 */
@GrpcService
interface Greeter4 {
    fun sayHello(names: Flux<String>): Flux<String>
}

@AutoGrpcServiceImpl
class Greeter4Impl : Greeter4 {
    override fun sayHello(names: Flux<String>) = names.map { "Hello $it" }
}
