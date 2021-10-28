package com.airwallex.refimpl.grpc

import com.airwallex.grpc.annotations.GrpcService
import reactor.core.publisher.Mono

@GrpcService
interface EchoServiceGrpc {
    fun echo(req: EchoRequestMsg): Mono<EchoReplyMsg>
}
