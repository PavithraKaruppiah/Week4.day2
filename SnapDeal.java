package week4.day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions options =new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		//Launch https://www.snapdeal.com/
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		
		//Go to Mens Fashion
		WebElement men = driver.findElement(By.xpath("//a[contains(@class,'menuLinks leftCategoriesProduct ')]/span[2]"));		
		Actions builder = new Actions(driver);
		builder.moveToElement(men).perform();
		
		//	3. Go to Sports Shoes
		driver.findElement(By.xpath("//span[contains(text(),'Sports Shoes')]")).click();
		Thread.sleep(3000);
		
		//4. Get the count of the sports shoes
		String txt = driver.findElement(By.xpath("//h1[contains(text(),'Sports Shoes for Men')]/following-sibling::span")).getText();
		System.out.println(txt);
		//5. Click Training shoes
		driver.findElement(By.xpath("//div[contains(text(),'Training Shoes')]")).click();
		//	6. Sort by Low to High
		driver.findElement(By.xpath("//span[contains(text(),'Sort by:')]")).click();
		driver.findElement(By.xpath("//ul[contains(@class,'sort-value')]/li[2]")).click();
		Thread.sleep(2000);
		//7. Check if the items displayed are sorted correctly
		List<WebElement> price = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		List<String> shoe = new ArrayList<String>();
		for (int i = 0; i < price.size(); i++) {
			String text = price.get(i).getText();
			System.out.println(text);
			shoe.add(text);
			String replaceAll = text.replaceAll("\\D", "");
			int parseInt = Integer.parseInt(replaceAll);
			System.out.println(parseInt);
		}
		// 8.Select the price range (900-1200)
		WebElement from = driver.findElement(By.xpath("//input[@name='fromVal']"));
		from.clear();
		from.sendKeys("900");
		WebElement to = driver.findElement(By.xpath("//input[@name='toVal']"));
		to.clear();
		to.sendKeys("1800");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();
		Thread.sleep(2000);
		//click view more
		driver.findElement(By.xpath("//button[@class='view-more-button btn btn-line btn-theme-secondary viewMoreFilter']")).click();
		
			//	9.Filter with color Navy 
		driver.findElement(By.xpath("//input[contains(@id,'Color_s-Navy')]/following::label")).click();
		// 10 verify the all applied filters 
		String pricerange = driver.findElement(By.xpath("(//a[@class='clear-filter-pill'])[1]")).getText();
		System.out.println(pricerange);
		
		String color = driver.findElement(By.xpath("//a[contains(text(),'Navy')]")).getText();
		System.out.println(color);
		
		if (pricerange.contains("900")) {
			System.out.println("Correct Range");
		}
		else {
			System.out.println("IN Correct Range");
		}
		if(color.contains("Navy")) {
			System.out.println("Correct color");
		}
		else {
			System.out.println("IN Correct color");
		}
		
		Thread.sleep(3000);
		
	//	11. Mouse Hover on first resulting Training shoes
	WebElement mousemove = driver.findElement(By.xpath("//p[@class='product-title']"));
	builder.moveToElement(mousemove).perform();
	
	//	12. click QuickView button
	driver.findElement(By.xpath("//div[contains(@class,'center quick-view-bar  btn btn-theme-secondary ')]")).click();
	
	//13. Print the cost and the discount percentage
	Thread.sleep(6000);
	String cost = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
	System.out.println(cost);
	String discount = driver.findElement(By.xpath("//span[contains(@class,'percent-desc')]")).getText();
	System.out.println(discount);
	
	//	14. Take the snapshot of the shoes.
	
	File source = driver.getScreenshotAs(OutputType.FILE);
	File destination = new File("./report/img.png");
	FileUtils.copyFile(source, destination);
	System.out.println("Screenshot taken");
	Thread.sleep(2000);
	//	15. Close the current window
	driver.close();
	// 16. Close the main window
	driver.quit();

	}
	}


