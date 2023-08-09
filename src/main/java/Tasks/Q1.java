package Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q1 {
    public static void main(String[] args) throws InterruptedException {

    	WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        
        driver.manage().window().maximize();

        driver.get("https://www.facebook.com");

        if (driver.getCurrentUrl().equals("https://www.facebook.com/")) {
            System.out.println("Successfully redirected to Facebook homepage.");
        } else {
            System.out.println("Redirection to Facebook homepage failed.");
            driver.quit();
            return;
        }
        
        driver.findElement(By.xpath("//*[text()='Create new account']")).click();
        
        Thread.sleep(3000);
        
        driver.findElement(By.name("firstname")).sendKeys("Test");
        driver.findElement(By.name("lastname")).sendKeys("User");
        driver.findElement(By.name("reg_email__")).sendKeys("vitofe3984@touchend.com");
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("vitofe3984@touchend.com");
        driver.findElement(By.name("reg_passwd__")).sendKeys("StrongPassword123");

        Select dayDropdown = new Select(driver.findElement(By.id("day")));
        dayDropdown.selectByVisibleText("11");
        Select monthDropdown = new Select(driver.findElement(By.id("month")));
        monthDropdown.selectByVisibleText("May");
        Select yearDropdown = new Select(driver.findElement(By.id("year")));
        yearDropdown.selectByVisibleText("1985");

        driver.findElement(By.cssSelector("input[name='sex'][value='2']")).click();

        driver.findElement(By.name("websubmit")).click();

        if (driver.getCurrentUrl().contains("https://www.facebook.com/checkpoint/1501092823525282/?next=https%3A%2F%2Fwww.facebook.com%2F&__req=7")) {
            System.out.println("Successfully registered and redirected to Facebook homepage.");
        } else {
            System.out.println("Registration process failed.");
        }

        driver.quit();
    }
}
