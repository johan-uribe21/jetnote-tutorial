package com.example.tutorial1

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun `roll dice generates a number`() {
        val result = rollDice(6)
        assertEquals(result::class, Int::class)
    }
}