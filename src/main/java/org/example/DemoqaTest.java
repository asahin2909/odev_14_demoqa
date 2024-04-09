package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoqaTest {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/elements");

        // "Buttons" seçeneğine tıkla
        WebElement buttonsOption = driver.findElement(By.cssSelector("span.menu-list:nth-child(3)"));
        buttonsOption.click();

        // "Click Me" düğmesine tıkla
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement clickMeButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[id='doubleClickBtn']")));
        clickMeButton.click();

        // Görünen mesajı oku
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("doubleClickMessage")));
        System.out.println("Görünen mesaj: " + message.getText());

        driver.quit();
    }
}
