package com.airwallex.grpc.demo

import com.airwallex.grpc.demo.Greeting0.HelloReply
import com.airwallex.grpc.demo.Greeting0.HelloRequest
import com.airwallex.grpc.spring.server.AutoGrpcServiceImpl
import io.grpc.stub.StreamObserver

/**
 * Vanilla grpc-java implementation with callback programming interface.
 *
 * schema: "greeting0.proto"
 */
@AutoGrpcServiceImpl
class Greeter0 : GreeterGrpc.GreeterImplBase() {

    override fun sayHello(request: HelloRequest, response: StreamObserver<HelloReply>) {
        val msg = HelloReply.newBuilder().setMessage("Hello ${request.name}").build()
        response.onNext(msg)
        response.onCompleted()
    }
}
