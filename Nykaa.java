package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Go to https://www.nykaa.com/
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		
		//Mouseover on Brands and Search L'Oreal Paris	
		WebElement brand = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions builder= new Actions(driver);
		builder.moveToElement(brand).perform();
	
		//Click L'Oreal Paris
		driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris");
		driver.findElement(By.xpath("//div[@id='list_L']/following::a")).click();
		
		//Check the title contains L'Oreal Paris(Hint-GetTitle)
		String title = driver.getTitle();
		System.out.println(title);
		
		if (title.contains("L'Oreal Paris")) {
			System.out.println("Correct");
		}
			else {
				System.out.println("in Correct");
	
		}
	
		//Click sort By and select customer top rated
		driver.findElement(By.xpath("//span[contains(text(),'Sort By')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'top rated')]")).click();
		Thread.sleep(1000);
		
		//Click Category and click Hair->Click haircare->Shampoo
		driver.findElement(By.xpath("//span[contains(text(),'Category')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Hair')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Hair Care')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Shampoo')]")).click();
	
		//Click->Concern->Color Protection
	
		driver.findElement(By.xpath("//span[contains(text(),'Concern')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Color Protection')]")).click();
	
	//check whether the Filter is applied with Shampoo
	String text =driver.findElement(By.xpath("//span[contains(text(),'Shampoo')]")).getText();
	System.out.println(text);
	if(text.contains("Shampoo")){
		System.out.println("Filter is for Shampoo");
	}
	else
	{
		System.out.println("Filter is not for Shampoo");
	}
	
	// Click on L'Oreal Paris Colour Protect Shampoo
	driver.findElement(By.xpath("//div[contains(text(),'Oreal Paris Colour Protect Shampoo')]")).click();
	
	//GO to the new window and select size as 175ml
	
	Set<String> set = driver.getWindowHandles();
	List<String> list = new ArrayList<String>(set);
	driver.switchTo().window(list.get(1));
	
	//select size
	
	WebElement size = driver.findElement(By.xpath("//select[contains(@title, 'SIZE')]"));
	Select drop =new Select(size);
	drop.selectByVisibleText("175ml");
	
	
	//Print the MRP of the product
	String text2 = driver.findElement(By.xpath("//span[contains(text(),'MRP:')]")).getText();
	String replaceAll = text2.replaceAll("\\D", "");
	int grandt = Integer.parseInt(replaceAll);
	System.out.println(grandt);
	
	//Click on ADD to BAG
	driver.findElement(By.xpath("//span[contains(text(),'ADD TO BAG')]")).click();
	Thread.sleep(2000);
	//Go to Shopping Bag 
	driver.findElement(By.xpath("//span[contains(text(),'Account')]/following::span")).click();
	Thread.sleep(5000);

	//Print the Grand Total amount
	driver.switchTo().frame(0);
	String text3 = driver.findElement(By.xpath("//div[contains(@class,'first-col')]")).getText();
	String cart = text3.replaceAll("\\D", "");
	int grandt2 = Integer.parseInt(cart);
	System.out.println(grandt2);
	 //Click Proceed
	driver.findElement(By.xpath("//span[contains(text(),'PROCEED')]")).click();
	driver.switchTo().defaultContent();
	 //Click on Continue as Guest
	driver.findElement(By.xpath("//button[contains(text(),'CONTINUE AS GUEST')]")).click();
	
	//Check if this grand total is the same in step 14
	String text4 = driver.findElement(By.xpath("//div[contains(text(),'Grand Total')]/following::div[1]")).getText();
	String replaceAll2 = text4.replaceAll("\\D", "");
	int grandt1 = Integer.parseInt(replaceAll2);
	System.out.println(grandt1);
	if (grandt1 == grandt ) {
		System.out.println("both rate are same");}
	
		else {
			System.out.println("both rate are not same");
		}
		
	}
	}
	

