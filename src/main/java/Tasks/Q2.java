package Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Q2 {
	
    public static void main(String[] args) throws InterruptedException {
    	
    	WebDriverManager.chromedriver().setup();
    	
    	WebDriver driver = new ChromeDriver();
    	
    	driver.manage().window().maximize();
    	
    	driver.get("https://jqueryui.com/droppable/");
    	
    	driver.switchTo().frame(0);
    	
    	WebElement draggable = driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
    	WebElement droppable = driver.findElement(By.xpath("//*[@id=\"droppable\"]"));
    	
    	Actions act = new Actions(driver);
    	act.dragAndDrop(draggable, droppable).perform();
    	
    	WebElement bColor = driver.findElement(By.cssSelector("#droppable"));
    	String color = bColor.getCssValue("background-color");
    	System.out.println(color);
    	
    	WebElement txt = driver.findElement(By.xpath("//p[normalize-space()='Dropped!']"));
    	String s = txt.getText();
    	
    	if(s == "Dropped!") {
    		System.out.println("Drop Down succussfully completed");
    	}
    	else {
    		System.out.println("Drop Down has failed");
    	}
    	
    	driver.quit();
    	
    }

}
