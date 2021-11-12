package com.airwallex.refimpl.grpc

import com.airwallex.grpc.spring.server.AutoGrpcServiceImpl
import reactor.core.publisher.Mono

@AutoGrpcServiceImpl
class EchoService : EchoServiceRpc {

    override fun echo(request: EchoRequestMsg): Mono<EchoReplyMsg> {
        return Mono.just(echoReplyMsg {
            message = "echo: " + request.message
        })
    }
}
