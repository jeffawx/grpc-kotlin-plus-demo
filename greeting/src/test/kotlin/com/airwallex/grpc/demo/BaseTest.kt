package com.airwallex.grpc.demo

import com.airwallex.grpc.GrpcServer
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(
    "grpc.server.name=test",
    "grpc.server.port=-1", // 0 for random port, -1 for in-process server
)
@TestInstance(PER_CLASS)
abstract class BaseTest {

    @Autowired
    private lateinit var server: GrpcServer

    @AfterAll
    fun clean() {
        server.stop()
    }
}
