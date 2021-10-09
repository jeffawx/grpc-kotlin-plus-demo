package com.airwallex.grpc.demo

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.web.bind.annotation.*

@RestController
class GreeterController(private val greeter: GreeterClient) {

    private val logger: Logger = LogManager.getLogger()

    @GetMapping("/hello/{name}")
    suspend fun hello(@PathVariable name: String): String {
        logger.info("hello request received: {}", name)

        return greeter.sayHello(GreetRequest(name)).message
    }
}
