package com.airwallex.grpc.demo

import com.airwallex.grpc.spring.server.AutoGrpcServiceImpl
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

@AutoGrpcServiceImpl
class Greeter4Impl : Greeter4Rpc {
    override fun sayHello(requests: Flow<String>) = requests.map { "Hello $it" }
}
