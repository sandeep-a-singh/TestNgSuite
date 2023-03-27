package com.sunny.testng.annotations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class GoogleAnnotationTest {
  WebDriver driver;

  @BeforeSuite
  void init() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();

    System.out.println("Init()");
  }


  @Test
  void launchApp() {
    driver.get("https://www.google.com/");
  }

  @Test
  void search() throws InterruptedException {
    Thread.sleep(2000);
    driver.findElement(By.name("q")).sendKeys("facebook", Keys.ENTER);
  }

  @Test
  void verifyResult() throws InterruptedException{
    Thread.sleep(4000);
    System.out.println(driver.findElement(By.className("appbar")).isDisplayed());
  }


}
