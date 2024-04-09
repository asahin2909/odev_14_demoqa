package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoqaTest {

    public static void main(String[] args) {
        // WebDriver'ı başlat
        WebDriver driver = new ChromeDriver();

        // demoqa.com adresine git
        driver.get("https://demoqa.com/elements");

        // "Buttons" seçeneğine tıkla
        WebElement buttonsOption = driver.findElement(By.xpath("//span[text()='Buttons']"));
        buttonsOption.click();

        // "Click Me" düğmesine tıkla
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement clickMeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Click Me']")));
        clickMeButton.click();

        // Görünen mesajı oku
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dynamicClickMessage")));
        System.out.println("Görünen mesaj: " + message.getText());

        // WebDriver'ı kapat
        driver.quit();
    }
}
