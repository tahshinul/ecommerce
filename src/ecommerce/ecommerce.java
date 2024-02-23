package ecommerce;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ecommerce {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
//		driver.findElements(By.xpath("//h4[@class='product-name']")).getText();
		String names[] = {"Capsicum","Brocolli","Cucumber","Pista","Brinjal"};
		List<WebElement> x = driver.findElements(By.xpath("//h4[@class='product-name']"));

		for (int i = 0; i < x.size(); i++) {

			String y = x.get(i).getText();

			for (int j = 0; j < names.length; j++) {
				if ( y.contains(names[j])) {
					driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
//					System.out.println(y);
					System.out.println();
					System.out.println(names[j]);
					System.out.println(i);
					System.out.println(y);
							

				}	
			}
			
			
		}
//		Thread.sleep(1000);
//		driver.quit();
	}

}
