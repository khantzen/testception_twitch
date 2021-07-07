package fr.noether.test.mock

import fr.noether.test.TestCase

class MyTestClass : TestCase {
    var log: String = ""

    override fun setup() {
        this.log += "setup"
    }

    fun `this test should be run`() {
        this.log+="-run"
    }

    fun `this test should also be run`() {
        this.log+="-run2"
    }

    override fun teardown() {
        this.log+="-teardown"
    }

}