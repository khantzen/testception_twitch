package fr.noether.test

class UnitTest(
    val testContext: TestCase,
    val testMethod: () -> Unit,
    val description: String = "",
    var status: Boolean = false
    ) {

    fun execute(): UnitTest {
        try {
            testContext.run(testMethod)
        } catch (e: Exception) {
            return UnitTest(testContext, testMethod, description, false)
        }
        
        return UnitTest(testContext, testMethod, description, true)
    }

    fun isSuccessful(): Boolean {
        return this.status
    }

    fun result(): String = if (isSuccessful()) {
        "\u001B[32m $description | OK \u001B[0m"
    } else {
        "\u001B[31m $description | KO \u001B[0m"
    }

}
