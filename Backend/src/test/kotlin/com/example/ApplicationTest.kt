package com.example

import io.github.bonigarcia.wdm.WebDriverManager
import org.junit.jupiter.api.*
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration
import java.time.LocalDateTime

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ApplicationTest {
    private var driver = WebDriverManager.edgedriver().create()
    private val portalUrl = "http://localhost:3000"
    private val shopName = "shop-name";
    private val cartButton = "cart-Button"
    private val tabId = "//*[@id=\"full-width-tab-1\"]";

    fun loginUsingGithubAccount(){
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))

        driver.get(portalUrl)
        wait.until(ExpectedConditions.elementToBeClickable(By.id("userButtonUnloggedUser")))
        driver.findElement(By.id("userButtonUnloggedUser")).click()

        wait.until(ExpectedConditions.elementToBeClickable(By.id("githubButton")))
        driver.findElement(By.id("githubButton")).click()

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login_field\"]")))
        driver.findElement(By.xpath("//*[@id=\"login_field\"]")).sendKeys("TEST1EBiznes")

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"password\"]")))
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("E_Biznes_Pass2022")

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login\"]/div[3]/form/div/input[12]")))
        driver.findElement(By.xpath("//*[@id=\"login\"]/div[3]/form/div/input[12]")).click()
    }

    fun loginUsingGoogleAccount(){
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))

        driver.get(portalUrl)
        wait.until(ExpectedConditions.elementToBeClickable(By.id("userButtonUnloggedUser")))
        driver.findElement(By.id("userButtonUnloggedUser")).click()

        wait.until(ExpectedConditions.elementToBeClickable(By.id("googleButton")))
        driver.findElement(By.id("googleButton")).click()

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"identifierId\"]")))
        driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("TEST1E.Biznes@gmail.com")

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")))
        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click()

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")))
        driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("Testowe1")

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"passwordNext\"]/div/button/span")))
        driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/span")).click()
    }

    fun logout() {
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))
        wait.until(ExpectedConditions.elementToBeClickable(By.id("userButtonLoggedUser")))
        driver.findElement(By.id("userButtonLoggedUser")).click()
    }

    @AfterEach
    fun closeBrowser() {
        driver.close()
    }
    @BeforeEach
    fun openBrowser() {
        driver = WebDriverManager.edgedriver().create()
    }

    @Test
    fun shopNameVisibility() {
        driver.get(portalUrl)
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))
        wait.until(ExpectedConditions.elementToBeClickable(By.id(shopName)))
        val shopNameVisibility = driver.findElement(By.id(shopName)).isDisplayed
        Assertions.assertTrue(shopNameVisibility)
    }

    @Test
    fun cartButtonIsHidden() {
        //cart button should be hidden when user isn't logged
        driver.get(portalUrl)
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))
        wait.until(ExpectedConditions.elementToBeClickable(By.id(cartButton)))
        val cartButtons = driver.findElements(By.id(cartButton))

        Assertions.assertEquals(cartButtons.size, 0)
    }

    @Test
    fun ordersButtonIsHidden() {
        //orders button should be hidden when user isn't logged
        driver.get(portalUrl)
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ordersButton")))
        val cartButtons = driver.findElements(By.id("ordersButton"))

        Assertions.assertEquals(cartButtons.size, 0)
    }

    @Test
    fun userButtonUnloggedUserVisibility() {
        //userButtonUnloggedUser should be visible when user isn't logged
        driver.get(portalUrl)
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))
        wait.until(ExpectedConditions.elementToBeClickable(By.id("userButtonUnloggedUser")))
        val userButtonVisibility = driver.findElement(By.id("userButtonUnloggedUser")).isDisplayed
        Assertions.assertTrue(userButtonVisibility)
    }

    @Test
    fun userButtonUnloggedUserOnCartPageVisibility() {
        //userButtonUnloggedUser should be visible when user isn't logged
        driver.get("$portalUrl/cart")
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))
        wait.until(ExpectedConditions.elementToBeClickable(By.id("userButtonUnloggedUser")))
        val userButtonVisibility = driver.findElement(By.id("userButtonUnloggedUser")).isDisplayed
        Assertions.assertTrue(userButtonVisibility)
    }

    @Test
    fun userButtonloggedUserVisibility() {
        //userButtonloggedUser should be hidden when user isn't logged
        driver.get(portalUrl)

        val userButtons = driver.findElements(By.id("userButtonLoggedUser"))
        Assertions.assertEquals(userButtons.size, 0)
    }

    @Test
    fun homeButtonVisibility() {
        driver.get(portalUrl)
        val homeButtonVisibility = driver.findElement(By.id("homeButton")).isDisplayed
        Assertions.assertTrue(homeButtonVisibility)
    }

    @Test
    fun homeButtonVisibilityOnCartPage() {
        driver.get("$portalUrl/cart")
        val homeButtonVisibility = driver.findElement(By.id("homeButton")).isDisplayed
        Assertions.assertTrue(homeButtonVisibility)
    }

    @Test
    fun homeButtonVisibilityOnOrdersPage() {
        driver.get("$portalUrl/orders")
        val homeButtonVisibility = driver.findElement(By.id("homeButton")).isDisplayed
        Assertions.assertTrue(homeButtonVisibility)
    }

    @Test
    fun homeButtonVisibilityOnLoginPage() {
        driver.get("$portalUrl/login")
        val homeButtonVisibility = driver.findElement(By.id("homeButton")).isDisplayed
        Assertions.assertTrue(homeButtonVisibility)
    }

    @Test
    fun startPageVisibilty() {
        driver.get(portalUrl)
        val startPageVisibility = driver.findElement(By.id("startPage")).isDisplayed
        Assertions.assertTrue(startPageVisibility)
    }

    @Test
    fun categoriesVisibilty() {
        driver.get(portalUrl)
        val userButtons = driver.findElements(By.id("category_1"))
        Assertions.assertEquals(userButtons.size, 1)
    }

    @Test
    fun changeCategory() {
        driver.get(portalUrl)
        val category1 = driver.findElement(By.xpath("//*[@id=\"full-width-tab-1\"]"))
        category1.click()

        val element = driver.findElements(By.xpath("//*[@id=\"category_1\"]"))
        Assertions.assertEquals(element.size, 1)
        Assertions.assertTrue(element[0].isDisplayed)
    }

    @Test
    fun productsVisibilty() {
        driver.get(portalUrl)
        val category1 = driver.findElement(By.xpath("//*[@id=\"full-width-tab-1\"]"))
        category1.click()
        val products = driver.findElements(By.xpath("//*[@id=\"product\"]/div"))
        Assertions.assertTrue(products.size>0)
    }

    @Test
    fun plusButtonVisibilty() {
        driver.get(portalUrl)
        val category1 = driver.findElement(By.xpath("//*[@id=\"full-width-tab-1\"]"))
        category1.click()
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))
        wait.until(ExpectedConditions.elementToBeClickable(By.id("plusButton")))
        val plusButton = driver.findElements(By.id("plusButton"))
        Assertions.assertTrue(plusButton.size==0)
    }

    @Test
    fun productNameVisibilty() {
        driver.get(portalUrl)
        val category1 = driver.findElement(By.xpath("//*[@id=\"full-width-tab-1\"]"))
        category1.click()
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))
        wait.until(ExpectedConditions.elementToBeClickable(By.id("productName")))
        val element = driver.findElements(By.id("productName"))
        Assertions.assertTrue(element.size>0)
    }

    @Test
    fun productPriceVisibilty() {
        driver.get(portalUrl)
        val category1 = driver.findElement(By.xpath("//*[@id=\"full-width-tab-1\"]"))
        category1.click()
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))
        wait.until(ExpectedConditions.elementToBeClickable(By.id("productPrice")))
        val element = driver.findElements(By.id("productPrice"))
        Assertions.assertTrue(element.size>0)
    }

    @Test
    fun productDescriptionVisibilty() {
        driver.get(portalUrl)
        val category1 = driver.findElement(By.xpath("//*[@id=\"full-width-tab-1\"]"))
        category1.click()
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))
        wait.until(ExpectedConditions.elementToBeClickable(By.id("productDescription")))
        val element = driver.findElements(By.id("productDescription"))
        Assertions.assertTrue(element.size>0)
    }

    @Test
    fun homeButtonClickOnLoginPage() {
        driver.get("$portalUrl/login")
        val button = driver.findElement(By.id("homeButton"))
        button.click()
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))
        wait.until(ExpectedConditions.elementToBeClickable(By.id(shopName)))
        val shopNameVisibility = driver.findElement(By.id(shopName)).isDisplayed
        Assertions.assertTrue(shopNameVisibility)
    }

    @Test
    fun homeButtonClickOnCartPage() {
        driver.get("$portalUrl/cart")
        val button = driver.findElement(By.id("homeButton"))
        button.click()
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))
        wait.until(ExpectedConditions.elementToBeClickable(By.id(shopName)))
        val shopNameVisibility = driver.findElement(By.id(shopName)).isDisplayed
        Assertions.assertTrue(shopNameVisibility)
    }

    @Test
    fun homeButtonClickOnOrdersPage() {
        driver.get("$portalUrl/orders")
        val button = driver.findElement(By.id("homeButton"))
        button.click()
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))
        wait.until(ExpectedConditions.elementToBeClickable(By.id(shopName)))
        val shopNameVisibility = driver.findElement(By.id(shopName)).isDisplayed
        Assertions.assertTrue(shopNameVisibility)
    }

    @Test
    fun googleButtonOnLoginPage() {
        driver.get("$portalUrl/login")
        val buttonVisibility = driver.findElement(By.id("googleButton")).isDisplayed
        Assertions.assertTrue(buttonVisibility)
    }

    @Test
    fun githubButtonOnLoginPage() {
        driver.get("$portalUrl/login")
        val buttonVisibility = driver.findElement(By.id("githubButton")).isDisplayed
        Assertions.assertTrue(buttonVisibility)
    }

    @Test
    fun orderButtonVisibility() {
    driver.get("$portalUrl/cart")
    val buttonVisibility = driver.findElement(By.id("orderButton")).isDisplayed
    Assertions.assertTrue(buttonVisibility)
    }

    @Test
    fun adressTextFieldVisibility() {
        driver.get("$portalUrl/cart")
        val buttonVisibility = driver.findElement(By.id("outlined-basic")).isDisplayed
        Assertions.assertTrue(buttonVisibility)
    }

    @Test
    fun loginAndLogout() {
        driver.get("$portalUrl")
        loginUsingGoogleAccount();
        logout();
    }

    @Test
    fun cartButtonIsVisible() {
        //cart button should be visible when user is logged
        driver.get(portalUrl)
        loginUsingGoogleAccount();
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))
        wait.until(ExpectedConditions.elementToBeClickable(By.id(cartButton)))
        val cartButtons = driver.findElement(By.id(cartButton)).isDisplayed
        logout();
        Assertions.assertTrue(cartButtons)
    }

    @Test
    fun ordersButtonIsVisible() {
        //orders button should be visible when user is logged
        driver.get(portalUrl)
        loginUsingGoogleAccount();
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ordersButton")))
        val cartButtons = driver.findElement(By.id("ordersButton")).isDisplayed
        logout();
        Assertions.assertTrue(cartButtons)
    }

    @Test
    fun CartButtonWork() {
        //cart button should be visible when user is logged
        driver.get(portalUrl)
        loginUsingGoogleAccount();
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))
        wait.until(ExpectedConditions.elementToBeClickable(By.id(cartButton)))
        driver.findElement(By.id(cartButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("orderButton")))
        val element = driver.findElement(By.id("orderButton")).isDisplayed
        logout();
        Assertions.assertTrue(element)
    }

    @Test
    fun OrdersButtonWork() {
        driver.get(portalUrl)
        loginUsingGoogleAccount();
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ordersButton")))
        driver.findElement(By.id("ordersButton")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("historyTitle")))
        val element = driver.findElement(By.id("historyTitle")).isDisplayed
        driver.get(portalUrl)
        logout();
        Assertions.assertTrue(element)
    }

    @Test
    fun PlusButtonIsVisible() {
        driver.get(portalUrl)
        loginUsingGoogleAccount();
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"full-width-tab-1\"]")))
        val category1 = driver.findElement(By.xpath("//*[@id=\"full-width-tab-1\"]"))
        category1.click()
        wait.until(ExpectedConditions.elementToBeClickable(By.id("plusButton")))
        val plusButton = driver.findElements(By.id("plusButton"))
        logout();
        Assertions.assertTrue(plusButton.size!=0)
    }

    @Test
    fun PlusButtonWork() {
        driver.get(portalUrl)
        loginUsingGoogleAccount();
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"full-width-tab-1\"]")))
        val category1 = driver.findElement(By.xpath("//*[@id=\"full-width-tab-1\"]"))
        category1.click()
        wait.until(ExpectedConditions.elementToBeClickable(By.id("plusButton")))
        driver.findElements(By.id("plusButton"))[0].click()
        driver.switchTo().alert().accept();
        wait.until(ExpectedConditions.elementToBeClickable(By.id(cartButton)))
        driver.findElement(By.id(cartButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("productInCart")))
        val result = driver.findElement(By.id("productInCart")).isDisplayed;
        driver.findElement(By.id("deleteButton")).click();
        logout();
        Assertions.assertTrue(result)
    }

    @Test
    fun DeleteButtonIsVisible() {
        driver.get(portalUrl)
        loginUsingGoogleAccount();
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"full-width-tab-1\"]")))
        val category1 = driver.findElement(By.xpath("//*[@id=\"full-width-tab-1\"]"))
        category1.click()
        wait.until(ExpectedConditions.elementToBeClickable(By.id("plusButton")))
        driver.findElements(By.id("plusButton"))[0].click()
        driver.switchTo().alert().accept();
        wait.until(ExpectedConditions.elementToBeClickable(By.id(cartButton)))
        driver.findElement(By.id(cartButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("deleteButton")))
        val result = driver.findElement(By.id("deleteButton")).isDisplayed;
        driver.findElement(By.id("deleteButton")).click();
        logout();
        Assertions.assertTrue(result)
    }

    @Test
    fun DeleteButtonWork() {
        driver.get(portalUrl)
        loginUsingGoogleAccount();
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"full-width-tab-1\"]")))
        val category1 = driver.findElement(By.xpath("//*[@id=\"full-width-tab-1\"]"))
        category1.click()
        wait.until(ExpectedConditions.elementToBeClickable(By.id("plusButton")))
        driver.findElements(By.id("plusButton"))[0].click()
        driver.switchTo().alert().accept();
        wait.until(ExpectedConditions.elementToBeClickable(By.id(cartButton)))
        driver.findElement(By.id(cartButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("deleteButton")))
        driver.findElement(By.id("deleteButton")).click();
        val result = driver.findElements(By.id("productInCart"));
        logout();
        Assertions.assertTrue(result.size==0)
    }

    @Test
    fun addMulipleElements() {
        driver.get(portalUrl)
        loginUsingGoogleAccount();
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"full-width-tab-1\"]")))
        val category1 = driver.findElement(By.xpath("//*[@id=\"full-width-tab-1\"]"))
        category1.click()
        wait.until(ExpectedConditions.elementToBeClickable(By.id("plusButton")))
        driver.findElements(By.id("plusButton"))[0].click()
        driver.switchTo().alert().accept();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("plusButton")))
        driver.findElements(By.id("plusButton"))[0].click()
        driver.switchTo().alert().accept();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("plusButton")))
        driver.findElements(By.id("plusButton"))[1].click()
        driver.switchTo().alert().accept();
        wait.until(ExpectedConditions.elementToBeClickable(By.id(cartButton)))
        driver.findElement(By.id(cartButton)).click();
        Thread.sleep(2000)
        val result = driver.findElements(By.id("productInCart"));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("deleteButton")))
        driver.findElements(By.id("deleteButton"))[0].click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("deleteButton")))
        driver.findElements(By.id("deleteButton"))[0].click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("deleteButton")))
        driver.findElements(By.id("deleteButton"))[0].click();
        Thread.sleep(2000)
        val result2 = driver.findElements(By.id("productInCart"));
        logout();
        Assertions.assertTrue(result.size==2)
        Assertions.assertTrue(result2.size==0)
    }

    @Test
    fun clearCartAfterOrder() {
        driver.get(portalUrl)
        loginUsingGoogleAccount();
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"full-width-tab-1\"]")))
        val category1 = driver.findElement(By.xpath("//*[@id=\"full-width-tab-1\"]"))
        category1.click()
        wait.until(ExpectedConditions.elementToBeClickable(By.id("plusButton")))
        driver.findElements(By.id("plusButton"))[0].click()
        driver.switchTo().alert().accept();
        wait.until(ExpectedConditions.elementToBeClickable(By.id(cartButton)))
        driver.findElement(By.id(cartButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("orderButton")))
        val result = driver.findElements(By.id("productInCart"));
        driver.findElement(By.id("orderButton")).click()
        val result2 = driver.findElements(By.id("productInCart"));
        logout();
        Assertions.assertTrue(result.size==1)
        Assertions.assertTrue(result2.size==0)
    }

    @Test
    fun createOrderWork() {
        driver.get(portalUrl)
        loginUsingGoogleAccount();
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ordersButton")))

        driver.findElement(By.id("ordersButton")).click()
        val ordersCount = driver.findElements(By.id("order"))
        wait.until(ExpectedConditions.elementToBeClickable(By.id("homeButton")))
        driver.findElement(By.id("homeButton")).click()

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"full-width-tab-1\"]")))
        val category1 = driver.findElement(By.xpath("//*[@id=\"full-width-tab-1\"]"))
        category1.click()
        wait.until(ExpectedConditions.elementToBeClickable(By.id("plusButton")))
        driver.findElements(By.id("plusButton"))[0].click()
        driver.switchTo().alert().accept();
        wait.until(ExpectedConditions.elementToBeClickable(By.id(cartButton)))
        driver.findElement(By.id(cartButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("orderButton")))
        Thread.sleep(2000)
        val result = driver.findElements(By.id("productInCart"));
        driver.findElement(By.id("orderButton")).click()
        Thread.sleep(2000)
        val result2 = driver.findElements(By.id("productInCart"));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("homeButton")))
        driver.findElement(By.id("homeButton")).click()
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ordersButton")))
        driver.findElement(By.id("ordersButton")).click()
        wait.until(ExpectedConditions.elementToBeClickable(By.id("homeButton")))
        Thread.sleep(2000)
        val result3 = driver.findElements(By.id("order"))
        driver.findElement(By.id("homeButton")).click()
        logout();
        Assertions.assertEquals(1,result.size)
        Assertions.assertEquals(0,result2.size)
        Assertions.assertEquals(ordersCount.size+1, result3.size)
    }

    @Test
    fun createOrderWorkMultipleElements() {
        driver.get(portalUrl)
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))

        loginUsingGoogleAccount();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("ordersButton")))
        driver.findElement(By.id("ordersButton")).click()
        wait.until(ExpectedConditions.elementToBeClickable(By.id("order")))
        val ordersCount = driver.findElements(By.id("order"))

        wait.until(ExpectedConditions.elementToBeClickable(By.id("homeButton")))
        driver.findElement(By.id("homeButton")).click()

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"full-width-tab-1\"]")))
        val category1 = driver.findElement(By.xpath("//*[@id=\"full-width-tab-1\"]"))
        category1.click()

        wait.until(ExpectedConditions.elementToBeClickable(By.id("plusButton")))
        driver.findElements(By.id("plusButton"))[0].click()
        driver.switchTo().alert().accept();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("plusButton")))
        driver.findElements(By.id("plusButton"))[0].click()
        driver.switchTo().alert().accept();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("plusButton")))
        driver.findElements(By.id("plusButton"))[1].click()
        driver.switchTo().alert().accept();

        wait.until(ExpectedConditions.elementToBeClickable(By.id(cartButton)))
        driver.findElement(By.id(cartButton)).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("orderButton")))
        val result = driver.findElements(By.id("productInCart"));
        Thread.sleep(2000);
        val productsAmount = driver.findElements(By.id("productAmount"));
        val productText = driver.findElement(By.id("productAmount")).text;
        driver.findElement(By.id("orderButton")).click()
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("orderButton")))
        val result2 = driver.findElements(By.id("productInCart"));

        wait.until(ExpectedConditions.elementToBeClickable(By.id("homeButton")))
        driver.findElement(By.id("homeButton")).click()

        wait.until(ExpectedConditions.elementToBeClickable(By.id("ordersButton")))
        driver.findElement(By.id("ordersButton")).click()

        wait.until(ExpectedConditions.elementToBeClickable(By.id("order")))
        val result3 = driver.findElements(By.id("order"))
        driver.findElement(By.id("homeButton")).click()

        logout();
        Assertions.assertEquals(2, result.size)
        Assertions.assertEquals(0,result2.size)
        Assertions.assertEquals(ordersCount.size+1,result3.size)
        Assertions.assertEquals(2, productsAmount.size)
        Assertions.assertEquals("Ilość produktów w koszyku: 2",productText)
    }

    @Test
    fun verifySimpleOrder() {
        driver.get(portalUrl)
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))

        loginUsingGithubAccount();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"full-width-tab-1\"]")))
        val category1 = driver.findElement(By.xpath("//*[@id=\"full-width-tab-1\"]"))
        category1.click()

        wait.until(ExpectedConditions.elementToBeClickable(By.id("plusButton")))
        driver.findElements(By.id("plusButton"))[0].click()
        driver.switchTo().alert().accept();

        wait.until(ExpectedConditions.elementToBeClickable(By.id(cartButton)))
        driver.findElement(By.id(cartButton)).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("orderButton")))
        Thread.sleep(2000);
        val result = driver.findElements(By.id("productInCart"));
        Thread.sleep(2000);
        val productsAmount = driver.findElements(By.id("productAmount"));
        val productText = driver.findElement(By.id("productAmount")).text;
        driver.findElement(By.id("outlined-basic")).sendKeys("Testowy adres 1")
        driver.findElement(By.id("orderButton")).click()
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("orderButton")))
        val result2 = driver.findElements(By.id("productInCart"));

        wait.until(ExpectedConditions.elementToBeClickable(By.id("homeButton")))
        driver.findElement(By.id("homeButton")).click()

        wait.until(ExpectedConditions.elementToBeClickable(By.id("ordersButton")))
        driver.findElement(By.id("ordersButton")).click()

        wait.until(ExpectedConditions.elementToBeClickable(By.id("order")))
        val result3 = driver.findElements(By.id("order"))

        val date = driver.findElement(By.id("order_date_"+(result3.size-1))).text;
        val price = driver.findElement(By.id("order_price_"+(result3.size-1))).text;
        val address = driver.findElement(By.id("order_address_"+(result3.size-1))).text;

        driver.findElement(By.id("homeButton")).click()

        logout();
        Assertions.assertEquals(1, result.size)
        Assertions.assertEquals(0,result2.size)
        Assertions.assertEquals(1, productsAmount.size)
        Assertions.assertEquals(LocalDateTime.now().toString().substring(0,10),date)
        Assertions.assertEquals("120.1 PLN",price)
        Assertions.assertEquals("Testowy adres 1",address)
        Assertions.assertEquals("Ilość produktów w koszyku: 1",productText)
    }

    @Test
    fun cartButtonIsVisibleGithub() {
        //cart button should be visible when user is logged
        driver.get(portalUrl)
        loginUsingGithubAccount();
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))
        wait.until(ExpectedConditions.elementToBeClickable(By.id(cartButton)))
        val cartButtons = driver.findElement(By.id(cartButton)).isDisplayed
        logout();
        Assertions.assertTrue(cartButtons)
    }

    @Test
    fun ordersButtonIsVisibleGithub() {
        //orders button should be visible when user is logged
        driver.get(portalUrl)
        loginUsingGithubAccount();
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ordersButton")))
        val cartButtons = driver.findElement(By.id("ordersButton")).isDisplayed
        logout();
        Assertions.assertTrue(cartButtons)
    }

    @Test
    fun CartButtonWorkGithub() {
        //cart button should be visible when user is logged
        driver.get(portalUrl)
        loginUsingGithubAccount();
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))
        wait.until(ExpectedConditions.elementToBeClickable(By.id(cartButton)))
        driver.findElement(By.id(cartButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("orderButton")))
        val element = driver.findElement(By.id("orderButton")).isDisplayed
        logout();
        Assertions.assertTrue(element)
    }

    @Test
    fun OrdersButtonWorkGithub() {
        driver.get(portalUrl)
        loginUsingGithubAccount();
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ordersButton")))
        driver.findElement(By.id("ordersButton")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("historyTitle")))
        val element = driver.findElement(By.id("historyTitle")).isDisplayed
        driver.get(portalUrl)
        logout();
        Assertions.assertTrue(element)
    }

    @Test
    fun PlusButtonIsVisibleGithub() {
        driver.get(portalUrl)
        loginUsingGithubAccount();
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"full-width-tab-1\"]")))
        val category1 = driver.findElement(By.xpath("//*[@id=\"full-width-tab-1\"]"))
        category1.click()
        wait.until(ExpectedConditions.elementToBeClickable(By.id("plusButton")))
        val plusButton = driver.findElements(By.id("plusButton"))
        logout();
        Assertions.assertTrue(plusButton.size!=0)
    }

    @Test
    fun PlusButtonWorkGithub() {
        driver.get(portalUrl)
        loginUsingGithubAccount();
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"full-width-tab-1\"]")))
        val category1 = driver.findElement(By.xpath("//*[@id=\"full-width-tab-1\"]"))
        category1.click()
        wait.until(ExpectedConditions.elementToBeClickable(By.id("plusButton")))
        driver.findElements(By.id("plusButton"))[0].click()
        driver.switchTo().alert().accept();
        wait.until(ExpectedConditions.elementToBeClickable(By.id(cartButton)))
        driver.findElement(By.id(cartButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("productInCart")))
        val result = driver.findElement(By.id("productInCart")).isDisplayed;
        driver.findElement(By.id("deleteButton")).click();
        logout();
        Assertions.assertTrue(result)
    }

    @Test
    fun DeleteButtonIsVisibleGithub() {
        driver.get(portalUrl)
        loginUsingGithubAccount();
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"full-width-tab-1\"]")))
        val category1 = driver.findElement(By.xpath("//*[@id=\"full-width-tab-1\"]"))
        category1.click()
        wait.until(ExpectedConditions.elementToBeClickable(By.id("plusButton")))
        driver.findElements(By.id("plusButton"))[0].click()
        driver.switchTo().alert().accept();
        wait.until(ExpectedConditions.elementToBeClickable(By.id(cartButton)))
        driver.findElement(By.id(cartButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("deleteButton")))
        val result = driver.findElement(By.id("deleteButton")).isDisplayed;
        driver.findElement(By.id("deleteButton")).click();
        logout();
        Assertions.assertTrue(result)
    }

    @Test
    fun DeleteButtonWorkGithub() {
        driver.get(portalUrl)
        loginUsingGithubAccount();
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"full-width-tab-1\"]")))
        val category1 = driver.findElement(By.xpath("//*[@id=\"full-width-tab-1\"]"))
        category1.click()
        wait.until(ExpectedConditions.elementToBeClickable(By.id("plusButton")))
        driver.findElements(By.id("plusButton"))[0].click()
        driver.switchTo().alert().accept();
        wait.until(ExpectedConditions.elementToBeClickable(By.id(cartButton)))
        driver.findElement(By.id(cartButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("deleteButton")))
        driver.findElement(By.id("deleteButton")).click();
        val result = driver.findElements(By.id("productInCart"));
        logout();
        Assertions.assertTrue(result.size==0)
    }

    @Test
    fun addMulipleElementsGithub() {
        driver.get(portalUrl)
        loginUsingGithubAccount();
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"full-width-tab-1\"]")))
        val category1 = driver.findElement(By.xpath("//*[@id=\"full-width-tab-1\"]"))
        category1.click()
        wait.until(ExpectedConditions.elementToBeClickable(By.id("plusButton")))
        driver.findElements(By.id("plusButton"))[0].click()
        driver.switchTo().alert().accept();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("plusButton")))
        driver.findElements(By.id("plusButton"))[0].click()
        driver.switchTo().alert().accept();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("plusButton")))
        driver.findElements(By.id("plusButton"))[1].click()
        driver.switchTo().alert().accept();
        wait.until(ExpectedConditions.elementToBeClickable(By.id(cartButton)))
        driver.findElement(By.id(cartButton)).click();
        Thread.sleep(2000)
        val result = driver.findElements(By.id("productInCart"));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("deleteButton")))
        driver.findElements(By.id("deleteButton"))[0].click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("deleteButton")))
        driver.findElements(By.id("deleteButton"))[0].click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("deleteButton")))
        driver.findElements(By.id("deleteButton"))[0].click();
        Thread.sleep(2000)
        val result2 = driver.findElements(By.id("productInCart"));
        logout();
        Assertions.assertTrue(result.size==2)
        Assertions.assertTrue(result2.size==0)
    }

    @Test
    fun clearCartAfterOrderGithub() {
        driver.get(portalUrl)
        loginUsingGithubAccount();
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"full-width-tab-1\"]")))
        val category1 = driver.findElement(By.xpath("//*[@id=\"full-width-tab-1\"]"))
        category1.click()
        wait.until(ExpectedConditions.elementToBeClickable(By.id("plusButton")))
        driver.findElements(By.id("plusButton"))[0].click()
        driver.switchTo().alert().accept();
        wait.until(ExpectedConditions.elementToBeClickable(By.id(cartButton)))
        driver.findElement(By.id(cartButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("orderButton")))
        val result = driver.findElements(By.id("productInCart"));
        driver.findElement(By.id("orderButton")).click()
        val result2 = driver.findElements(By.id("productInCart"));
        logout();
        Assertions.assertTrue(result.size==1)
        Assertions.assertTrue(result2.size==0)
    }

    @Test
    fun createOrderWorkGithub() {
        driver.get(portalUrl)
        loginUsingGithubAccount();
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ordersButton")))

        driver.findElement(By.id("ordersButton")).click()
        val ordersCount = driver.findElements(By.id("order"))
        wait.until(ExpectedConditions.elementToBeClickable(By.id("homeButton")))
        driver.findElement(By.id("homeButton")).click()

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"full-width-tab-1\"]")))
        val category1 = driver.findElement(By.xpath("//*[@id=\"full-width-tab-1\"]"))
        category1.click()
        wait.until(ExpectedConditions.elementToBeClickable(By.id("plusButton")))
        driver.findElements(By.id("plusButton"))[0].click()
        driver.switchTo().alert().accept();
        wait.until(ExpectedConditions.elementToBeClickable(By.id(cartButton)))
        driver.findElement(By.id(cartButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("orderButton")))
        Thread.sleep(2000)
        val result = driver.findElements(By.id("productInCart"));
        driver.findElement(By.id("orderButton")).click()
        Thread.sleep(2000)
        val result2 = driver.findElements(By.id("productInCart"));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("homeButton")))
        driver.findElement(By.id("homeButton")).click()
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ordersButton")))
        driver.findElement(By.id("ordersButton")).click()
        wait.until(ExpectedConditions.elementToBeClickable(By.id("homeButton")))
        Thread.sleep(2000)
        val result3 = driver.findElements(By.id("order"))
        driver.findElement(By.id("homeButton")).click()
        logout();
        Assertions.assertEquals(1,result.size)
        Assertions.assertEquals(0,result2.size)
        Assertions.assertEquals(ordersCount.size+1, result3.size)
    }

    @Test
    fun createOrderWorkMultipleElementsGithub() {
        driver.get(portalUrl)
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))

        loginUsingGithubAccount();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("ordersButton")))
        driver.findElement(By.id("ordersButton")).click()
        wait.until(ExpectedConditions.elementToBeClickable(By.id("order")))
        val ordersCount = driver.findElements(By.id("order"))

        wait.until(ExpectedConditions.elementToBeClickable(By.id("homeButton")))
        driver.findElement(By.id("homeButton")).click()

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"full-width-tab-1\"]")))
        val category1 = driver.findElement(By.xpath("//*[@id=\"full-width-tab-1\"]"))
        category1.click()

        wait.until(ExpectedConditions.elementToBeClickable(By.id("plusButton")))
        driver.findElements(By.id("plusButton"))[0].click()
        driver.switchTo().alert().accept();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("plusButton")))
        driver.findElements(By.id("plusButton"))[0].click()
        driver.switchTo().alert().accept();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("plusButton")))
        driver.findElements(By.id("plusButton"))[1].click()
        driver.switchTo().alert().accept();

        wait.until(ExpectedConditions.elementToBeClickable(By.id(cartButton)))
        driver.findElement(By.id(cartButton)).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("orderButton")))
        val result = driver.findElements(By.id("productInCart"));
        Thread.sleep(2000);
        val productsAmount = driver.findElements(By.id("productAmount"));
        val productText = driver.findElement(By.id("productAmount")).text;
        driver.findElement(By.id("orderButton")).click()
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("orderButton")))
        val result2 = driver.findElements(By.id("productInCart"));

        wait.until(ExpectedConditions.elementToBeClickable(By.id("homeButton")))
        driver.findElement(By.id("homeButton")).click()

        wait.until(ExpectedConditions.elementToBeClickable(By.id("ordersButton")))
        driver.findElement(By.id("ordersButton")).click()

        wait.until(ExpectedConditions.elementToBeClickable(By.id("order")))
        val result3 = driver.findElements(By.id("order"))
        driver.findElement(By.id("homeButton")).click()

        logout();
        Assertions.assertEquals(2, result.size)
        Assertions.assertEquals(0,result2.size)
        Assertions.assertEquals(ordersCount.size+1,result3.size)
        Assertions.assertEquals(2, productsAmount.size)
        Assertions.assertEquals("Ilość produktów w koszyku: 2",productText)
    }

    @Test
    fun verifySimpleOrderGithub() {
        driver.get(portalUrl)
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))

        loginUsingGithubAccount();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"full-width-tab-1\"]")))
        val category1 = driver.findElement(By.xpath("//*[@id=\"full-width-tab-1\"]"))
        category1.click()

        wait.until(ExpectedConditions.elementToBeClickable(By.id("plusButton")))
        driver.findElements(By.id("plusButton"))[0].click()
        driver.switchTo().alert().accept();

        wait.until(ExpectedConditions.elementToBeClickable(By.id(cartButton)))
        driver.findElement(By.id(cartButton)).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("orderButton")))
        Thread.sleep(2000);
        val result = driver.findElements(By.id("productInCart"));
        Thread.sleep(2000);
        val productsAmount = driver.findElements(By.id("productAmount"));
        val productText = driver.findElement(By.id("productAmount")).text;
        driver.findElement(By.id("outlined-basic")).sendKeys("Testowy adres 1")
        driver.findElement(By.id("orderButton")).click()
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("orderButton")))
        val result2 = driver.findElements(By.id("productInCart"));

        wait.until(ExpectedConditions.elementToBeClickable(By.id("homeButton")))
        driver.findElement(By.id("homeButton")).click()

        wait.until(ExpectedConditions.elementToBeClickable(By.id("ordersButton")))
        driver.findElement(By.id("ordersButton")).click()

        wait.until(ExpectedConditions.elementToBeClickable(By.id("order")))
        val result3 = driver.findElements(By.id("order"))

        val date = driver.findElement(By.id("order_date_"+(result3.size-1))).text;
        val price = driver.findElement(By.id("order_price_"+(result3.size-1))).text;
        val address = driver.findElement(By.id("order_address_"+(result3.size-1))).text;

        driver.findElement(By.id("homeButton")).click()

        logout();
        Assertions.assertEquals(1, result.size)
        Assertions.assertEquals(0,result2.size)
        Assertions.assertEquals(1, productsAmount.size)
        Assertions.assertEquals(LocalDateTime.now().toString().substring(0,10),date)
        Assertions.assertEquals("120.1 PLN",price)
        Assertions.assertEquals("Testowy adres 1",address)
        Assertions.assertEquals("Ilość produktów w koszyku: 1",productText)
    }
}