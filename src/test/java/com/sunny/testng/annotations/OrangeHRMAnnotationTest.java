package com.sunny.testng.annotations;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class OrangeHRMAnnotationTest {
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
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    System.out.println("launchApp()");
  }

  @Test
  void enterLoginDetails() throws InterruptedException{
    Thread.sleep(4000);
    driver.findElement(By.name("username")).sendKeys("Admin");
    driver.findElement(By.name("password")).sendKeys("admin23");
    driver.findElement(By.className("orangehrm-login-button")).click();
    System.out.println("enterLoginDetails()");
  }

  @Test
  void verifyLogin() throws InterruptedException{
    Thread.sleep(4000);
    List<WebElement> webElements = driver.findElements(By.className("oxd-layout-navigation"));
    System.out.println(webElements);
//    Assert.assertTrue(webElement.isDisplayed(), "Unable to get App");
    //Assert.assertTrue(driver.findElement(By.className("orangehrm-dashboard-grid")).isDisplayed(), "Unable to get dashboard");
  }

  @AfterSuite
  void destroy() {
    driver.quit();
  }

}
