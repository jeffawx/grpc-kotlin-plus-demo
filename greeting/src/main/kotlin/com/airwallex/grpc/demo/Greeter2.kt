package com.airwallex.grpc.demo

import com.airwallex.grpc.demo.Greeting2.HelloRequest2
import com.airwallex.grpc.error.Error
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import org.springframework.stereotype.Service

@Service
class Greeter2Impl : Greeter2Rpc {
    override suspend fun sayHello(request: HelloRequest2): Result<Greeting2.HelloReply2, Error> = Ok(
        helloReply2 {
            message = "Hello ${request.name}"
        }
    )
}
