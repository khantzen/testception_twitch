package fr.noether.test

import fr.noether.test.mock.MyTestClass

class TestCaseTest : TestCase {
    fun `The test template should be executed when calling run method`() {
        val myTestClass = MyTestClass()

        if (myTestClass.log != "") {
            throw AssertionsError()
        }

        myTestClass.run(myTestClass::`this test should be run`)

        if (myTestClass.log != "setup-run-teardown") {
            throw AssertionsError()
        }
    }

    fun `Unit test should follow template when executed`() {
        val myTestClass = MyTestClass()

        val unitTest = UnitTest(myTestClass, myTestClass::`this test should be run`)

        unitTest.execute()

        if (myTestClass.log != "setup-run-teardown") {
            throw AssertionsError()
        }
    }

    fun `A test class can contain multiple test`() {
        val myTestClass = MyTestClass()
        myTestClass.run(myTestClass::`this test should be run`)
        if (myTestClass.log != "setup-run-teardown") {
            throw AssertionsError()
        }

        val myTestClass2 = MyTestClass()
        myTestClass2.run(myTestClass2::`this test should also be run`)
        if (myTestClass2.log != "setup-run2-teardown") {
            throw AssertionsError()
        }
    }

}
