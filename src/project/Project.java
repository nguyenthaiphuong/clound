/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
import com.sun.glass.ui.View.Capability;
import java.awt.List;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.JFrame;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
/**
 *
 * @author ntphuong
 */
public class Project  {
    static WebDriver driver  = null;
    static boolean flag_wait = false;
    public static void main(String[] args) throws InterruptedException {
      //String path = System.getProperty("user.dir");
      System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
      driver = new ChromeDriver();
      for(int i = 0; i< 3; i++ ) {
          runIclound(driver);
      }
    }
    
    public static void runIclound(WebDriver driver) {
     // project.Start(chrome, "ntphuong");
     try {
         driver.get("https://appleid.apple.com/account#!&page=create");
      waitForLoad(driver);
      String name = driver.getCurrentUrl();
      
      WebElement firstName = driver.findElement(By.xpath("//input[@placeholder='first name']"));
      firstName.sendKeys("Steven");
      WebElement lastName = driver.findElement(By.xpath("//input[@placeholder='last name']"));
      lastName.sendKeys("James");
      Select country = new Select(driver.findElement(By.xpath("//select[@id='countryOptions']")));
      country.selectByVisibleText("Australia"); 
      WebElement birthDay = driver.findElement(By.xpath("//input[@placeholder='birthday']"));
      birthDay.sendKeys("02/05/1990");
      WebElement email = driver.findElement(By.xpath("//input[@placeholder='name@example.com']"));
      email.sendKeys("thaiphuong11dt123@gmail.com");
      WebElement password = driver.findElement(By.xpath("//input[@placeholder='password']"));
      password.sendKeys("Zxcv123123");
      WebElement passwordConfirm = driver.findElement(By.xpath("//input[@placeholder='confirm password']"));
      passwordConfirm.sendKeys("Zxcv123123");
      ArrayList<WebElement> listQuestion =  (ArrayList<WebElement>) driver.findElements(By.className("content-dropdown"));
      ArrayList<WebElement> listAnwser = (ArrayList<WebElement>) driver.findElements(By.xpath("//input[@placeholder='answer']"));
      Select question1 =new Select(listQuestion.get(0));
      question1.selectByValue("131");
      listAnwser.get(0).sendKeys("steven");
      Select question2 =new Select(listQuestion.get(2));
      question2.selectByValue("137");
      listAnwser.get(1).sendKeys("james");
      Select question3 =new Select(listQuestion.get(4));
      question3.selectByValue("143");
      listAnwser.get(2).sendKeys("steven james");
      WebElement checkbox1 = driver.findElement(By.xpath("//input[@id='news']"));  
      checkbox1.isSelected();
      WebElement checkbox2 = driver.findElement(By.xpath("//input[@id='itunes']"));  
      checkbox2.isSelected();
      WebElement checkbox3 = driver.findElement(By.xpath("//input[@id='appleNews']")); 
      checkbox3.isSelected();
      WebElement captcha = driver.findElement(By.xpath("//input[@placeholder='Type the characters in the image']"));
      captcha.sendKeys("hello");
      WebElement submit = driver.findElement(By.className("overflow-text"));
      submit.click();
     } catch(Exception e) {
         System.out.println("cho lau qua");
     }
    }
     public static void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }
}
