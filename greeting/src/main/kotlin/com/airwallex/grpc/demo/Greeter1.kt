package com.airwallex.grpc.demo

import com.airwallex.grpc.spring.server.AutoGrpcServiceImpl
import demo.Greeter1Rpc

@AutoGrpcServiceImpl
class Greeter1Impl : Greeter1Rpc { // using generated service interface
    override suspend fun sayHello(request: String) = "Hello $request"
}
