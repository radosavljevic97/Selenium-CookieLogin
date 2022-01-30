package Selenium1401;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

//Zadatak 3 - Ulogovati se na sajt https://demoqa.com/ preko kolacica, izlogovati se i asertovati da je korisnik izlogovan

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/login");


       Cookie kolacic1 = new Cookie("userName", "radosavljevic97");
       driver.manage().addCookie(kolacic1);

       Cookie kolacic2 = new Cookie("userID", "595d6bc3-db9e-4fe7-8e9b-d8eb04956f14");
       driver.manage().addCookie(kolacic2);

       Cookie kolacic3 = new Cookie("expires", "2022-01-23T12%3A50%3A00.455Z");
       driver.manage().addCookie(kolacic3);

       Cookie kolacic4 = new Cookie("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6InJhZG9zYXZsamV2aWM5NyIsInBhc3N3b3JkIjoiJiomc3RlZmFuJiomOTciLCJpYXQiOjE2NDIzMzc0MDB9.GJqlY1V2OWd7z-flwTSmMu2NM7ovvfoFxa4H9pMG4Cs");
       driver.manage().addCookie(kolacic4);
       driver.navigate().refresh();

       WebElement logOutButton = driver.findElement(By.id("submit"));
       wdwait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
       logOutButton.click();


       String actualURL = driver.getCurrentUrl();
       wdwait.until(ExpectedConditions.urlToBe("https://demoqa.com/login"));

       String expectedURL = "https://demoqa.com/login";

        Assert.assertEquals(actualURL, expectedURL);






    }
}
