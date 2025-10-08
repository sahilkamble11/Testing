package com.example.demo.AdminLogin;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdminLoginTest {
    public static WebDriver driver;
	

	@BeforeClass
	 static void setup(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://127.0.0.1:5500/Home.html");
	}

	@Test(priority = 2)
	void login(){
		
		WebElement btn=driver.findElement(By.linkText("Login"));
		btn.click();
		assertTrue(driver.getCurrentUrl().contains("loginJWT.html"),"Unable to open next page");
		WebElement email=driver.findElement(By.id("email"));
		WebElement pass=driver.findElement(By.id("password"));
		

		email.sendKeys("ravi.tambade@example.com");
		pass.sendKeys("12345");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));

		driver.findElement(By.cssSelector("button[type='submit']")).click();
		wait.until(ExpectedConditions.urlContains("/Admin/admin.html"));

		WebElement showTestBtw=driver.findElement(By.id("showTestBtw"));
		showTestBtw.click();
		assertTrue(driver.getCurrentUrl().contains("/Admin/admin.html"),"Unable to open next page");

		WebElement fromDate = driver.findElement(By.id("fromDate"));
        fromDate.sendKeys("06102025");

		WebElement toDate = driver.findElement(By.id("toDate"));
		toDate.sendKeys("08102025");	
		 try {
            Thread.sleep(2000); 
         } catch (Exception e) {
            
         }
        WebElement getTest=driver.findElement(By.xpath("//button[text()='Get Tests']"));
		getTest.click();
         try {
            Thread.sleep(2000); 
         } catch (Exception e) {
            
         }
       WebElement updateTest = driver.findElement(By.xpath("//button[@onclick='updateTest(23)']"));
       updateTest.click();


         try {
            Thread.sleep(2000); 
         } catch (Exception e) {
            
         }

        WebElement Status = driver.findElement(By.id("statusDropdown"));
        Select status = new Select(Status);
         status.selectByVisibleText("Scheduled");

         WebElement changeStatus=driver.findElement(By.id("changeStatus"));
		 changeStatus.click();
         try {
            Thread.sleep(1000); 
         } catch (Exception e) {
            
         }

         Alert alert=driver.switchTo().alert();
         alert.accept();
          try {
            Thread.sleep(1000); 
         } catch (Exception e) {
            
         }

        WebElement getStudents=driver.findElement(By.id("getStudents"));
		 getStudents.click();
          try {
            Thread.sleep(1000); 
         } catch (Exception e) {
            
         }

         WebElement empcheckbox = driver.findElement(By.cssSelector("input[value='4']"));
        empcheckbox.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('scheduledStart').value = '2025-10-08T12:00';");
        try {
            Thread.sleep(1000); 
         } catch (Exception e) {
            
         }


        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("document.getElementById('scheduledEnd').value = '2025-10-09T12:00';");
        try {
            Thread.sleep(1000); 
         } catch (Exception e) {
            
         }


        WebElement remarks=driver.findElement(By.id("remarks"));
        remarks.sendKeys("Compulsory");
        try {
            Thread.sleep(1000); 
         } catch (Exception e) {
            
         }


        WebElement addStudent=driver.findElement(By.id("addStudent"));
		addStudent.click();
        try {
            Thread.sleep(1000); 
         } catch (Exception e) {
            
         }


         Alert alert1=driver.switchTo().alert();
         alert1.accept();
         try {
            Thread.sleep(1000); 
         } catch (Exception e) {
            
         }



	}

	@AfterClass
	void teardown(){
		driver.quit();
	}

    
}
