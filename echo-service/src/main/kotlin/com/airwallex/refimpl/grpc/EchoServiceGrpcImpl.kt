package com.airwallex.refimpl.grpc

import com.airwallex.grpc.spring.server.AutoGrpcServiceImpl
import reactor.core.publisher.Mono

@AutoGrpcServiceImpl
class EchoServiceGrpcImpl : EchoServiceGrpc {

    override fun echo(req: EchoRequestMsg): Mono<EchoReplyMsg> {
        return Mono.just(echoReplyMsg {
            message = "echo: " + req.message
        })
    }
}
