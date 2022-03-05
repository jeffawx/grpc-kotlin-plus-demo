package com.airwallex.grpc.demo

import com.airwallex.grpc.error.Error
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import demo.Greeter1Rpc
import org.springframework.stereotype.Service

@Service
class Greeter1Impl : Greeter1Rpc { // using generated service interface
    override suspend fun sayHello(request: String): Result<String, Error> = Ok("Hello $request")
}
