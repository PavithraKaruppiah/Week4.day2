package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HWWebTable_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver webtable = new ChromeDriver();
		webtable.get("http://www.leafground.com/pages/table.html");
		webtable.manage().window().maximize();
		webtable.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Get the count of number of rows
		List<WebElement> row = webtable.findElements(By.xpath("//table//tr"));
		int size = row.size();
		System.out.println(size);

		//Get the count of number of column
		List<WebElement> column = webtable.findElements(By.xpath("//table//th"));
		int size2 = column.size();
		System.out.println(size2);

		//Get the progress value of 'Learn to interact with Elements'
		String element = webtable.findElement(By.xpath("//table//tr[3]/td[2]")).getText();
		System.out.println(element);
		
		//Check the vital task for the least completed progress.
		List<String> progress = new ArrayList<String>();
		for(int i=2; i <= size; i++) {
			String progressValue = webtable.findElement(By.xpath("//table//tr["+i+"]/td[2]")).getText();
			String newValue = progressValue.replaceAll("[%]","");
			progress.add(newValue);
		}
		List<Integer> newList = new ArrayList<Integer>(progress.size());
		for(String myInt : progress) {
			newList.add(Integer.valueOf(myInt));
		}
		//Sort the element
		Collections.sort(newList);
		System.out.println(newList);
		
		//Click the vital
		Integer input = newList.get(0);
		webtable.findElement(By.xpath("//td[contains(text(),'"+input+"')]/following::input")).click();
	}

}
