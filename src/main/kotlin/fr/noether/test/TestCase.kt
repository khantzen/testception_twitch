package fr.noether.test

import kotlin.reflect.KFunction0

interface TestCase {
    fun setup() {}
    fun teardown() {}

    fun run(testMethod: ()->Unit) {
        setup()
        testMethod()
        teardown()
    }
}