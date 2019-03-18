package selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Topic_04_Part2_Dropdown_CustomDropdown {
	WebDriver driver;
	WebDriverWait waitExplicit;
	JavascriptExecutor javascriptExecutor;
	
  @BeforeTest
  public void beforeTest() {
	  driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  waitExplicit = new WebDriverWait(driver, 30);
	  javascriptExecutor = (JavascriptExecutor) driver;
	  	  
	  }
  
  @Test (enabled = true)
  public void TC_01_Default_Dropdown () throws Exception {	  
  
  driver.get("https://daominhdam.github.io/basic-form/index.html");
  
  WebElement jobRole1 = driver.findElement(By.xpath("//select[@id='job1']"));
  Select jobRoleSelect = new Select(jobRole1);
 
  Assert.assertFalse(jobRoleSelect.isMultiple()); 
  
  jobRoleSelect.selectByVisibleText("Automation Tester");
  Assert.assertEquals(jobRoleSelect.getFirstSelectedOption().getText(), "Automation Tester"); 
  Thread.sleep(2000);
  
  jobRoleSelect.selectByValue("manual");
  Assert.assertEquals(jobRoleSelect.getFirstSelectedOption().getText(), "Manual Tester");
  Thread.sleep(2000);
  
  jobRoleSelect.selectByIndex(3); 
  Assert.assertEquals(jobRoleSelect.getFirstSelectedOption().getText(), "Mobile Tester");
  Assert.assertEquals(jobRoleSelect.getOptions().size(),5); 
  Thread.sleep(2000);

  
  }
  
  @Test (enabled = true)
  public void TC_02_Jquery_Custom_Dropdown () throws Exception {
	  driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
	  
	  selectItem_In_CustomDropdown ("//span[@id='number-button']", "//ul[@id='number-menu']/li[@class='ui-menu-item']/div", "19");
	  Assert.assertTrue(isElementDisplayed("//span[@id='number-button']//span[@class='ui-selectmenu-text' and text()='19']"));
	  
	  selectItem_In_CustomDropdown ("//span[@id='number-button']", "//ul[@id='number-menu']/li[@class='ui-menu-item']/div", "3");
	  Assert.assertTrue(isElementDisplayed("//span[@id='number-button']//span[@class='ui-selectmenu-text' and text()='3']"));
	  
	  selectItem_In_CustomDropdown ("//span[@id='number-button']", "//ul[@id='number-menu']/li[@class='ui-menu-item']/div", "16");
	  Assert.assertTrue(isElementDisplayed("//span[@id='number-button']//span[@class='ui-selectmenu-text' and text()='16']"));
	  
  }
  
  @Test (enabled = true)
  public void TC_03_Angular_Custom_Dropdown () throws Exception {
	  driver.get("https://material.angular.io/components/select/examples");
	  
	  selectItem_In_CustomDropdown ("//mat-select[@placeholder='State']", "//mat-option/span", "Hawaii");
	  Assert.assertTrue(isElementDisplayed("//mat-select[@placeholder='State']//span[text()='Hawaii']"));
	  
	  selectItem_In_CustomDropdown ("//mat-select[@placeholder='State']", "//mat-option/span", "Alaska");
	  Assert.assertTrue(isElementDisplayed("//mat-select[@placeholder='State']//span[text()='Alaska']"));
	  
	  selectItem_In_CustomDropdown ("//mat-select[@placeholder='State']", "//mat-option/span", "New York");
	  Assert.assertTrue(isElementDisplayed("//mat-select[@placeholder='State']//span[text()='New York']"));
	  
  }
  
  @Test (enabled = true)
  public void TC_04_Telerik_Custom_Dropdown () throws Exception {
	  driver.get("https://demos.telerik.com/kendo-ui/dropdownlist/index");
	    
	  selectItem_In_CustomDropdown("//span[@aria-owns='color_listbox']", "//ul[@id='color_listbox']/child::li", "Orange");
	  Assert.assertTrue(isElementDisplayed("//input[@id='color']/preceding-sibling::span/span[text()='Orange']"));	  
	  
	  selectItem_In_CustomDropdown("//span[@aria-owns='color_listbox']", "//ul[@id='color_listbox']/child::li", "Black");
	  Assert.assertTrue(isElementDisplayed("//input[@id='color']/preceding-sibling::span/span[text()='Black']"));	 
	  
	  selectItem_In_CustomDropdown("//span[@aria-owns='color_listbox']", "//ul[@id='color_listbox']/child::li", "Grey");
	  Assert.assertTrue(isElementDisplayed("//input[@id='color']/preceding-sibling::span/span[text()='Grey']"));	

	  
  }
  
  @Test (enabled = true)
  public void TC_05_Vue_Custom_Dropdown () throws Exception {
	  driver.get("https://mikerodham.github.io/vue-dropdowns/");
	  
	  
	  selectItem_In_CustomDropdown("//li[@class='dropdown-toggle']", "//ul[@class='dropdown-menu']/li/a", "Second Option");
	  Assert.assertTrue(isElementDisplayed("//li[@class='dropdown-toggle' and contains(text(),'Second Option')]"));	  
	  
	  selectItem_In_CustomDropdown("//li[@class='dropdown-toggle']", "//ul[@class='dropdown-menu']/li/a", "First Option");
	  Assert.assertTrue(isElementDisplayed("//li[@class='dropdown-toggle' and contains(text(),'First Option')]"));	 
	  
	  selectItem_In_CustomDropdown("//li[@class='dropdown-toggle']", "//ul[@class='dropdown-menu']/li/a", "Third Option");
	  Assert.assertTrue(isElementDisplayed("//li[@class='dropdown-toggle' and contains(text(),'Third Option')]"));	  	

	  
  }
  
	  
  
  @Test (enabled = true)
  public void TC_06_Custom_Dropdown_Indrimuska_Editable() throws Exception {
	  driver.get("https://indrimuska.github.io/jquery-editable-select/");
	  selectItem_In_CustomDropdown ("//div[@id='default-place']/input", "//div[@id='default-place']//li", "Land Rover");
	  Thread.sleep(5000);
	  Assert.assertTrue(isElementDisplayed("//div[@id='default-place']//li[@class='es-visible' and contains(text(),'Land Rover')]/parent::ul/preceding-sibling::input"));	
	  
  }
  
  @Test (enabled = true)
  public void TC_07_Multiple_Dropdown() throws Exception {
		driver.get("https://multiple-select.wenzhixin.net.cn/examples/#basic.html");
		String [] items = {"February", "December", "April"};
		String [] newItems = {"February", "December", "April", "November", "January"};
		
		By iframeXpath = By.xpath("//div[@class='content']//iframe");
		WebElement iframe = driver.findElement(iframeXpath);
		driver.switchTo().frame(iframe);
		selectMulti_Item_In_CustomDropdown("//button[@class='ms-choice']", "//div[@class='ms-drop bottom']//span", items);
		Assert.assertTrue(check_Item_Selected(items));
		
		
		driver.navigate().refresh();
		WebElement iframe_new = driver.findElement(iframeXpath);
		driver.switchTo().frame(iframe_new);
		selectMulti_Item_In_CustomDropdown("//button[@class='ms-choice']", "//div[@class='ms-drop bottom']//span", newItems);
		Assert.assertTrue(check_Item_Selected(newItems));

  }

  
  public void selectItem_In_CustomDropdown (String parent_Xpath, String all_Item_Xpath, String expected_Item) throws Exception {
  
	  WebElement parentDropdown = driver.findElement(By.xpath(parent_Xpath));
	  //1- click on dropdown by javascriptExecutor
	  javascriptExecutor.executeScript("arguments[0].click();", parentDropdown);
	  
	  // 2- Wait for dropdown loads all items
	  waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(all_Item_Xpath)));
	  
	  List <WebElement> all_Item = driver.findElements(By.xpath(all_Item_Xpath));
	  System.out.println("all items in dropdown: " + all_Item.size());
	  
	  for (WebElement childElement : all_Item) {
		  System.out.println("Each Time get Text: " + childElement.getText());  
		  if (childElement.getText().equals(expected_Item)) {			  
			  // 3 - scroll to expected item
			  javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", childElement);
			  Thread.sleep(1000);
			  if (childElement.isDisplayed()) {
				  childElement.click();
			  } else {
				  javascriptExecutor.executeScript("arguments[0].click();", childElement);
			  }
			  Thread.sleep(1000);
			  break;
		  }
		  
	  }	  
  }


  
  public boolean isElementDisplayed (String valueXpath) {
	  WebElement element = driver.findElement(By.xpath(valueXpath));
	  if (element.isDisplayed()) {
		  System.out.println("item is displayed successfully");
		 		  return true;
	  }
	  else {
		  System.out.println("item is not displayed");
		  return false;
	  }	  
  }
  
  public void selectMulti_Item_In_CustomDropdown (String parent_Xpath, String all_Item_Xpath, String [] expected_Item) throws Exception {
	  WebElement parentDropdown = driver.findElement(By.xpath(parent_Xpath));
	  //1- click on dropdown by javascriptExecutor
	  javascriptExecutor.executeScript("arguments[0].click();", parentDropdown);
	  
	  // 2- Wait for dropdown loads all items
	  waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(all_Item_Xpath)));
	  
	  List <WebElement> all_Item = driver.findElements(By.xpath(all_Item_Xpath));
	  System.out.println("all items in dropdown: " + all_Item.size());
	  
	  for (WebElement childElement : all_Item) {
		  for (String item : expected_Item) {
			  if (childElement.getText().equals(item)) {
				  javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", childElement);
				  Thread.sleep(1500);
				  javascriptExecutor.executeScript("arguments[0].click();", childElement);
				  Thread.sleep(1500);
				  
				  //Khai báo Element Xpath của các items đã được chọn
				  List<WebElement> itemSelected = driver.findElements(By.xpath("//li[@class='selected']//input"));
				  System.out.println("Number of item selected = " + itemSelected.size());
				  
				  // Nếu số lượng item dda chọn đã đủ -> break vòng lặp
				  if(expected_Item.length == itemSelected.size()) {
					  break;
				  }
				  
			  }

		  }
		  
	  }
	
	  
  }
  public boolean check_Item_Selected (String [] item_Selected_Text) {
	  List<WebElement> itemSelected = driver.findElements(By.xpath("//li[@class='selected']//input"));
	  int number_ItemSelected = itemSelected.size();
	  String all_item_Selected_Text = driver.findElement(By.xpath("//button[@class='ms-choice']/span")).getText();
	  System.out.println("Text da chon: " + all_item_Selected_Text );
	  if (number_ItemSelected <= 3 && number_ItemSelected > 0) {
		  for (String item : item_Selected_Text) {
			  if (all_item_Selected_Text.contains(item)) {
				  break;
			  }
		  }
		  return true;
	  }
	  else {
		  return driver.findElement(By.xpath("//button[@class='ms-choice']/span[text()='" + number_ItemSelected + " of 12 selected']")).isDisplayed();
	  }
	  
	  
  }
  
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}