package com.example.demo.SMELogin;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SMELoginTest {
    
	public static WebDriver driver;
	

	@BeforeClass
	 static void setup(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://127.0.0.1:5500/Home.html");
	}

	@Test(priority = 1)
	void login(){
		
		WebElement btn=driver.findElement(By.linkText("Login"));
		btn.click();
		assertTrue(driver.getCurrentUrl().contains("loginJWT.html"),"Unable to open next page");
		WebElement email=driver.findElement(By.id("email"));
		WebElement pass=driver.findElement(By.id("password"));
		

		email.sendKeys("nirjala.naik@example.com");
		pass.sendKeys("12345");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));

		driver.findElement(By.cssSelector("button[type='submit']")).click();
		wait.until(ExpectedConditions.urlContains("/SME/sme.html"));

		WebElement create=driver.findElement(By.id("createTestLink"));
		create.click();
		assertTrue(driver.getCurrentUrl().contains("/SME/sme.html"),"Unable to open next page");

		 WebElement testName = driver.findElement(By.id("testName"));
         testName.sendKeys("Software Engineering");

         WebElement duration = driver.findElement(By.id("duration"));
         duration.sendKeys("00:30:00");

         WebElement Subject = driver.findElement(By.id("subjectSelect"));
         Select subject = new Select(Subject);
         subject.selectByVisibleText("ADVJAVA");

         try {
            Thread.sleep(2000); 
         } catch (Exception e) {
            
         }

         WebElement SME = driver.findElement(By.id("smeSelect"));
         Select sme = new Select(SME);
         sme.selectByVisibleText("sahil kamble");
         try {
            Thread.sleep(2000); 
         } catch (Exception e) {
            
         }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('scheduledDate').value = '2025-10-07T20:00';");

        //  WebElement date = driver.findElement(By.id("scheduledDate"));
        //  date.sendKeys("2025-10-07T12:35");
         try {
            Thread.sleep(2000); 
         } catch (Exception e) {
            
         }

         WebElement passingLevel = driver.findElement(By.id("passingLevel"));
         passingLevel.sendKeys("5");
         try {
            Thread.sleep(2000); 
         } catch (Exception e) {
            
         }

         WebElement que1 = driver.findElement(By.cssSelector("input[value='6']"));
         que1.click();

         WebElement que2 = driver.findElement(By.cssSelector("input[value='7']"));
         que2.click();

         WebElement que3 = driver.findElement(By.cssSelector("input[value='8']"));
         que3.click();

         WebElement que4 = driver.findElement(By.cssSelector("input[value='9']"));
         que4.click();

         WebElement que5 = driver.findElement(By.cssSelector("input[value='10']"));
         que5.click();
          try {
            Thread.sleep(2000); 
         } catch (Exception e) {
            
         }

         WebElement submitBtn = driver.findElement(By.id("submitBtn"));
         submitBtn.click();	
          try {
            Thread.sleep(2000); 
         } catch (Exception e) {
            
         }

         
         WebElement confirmBtn = driver.findElement(By.id("confirmBtn"));
         confirmBtn.click();
         	
          try {
            Thread.sleep(2000); 
         } catch (Exception e) {
            
         }

	}

	// @AfterClass
	// void teardown(){
	// 	driver.quit();
	// }

    
}
