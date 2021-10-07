package com.airwallex.grpc.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GrpcKotlinPlusDemoApplication

fun main(args: Array<String>) {
	runApplication<GrpcKotlinPlusDemoApplication>(*args)
}
