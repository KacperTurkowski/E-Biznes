package com.example

import io.github.bonigarcia.wdm.WebDriverManager
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ApplicationTest {
    private val driver = WebDriverManager.edgedriver().create()

    @Test
    fun `open Amazon_com`() {
        driver.get("https://amazon.com")
    }

    @AfterAll
    fun `close browser`() {
        driver.close()
    }
}