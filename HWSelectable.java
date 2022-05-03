package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HWSelectable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/selectable.html");
		driver.manage().window().maximize();
		//select 1 to 6
		//WebElement item1 =driver.findElement(By.xpath("//li[text()='Item 1']"));
		//WebElement item6 =driver.findElement(By.xpath("//li[text()='Item 6']"));
		
		//Actions builder =new Actions(driver);
		//builder.clickAndHold(item1).moveToElement(item6).perform();
		
		//select 1,3,5&7
		
		WebElement item1 =driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement item3 =driver.findElement(By.xpath("//li[text()='Item 3']"));
		WebElement item5 =driver.findElement(By.xpath("//li[text()='Item 5']"));
		WebElement item7 =driver.findElement(By.xpath("//li[text()='Item 7']"));
		
		Actions builder =new Actions(driver);
		builder.keyDown(Keys.CONTROL).click(item1).click(item3).click(item5).click(item7).keyUp(Keys.CONTROL).perform();
		
		
		
	}

}
