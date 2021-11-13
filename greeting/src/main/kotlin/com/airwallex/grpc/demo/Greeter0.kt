package com.airwallex.grpc.demo

import com.airwallex.grpc.demo.Greeting0.HelloReply
import com.airwallex.grpc.demo.Greeting0.HelloRequest
import io.grpc.stub.StreamObserver
import org.springframework.stereotype.Service

/**
 * Vanilla grpc-java implementation with callback programming interface.
 *
 * schema: "greeting0.proto"
 */
@Service
class Greeter0 : GreeterGrpc.GreeterImplBase() {

    override fun sayHello(request: HelloRequest, response: StreamObserver<HelloReply>) {
        val msg = HelloReply.newBuilder().setMessage("Hello ${request.name}").build()
        response.onNext(msg)
        response.onCompleted()
    }
}
