# grpc-kotlin-plus-demo

All examples are using "grpc-spring" gradle plugin, see [build script](/build.gradle.kts)

## Greeting

* **greeter-0**: vanilla grpc-java example setting up the stage
  [server](/greeting/src/main/kotlin/com/airwallex/grpc/demo/Greeter0.kt) |
  [client](/greeting/src/test/kotlin/com/airwallex/grpc/demo/Greeter0Test.kt) |
  [proto](/greeting/src/main/proto/demo/greeting0.proto)

* **greeter-1**: uses built-in types without mapping
  [server](/greeting/src/main/kotlin/com/airwallex/grpc/demo/Greeter1.kt) |
  [client](/greeting/src/test/kotlin/com/airwallex/grpc/demo/Greeter1Test.kt) |
  [proto](/greeting/src/main/proto/demo/greeting1.proto)

* **greeter-2**: uses protobuf-kotlin DSL
  [server](/greeting/src/main/kotlin/com/airwallex/grpc/demo/Greeter2.kt) |
  [client](/greeting/src/test/kotlin/com/airwallex/grpc/demo/Greeter2Test.kt) |
  [proto](/greeting/src/main/proto/demo/greeting2.proto)

* **greeter-3**: defines kotlin data class with custom [MapStruct](https://mapstruct.org/) mapping, also demonstrates
  supporting Project Reactor types as well as other async types.
  [server](/greeting/src/main/kotlin/com/airwallex/grpc/demo/Greeter3.kt) |
  [client](/greeting/src/test/kotlin/com/airwallex/grpc/demo/Greeter3Test.kt) |
  [proto](/greeting/src/main/proto/demo/greeting3.proto)

* **greeter-4**: streaming example
  [server](/greeting/src/main/kotlin/com/airwallex/grpc/demo/Greeter4.kt) |
  [client](/greeting/src/test/kotlin/com/airwallex/grpc/demo/Greeter4Test.kt) |
  [proto](/greeting/src/main/proto/demo/greeting4.proto)
