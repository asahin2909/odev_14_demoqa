package org.example;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class DemoqaTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testButtonClick() {
        driver.get("https://demoqa.com/elements");

        // "Buttons" seçeneğine tıkla
        WebElement buttonsOption = driver.findElement(By.cssSelector("li#item-4"));
        buttonsOption.click();

        // "Click Me" düğmesine tıkla
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement clickMeButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button#doubleClickBtn")));
        clickMeButton.click();

        // Görünen mesajı kontrol et
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("doubleClickMessage")));
        assertEquals("Button double-clicked", message.getText());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
