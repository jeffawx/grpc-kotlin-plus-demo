package com.airwallex.refimpl.grpc

import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class EchoService : EchoServiceRpc {

    override fun echo(request: EchoRequestMsg): Mono<EchoReplyMsg> {
        return Mono.just(echoReplyMsg {
            message = "echo: " + request.message
        })
    }
}
