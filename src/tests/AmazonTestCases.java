package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.TestConstants;

public class AmazonTestCases {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", TestConstants.CHROME_PATH);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		

	}

//	@Test
	public void test1() throws InterruptedException {
		driver.get(TestConstants.WEB_URL);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Selenium cookbook" + Keys.ENTER);
		WebElement element = driver.findElement(By.id("s-result-count"));
		String count = element.getText();
		count = count.substring(0, 2);
		int num1 = Integer.parseInt(count);
		driver.findElement(By.linkText("Books")).click();
		Thread.sleep(1000);
		WebElement element2 = driver.findElement(By.id("s-result-count"));
		String count2 = element2.getText();
		int num2 = Integer.parseInt(count2.substring(0, 1));
		assertTrue(num1 > num2);
		driver.findElement(By.linkText("Any Category")).click();
		WebElement element3 = driver.findElement(By.id("s-result-count"));
		String count3 = element3.getText();
		int num3 = Integer.parseInt(count3.substring(0, 2));
		assertEquals(num1, num3);
	}
	
	@Test
	public void test2() {
		driver.get(TestConstants.WEB_URL);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Selenium cookbook" + Keys.ENTER);
		WebElement element = driver.findElement(By.xpath("(//span[@class='sx-price sx-price-large'])[1]"));
		String str = element.getText();
		System.out.println(str);
	}
}
