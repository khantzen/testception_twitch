package fr.noether.test

import fr.noether.test.mock.FailingTest
import fr.noether.test.mock.SuccessfulTest

class TestStatusTest : TestCase {

    fun `A successful test should have OK status`() {
        val successfulTest = SuccessfulTest()

        val unitTest = UnitTest(
            successfulTest,
            successfulTest::`This test should be a success`
        ).execute()


        if (!unitTest.isSuccessful()) {
            throw AssertionsError()
        }

    }

    fun `A failing test should have KO status`() {
        val failingTest = FailingTest()

        val unitTest = UnitTest(
            failingTest,
            failingTest::`This test should be a disaster`
        ).execute()

        if (unitTest.isSuccessful()) {
            throw AssertionsError()
        }

    }

    fun `A failing test should have KO string result`() {
        val failingTest = FailingTest()

        val unitTest = UnitTest(
            failingTest,
            failingTest::`This test should be a disaster`,
            "A failing test should have KO string result"
        ).execute()


        if (unitTest.isSuccessful()) {
            throw AssertionsError()
        }

        if (unitTest.result() != "\u001B[31m A failing test should have KO string result | KO \u001B[0m") {
            throw AssertionsError()
        }

    }

    fun `A success test should have OK string result`() {
        val successfulTest = SuccessfulTest()

        val unitTest = UnitTest(
            successfulTest,
            successfulTest::`This test should be a success`,
            "A success test should have OK string result"
        ).execute()


        if (!unitTest.isSuccessful()) {
            throw AssertionsError()
        }


        if (unitTest.result() != "\u001B[32m A success test should have OK string result | OK \u001B[0m") {
            throw AssertionsError()
        }

    }

}