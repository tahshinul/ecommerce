package ecommerce;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.*;

public class ecommerce {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
//		driver.findElements(By.xpath("//h4[@class='product-name']")).getText();
		String names[] = { "Capsicum", "Brocolli", "Cucumber", "Pista", "Brinjal" };

		addToCart(driver, names);
		ProceedToCHeckout(driver);

//		Thread.sleep(1000);
//		driver.quit();
	}

	public static void addToCart(WebDriver driver, String[] names) {
		List<WebElement> x = driver.findElements(By.xpath("//h4[@class='product-name']"));

		for (int i = 0; i < x.size(); i++) {

			String y = x.get(i).getText();

			for (int j = 0; j < names.length; j++) {
				if (y.contains(names[j])) {
					driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
//					System.out.println(y);
					System.out.println();
					System.out.println(names[j]);
					System.out.println(i);
					System.out.println(y);

				}
			}

		}

	}

	public static void ProceedToCHeckout(WebDriver driver) {
		driver.findElement(By.xpath("//a[@class='cart-icon']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("promoBtn")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoInfo")));
		
		
		driver.findElement(By.className("promoInfo")).getText();
		Assert.assertEquals(driver.findElement(By.className("promoInfo")).getText(), "Code applied ..!");
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		
		driver.findElement(By.xpath("//div[@class='wrapperTwo']//div//select")).click();
		driver.findElement(By.xpath("//div[@class='wrapperTwo']//div//select //option[@value='Algeria']")).click();
		driver.findElement(By.xpath("//div[@class='wrapperTwo']//div//select")).click();
	}

}
