package com.example.unittesting


import org.junit.Assert.*
import org.junit.Test
import org.junit.jupiter.api.assertAll


class UtilHelperTest {

    @Test
    fun validatePassword_blankInput_expectedInvalid() {

        // Arrange
        val helper = UtilHelper()
        // Act
        val validate = helper.validatePassword("    ")
        // Assert
        assertEquals("invalid", validate)
    }

    @Test
    fun validatePassword_2CharInput_expectedInvalid() {

        // Arrange
        val helper = UtilHelper()
        // Act
        val validate = helper.validatePassword("ab")
        // Assert
        assertEquals("invalid", validate)
    }

    @Test
    fun validatePassword_16CharInput_expectedInvalid() {

        // Arrange
        val helper = UtilHelper()
        // Act
        val validate = helper.validatePassword("abhaygiri1234567")
        // Assert
        assertEquals("invalid", validate)
    }

    @Test
    fun validatePassword_validInput_expectedValid() {

        // Arrange
        val helper = UtilHelper()
        // Act
        val validate = helper.validatePassword("Pass123")
        // Assert
        assertEquals("valid", validate)
    }


    @Test(expected = IllegalArgumentException::class)
    fun reverseString_InputNullValue_ExpectedException() {

        // Arrange
        val helper = UtilHelper()
        // Act
        helper.reverseString(null)

    }

    @Test()
    fun reverseString_InputSingleValue_ExpectedSameString() {

        // Arrange
        val helper = UtilHelper()
        // Act
        val reverseString = helper.reverseString("a")
        // Assert
        assertEquals("a", reverseString)

    }

    @Test()
    fun reverseString_InputEmptyString_ExpectedEmptyString() {

        // Arrange
        val helper = UtilHelper()
        // Act
        val reverseString = helper.reverseString("")
        // Assert
        assertEquals("", reverseString)

    }

    @Test()
    fun reverseString_InputValidString_ExpectedReversedString() {

        // Arrange
        val helper = UtilHelper()
        // Act
        val reverseString = helper.reverseString("abhay")
        // Assert
        assertEquals("yahba", reverseString)

    }

    @Test
    fun groupedStringReversalAssertions() {
        // In a grouped assertion all assertions are executed, and all
        // failures will be reported together.

        val helper = UtilHelper()
        assertAll("reverseString",
            {
                val result = helper.reverseString("")
                assertNotNull(result)
                assertEquals("", result)
            },
            {
                val result = helper.reverseString("abhay")
                assertNotNull(result)
                assertEquals("yahba", result)
            },
            {
                val result = helper.reverseString("a")
                assertNotNull(result)
                assertEquals("a", result)
            },
            {
                val exception: Exception = assertThrows(IllegalArgumentException::class.java) {
                    helper.reverseString(null)
                }
                assertEquals("Null Not Allowed", exception.message)
            }
        )
    }

    @Test
    fun groupedValidatePasswordAssertions(){

        val helper = UtilHelper()

        assertAll("validate Password",
            {
                val result = helper.validatePassword("")
                assertNotNull(result)
                assertFalse(result.startsWith("va"))
            },
            {
                val result = helper.validatePassword("          ")
                assertNotNull(result)
                assertFalse(result.startsWith("va"))
            },
            {
                val result = helper.validatePassword("pass")
                assertNotNull(result)
                assertFalse(result.startsWith("va"))
            },
            {
                val result = helper.validatePassword("Pass1234567890Pass")
                assertNotNull(result)
                assertFalse(result.startsWith("va"))
            },{
                val result = helper.validatePassword("Pass12345")
                assertNotNull(result)
                assertTrue(result.startsWith("va"))
            }
        )
    }

}