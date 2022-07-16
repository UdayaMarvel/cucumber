package amazon;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class simpleJunitProject {


	public static WebDriver driver;
	public static JavascriptExecutor j;
	

	@BeforeClass
	public static void launch()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("http://amazon.com");
		j = (JavascriptExecutor)driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void method1()
	{
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("redmi 10");
		WebElement go = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		go.click();
	}
	@Test
	public void method2() {
		WebElement xiaomi = driver.findElement(By.xpath("(//span[contains(text(),'Xiaomi')])[1]"));
		xiaomi.click();
	}
	
	@Test
	public void method3() {
		WebElement output = driver.findElement(By.xpath("(//span[@id='price_inside_buybox_badge']"));
		double d = 214.99;
		String text = output.getText();
		double price = Double.parseDouble(text);
		assertEquals(price, d);
	}
	@Test
	public void method4() {
		WebElement addcart = driver.findElement(By.xpath("(//input[@type='submit'])[25]"));
		j.executeScript("arguments[0].scrollIntoView(true)", addcart);
		addcart.click();
	}
	@Test
	public void method5() {
		WebElement checkout = driver.findElement(By.name("proceedToRetailCheckout"));
		checkout.click();
	}
	@Test
	public void method6() {
		WebElement mail = driver.findElement(By.name("email"));
		mail.sendKeys("maximoff");
		WebElement continu = driver.findElement(By.id("continue"));
		continu.click();
	}
	
	
	@AfterClass
	public static void exit() {
		//driver.quit();
	}



}




