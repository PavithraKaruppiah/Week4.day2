package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HWSortable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/sortable.html");
		driver.manage().window().maximize();
		
	WebElement item1 =	driver.findElement(By.xpath("//li[text()='Item 1']"));
	WebElement item5 =	driver.findElement(By.xpath("//li[text()='Item 5']"));
	
	Actions builder = new Actions(driver);
	builder.clickAndHold(item1).moveToElement(item5).release().perform();
	
	
	}

}
