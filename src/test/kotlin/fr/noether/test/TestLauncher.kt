package fr.noether.test

class TestLauncher {
}

fun main(args: Array<String>) {
    val testCaseTest = TestCaseTest()
    UnitTest(
        testCaseTest,
        testCaseTest::`The test template should be executed when calling run method`,
        "The test template should be executed when calling run method"
    ).execute().print()


    val testCaseTest2 = TestCaseTest()
    UnitTest(
        testCaseTest2,
        testCaseTest2::`A test class can contain multiple test`,
        "A test class can contain multiple test"
    ).execute().print()

    val testCaseTest3 = TestCaseTest()
    UnitTest(
        testCaseTest3,
        testCaseTest3::`Unit test should follow template when executed`,
    "Unit test should follow template when executed"
    ).execute().print()

    val testStatus = TestStatusTest()
    UnitTest(
        testStatus,
        testStatus::`A successful test should have OK status`,
        "A successful test should have OK status"
    ).execute().print()

    val testInError = TestStatusTest()
    UnitTest(
        testInError,
        testInError::`A successful test should have OK status`,
    "A successful test should have OK status"
    ).execute().print()

    val testInErrorLog = TestStatusTest()
    UnitTest(
        testInErrorLog,
        testInErrorLog::`A failing test should have KO string result`,
    "A failing test should have KO string result"
    ).execute().print()

    val testSuccessLog = TestStatusTest()
    UnitTest(
        testSuccessLog,
        testSuccessLog::`A success test should have OK string result`,
        "A success test should have OK string result"
    ).execute().print()
}

private fun UnitTest.print() = println(this.result())



