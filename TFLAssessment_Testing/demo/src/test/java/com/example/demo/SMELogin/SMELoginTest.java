package com.example.demo.SMELogin;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterClass;
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

	@Test
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
		wait.until(ExpectedConditions.urlContains("/Student/student.html"));

		// WebElement getAll=driver.findElement(By.id("TestList"));
		// getAll.click();
		// assertTrue(driver.getCurrentUrl().contains("/Student/student.html#"),"Unable to open next page");

		// WebElement detailsButton = driver.findElement(By.className("detailsBtn"));
        // detailsButton.click();
		// wait.until(ExpectedConditions.urlContains("/Student/student.html#"));

		// WebElement startTest = driver.findElement(By.className("startBtn"));
		// startTest.click();		
	}

	@AfterClass
	void teardown(){
		driver.quit();
	}

    
}
