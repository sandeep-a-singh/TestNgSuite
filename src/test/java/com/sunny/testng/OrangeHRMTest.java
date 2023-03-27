package com.sunny.testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OrangeHRMTest {
  WebDriver driver;

  @Test
  void launchApp() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
  }

  @Test
  void enterLoginDetails() throws InterruptedException{
    Thread.sleep(10000);
    driver.findElement(By.name("username")).sendKeys("Admin");
    driver.findElement(By.name("password")).sendKeys("admin123");
    driver.findElement(By.className("orangehrm-login-button")).click();
  }

  @Test
  void verifyLoggedInSuccessful() {
    System.out.println(driver.findElement(By.className("orangehrm-dashboard-grid")).isDisplayed());
    driver.quit();
  }



}
