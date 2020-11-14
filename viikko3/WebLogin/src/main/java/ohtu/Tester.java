package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Random;

public class Tester {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:4567");
        System.out.println(driver.getPageSource());
        
        sleep(2);
        
       /* WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        System.out.println(driver.getPageSource());

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();

        sleep(3); */
        Random r = new Random();

        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();

        System.out.println(driver.getPageSource());

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekkakkk");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkeppekka89");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("akkeppekka89");
        sleep(1);
        element = driver.findElement(By.name("signup"));
        sleep(1);
        element.submit();
        sleep(1);
        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        sleep(1);
        element = driver.findElement(By.linkText("logout"));
        sleep(1);
        element.click();
        sleep(1);
        driver.quit();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
