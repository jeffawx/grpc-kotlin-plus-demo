package com.airwallex.grpc.demo

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.springframework.stereotype.Service

@Service
class Greeter4Impl : Greeter4Rpc {
    override fun sayHello(requests: Flow<String>) = requests.map { "Hello $it" }
}
