package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebTablesTest {

    public static void main(String[] args) {
        // WebDriver'ı başlat
        WebDriver driver = new ChromeDriver();

        // demoqa.com adresine git
        driver.get("https://demoqa.com/webtables");

        // "ADD" düğmesine tıkla
        WebElement addButton = driver.findElement(By.id("addNewRecordButton"));
        addButton.click();

        // Yeni kayıt formunu doldur
        WebElement firstNameInput = driver.findElement(By.id("firstName"));
        firstNameInput.sendKeys("Abdullah");

        WebElement lastNameInput = driver.findElement(By.id("lastName"));
        lastNameInput.sendKeys("Şahin");

        WebElement emailInput = driver.findElement(By.id("userEmail"));
        emailInput.sendKeys("asahin@example.com");

        WebElement ageInput = driver.findElement(By.id("age"));
        ageInput.sendKeys("36");

        WebElement salaryInput = driver.findElement(By.id("salary"));
        salaryInput.sendKeys("500000");

        WebElement departmentInput = driver.findElement(By.id("department"));
        departmentInput.sendKeys("TEST");

        // Kaydet düğmesine tıkla
        WebElement saveButton = driver.findElement(By.id("submit"));
        saveButton.click();

        // Eklenen kaydı bul
        WebElement editedRecord = driver.findElement(By.xpath("//div[@role='row'][last()]"));

        // Kaydı düzenle
        WebElement editButton = editedRecord.findElement(By.xpath(".//button[text()='Edit']"));
        editButton.click();

        // Kaydı güncelle
        WebElement updatedFirstNameInput = driver.findElement(By.id("firstName"));
        updatedFirstNameInput.clear();
        updatedFirstNameInput.sendKeys("Alperen");

        WebElement updateButton = driver.findElement(By.id("submit"));
        updateButton.click();

        // WebDriver'ı kapat
        driver.quit();
    }
}
