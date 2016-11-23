/**
 * Created by ly0w on 23.11.2016.
 */
package org.openqa.selenium.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;
//import java
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxProfile;



public class SeleniumLab2 {
    public static WebDriver newWebDriver()
    {
        File pathToBinary = new File("J:\\Program Files\\Mozilla Firefox42\\firefox.exe");
        //File pathToBinary = new File("J:\\Program Files (x86)\\Firefox Developer Edition\\firefox.exe");
        FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        WebDriver driver = new FirefoxDriver(ffBinary,firefoxProfile);
        return driver;
    }
    public static void main(String[] args) {
        //WebDriver driver = newWebDriver();
        WebDriver driver;
        try {
            driver = new FirefoxDriver();
        }
        catch(Exception e) {
            driver = newWebDriver();
            System.out.println(e);
        }

        driver.get("http://80.92.229.236:81/auth/login");

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("Admin");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("123");

        WebElement buttonLogin = driver.findElement(By.id("logIn"));
        buttonLogin.click();

        String title = driver.getTitle();
        String expectedTitle = "Login";
        if(title.equals(expectedTitle))
            System.out.println("test");
        else
            System.err.println("not work: title - " + title + " <> " + expectedTitle);
        //WebDriver driver = new FirefoxDriver();
        /*driver.get("http://google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Cheese!");
        element.submit();
        System.out.println("Page title is: " + driver.getTitle());
        */
        //driver.
        //driver.quit();
    }
}
