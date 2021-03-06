package selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Topic_07_User_Interactions {

    WebDriver driver;
    Actions action;


	@BeforeTest
	public void beforeTest() {
		
		// for chrome
//		System.setProperty("webdriver.chrome.driver",".\\lib\\chromedriver.exe");
//		driver = new ChromeDriver();
//		action = new Actions(driver);
		
		//For firefox
		System.setProperty("webdriver.chrome.driver",".\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		action = new Actions(driver);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	
	@Test (enabled = false)
	public void TC_02_ClickAndHold_Block() throws Exception {
		driver.get("https://jqueryui.com/resources/demos/selectable/display-grid.html");
		List <WebElement> numberItems = driver.findElements(By.xpath("//ol[@id = 'selectable']/li"));
		action.clickAndHold(numberItems.get(0)).moveToElement(numberItems.get(3)).release().perform();
		Thread.sleep(2000);
		
		List <WebElement> numberItemsSelected = driver.findElements(By.xpath("//ol[@id = 'selectable']/li[contains(@class,'ui-selected')]"));
		Assert.assertEquals(numberItemsSelected.size(), 4);	
	}
	
	@Test (enabled = false)
	public void TC_03_ClickAndHold_Random() throws Exception {
		driver.get("https://jqueryui.com/resources/demos/selectable/display-grid.html");
		List <WebElement> numberItems = driver.findElements(By.xpath("//ol[@id = 'selectable']/li"));
		action.keyDown(Keys.CONTROL).perform();
		action.click(numberItems.get(0));
		action.click(numberItems.get(2));
		action.click(numberItems.get(4));
		action.click(numberItems.get(6));
		action.keyUp(Keys.CONTROL).perform();
		Thread.sleep(3000);
		
		List <WebElement> numberItemsSelected = driver.findElements(By.xpath("//ol[@id = 'selectable']/li[contains(@class,'ui-selected')]"));
		Assert.assertEquals(numberItemsSelected.size(), 4);	
	}
	
	@Test (enabled = true)
	public void TC_04_DoubleClick () throws Exception {
		driver.get("http://www.seleniumlearn.com/double-click");
		WebElement doubleClick = driver.findElement(By.xpath("//button[text()='Double-Click Me!']"));
		action.click(doubleClick).perform();
		Thread.sleep(1000);
		
//		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Linux')]")));
		
	}
	
	
	
	@AfterTest
	public void afterTest() {
//		driver.quit();
	}

}





























