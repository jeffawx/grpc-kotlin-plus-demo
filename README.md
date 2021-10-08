# grpc-kotlin-plus-demo

## Greeting

* **greeter**: uses built-in types without mapping

  [server](/greeting/src/main/kotlin/com/airwallex/grpc/demo/Greeter.kt)
  [client](/greeting/src/test/kotlin/com/airwallex/grpc/demo/GreeterTest.kt)
  [proto](/greeting/src/main/proto/demo/greeting.proto)

* **greeter2**: uses protobuf-kotlin DSL

  [server](/greeting/src/main/kotlin/com/airwallex/grpc/demo/Greeter2.kt)
  [client](/greeting/src/test/kotlin/com/airwallex/grpc/demo/Greeter2Test.kt)
  [proto](/greeting/src/main/proto/demo/greeting2.proto)

* **greeter3**: defines kotlin data class with custom [MapStruct](https://mapstruct.org/) mapping, also demonstrates
  supporting Project Reactor types as well as other async types.

  [server](/greeting/src/main/kotlin/com/airwallex/grpc/demo/Greeter3.kt)
  [client](/greeting/src/test/kotlin/com/airwallex/grpc/demo/Greeter3Test.kt)
  [proto](/greeting/src/main/proto/demo/greeting3.proto)

* **greeter4**: streaming example

  [server](/greeting/src/main/kotlin/com/airwallex/grpc/demo/Greeter4.kt)
  [client](/greeting/src/test/kotlin/com/airwallex/grpc/demo/Greeter4Test.kt)
  [proto](/greeting/src/main/proto/demo/greeting4.proto)
