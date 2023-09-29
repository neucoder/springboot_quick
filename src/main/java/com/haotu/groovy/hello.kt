package com.haotu.groovy

class hello {
    fun sayHello(name: String) {
        println("Hello $name")
    }
}

fun main() {
    val hello = hello()
    hello.sayHello("kotlin")
    hello.apply { sayHello("groovy") }
}