package fr.noether.test.mock

import fr.noether.test.AssertionsError
import fr.noether.test.TestCase


class FailingTest: TestCase {

    fun `This test should be a disaster`() {
        throw AssertionsError()
    }
}
