package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebTablesTest {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/webtables");

        // "ADD" düğmesine tıkla
        WebElement addButton = driver.findElement(By.cssSelector("button#addNewRecordButton"));
        addButton.click();

        // Yeni kayıt formunu doldur
        WebElement firstNameInput = driver.findElement(By.cssSelector("input#firstName"));
        firstNameInput.sendKeys("Abdullah");

        WebElement lastNameInput = driver.findElement(By.cssSelector("input#lastName"));
        lastNameInput.sendKeys("Şahin");

        WebElement emailInput = driver.findElement(By.cssSelector("input#userEmail"));
        emailInput.sendKeys("asahin@example.com");

        WebElement ageInput = driver.findElement(By.cssSelector("input#age"));
        ageInput.sendKeys("36");

        WebElement salaryInput = driver.findElement(By.cssSelector("input#salary"));
        salaryInput.sendKeys("500000");

        WebElement departmentInput = driver.findElement(By.cssSelector("input#department"));
        departmentInput.sendKeys("TEST");

        // Kaydet düğmesine tıkla
        WebElement saveButton = driver.findElement(By.cssSelector("button#submit"));
        saveButton.click();

        // Eklenen kaydı bul
        WebElement editedRecord = driver.findElement(By.cssSelector("div.rt-tbody > div.rt-tr-group:last-child"));

        // Kaydı düzenle
        WebElement editButton = editedRecord.findElement(By.cssSelector("div > div > span:nth-child(1) > button"));
        editButton.click();

        // Kaydı güncelle
        WebElement updatedFirstNameInput = driver.findElement(By.cssSelector("input#firstName"));
        updatedFirstNameInput.clear();
        updatedFirstNameInput.sendKeys("Alperen");

        WebElement updateButton = driver.findElement(By.cssSelector("button#submit"));
        updateButton.click();

        driver.quit();
    }
}

