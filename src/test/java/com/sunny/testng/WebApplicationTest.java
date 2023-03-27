package com.sunny.testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebApplicationTest {

    @Test
    void testGoogle() throws InterruptedException{
      WebDriverManager.chromedriver().setup();
      WebDriver driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.get("https://www.google.com/");
      driver.findElement(By.name("q")).sendKeys("Apache Commons", Keys.ENTER);
      System.out.println(String.format("Title %s", driver.getTitle()));
      Thread.sleep(3000);
      driver.quit();
    }
}
