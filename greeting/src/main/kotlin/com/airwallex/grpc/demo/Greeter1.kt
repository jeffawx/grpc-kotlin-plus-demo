package com.airwallex.grpc.demo

import demo.Greeter1Rpc
import org.springframework.stereotype.Service

@Service
class Greeter1Impl : Greeter1Rpc { // using generated service interface
    override suspend fun sayHello(request: String) = "Hello $request"
}
