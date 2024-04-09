package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.junit.Assert.assertEquals;

public class WebTablesTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testAddRecord() {
        driver.get("https://demoqa.com/webtables");

        // "ADD" düğmesine tıkla
        WebElement addButton = driver.findElement(By.cssSelector("button#addNewRecordButton"));
        addButton.click();

        // Yeni kayıt formunu doldur
        WebElement firstNameInput = driver.findElement(By.cssSelector("input#firstName"));
        firstNameInput.sendKeys("John");

        WebElement lastNameInput = driver.findElement(By.cssSelector("input#lastName"));
        lastNameInput.sendKeys("Doe");

        WebElement emailInput = driver.findElement(By.cssSelector("input#userEmail"));
        emailInput.sendKeys("johndoe@example.com");

        WebElement ageInput = driver.findElement(By.cssSelector("input#age"));
        ageInput.sendKeys("30");

        WebElement salaryInput = driver.findElement(By.cssSelector("input#salary"));
        salaryInput.sendKeys("50000");

        WebElement departmentInput = driver.findElement(By.cssSelector("input#department"));
        departmentInput.sendKeys("IT");

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
        updatedFirstNameInput.sendKeys("Jane");

        WebElement updateButton = driver.findElement(By.cssSelector("button#submit"));
        updateButton.click();

        // Güncellenen kaydın kontrolünü yap
        WebElement updatedRecord = driver.findElement(By.cssSelector("div.rt-tbody > div.rt-tr-group:last-child"));
        WebElement updatedFirstName = updatedRecord.findElement(By.cssSelector("div.rt-td:nth-child(1)"));
        assertEquals("Jane", updatedFirstName.getText());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
