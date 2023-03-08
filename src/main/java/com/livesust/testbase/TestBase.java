package com.livesust.testbase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.livesust.configuration.CucumberReport;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;

public class TestBase extends CucumberReport{
	public static WebDriver driver;
	public static String AppProperties = System.getProperty("user.dir") + "\\src\\test\\resources\\Config\\config.properties";
	
	public static WebElement getElement(String locator) throws Exception {
		String locatortype, locatorvalue;
		String[] split = locator.split("==");
		locatortype = split[0];
		locatorvalue = split[1];

		switch (locatortype) {
		case "id":
			return driver.findElement(By.id(locatorvalue));
		case "xpath":
			return driver.findElement(By.xpath(locatorvalue));
		default:
			return driver.findElement(By.xpath(locatorvalue));
		}
	}

	public static List<WebElement> getElements(String locator) throws Exception {
		String locatortype, locatorvalue;
		String[] split = locator.split("==");
		locatortype = split[0];
		locatorvalue = split[1];

		switch (locatortype) {
		case "id":
			return driver.findElements(By.id(locatorvalue));
		case "xpath":
			return driver.findElements(By.xpath(locatorvalue));
		default:
			return driver.findElements(By.xpath(locatorvalue));
		}
	}
	public static By getElementBy(String locator) throws IOException  {
		String locatortype, locatorvalue;
		String[] split = locator.split("==");
		locatortype = split[0];
		locatorvalue = split[1];

		switch (locatortype) {
		case "id":
			return By.id(locatorvalue);
		case "xpath":
			return By.xpath(locatorvalue);
		default:
			return By.xpath(locatorvalue);
		}
	}

	public static String PropertyFile(String AppProperties, String locatorfile) throws Throwable {

		Properties Prop = new Properties();
		File Location = new File(locatorfile);
		FileReader File = new FileReader(Location);
		Prop.load(File);
		return Prop.getProperty(AppProperties);
	}

	public static void sendKeystoElement(String locator,String Value) throws Throwable {
		//getElement(locator).clear();
		getElement(locator).sendKeys(Value);
	}

	public static void clickelement(String locator) throws Throwable {
		getElement(locator).click();
	}

	public static void clearkeys(String Locator) throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(getElement(Locator)));
		element.clear();
	}

	public void explicitwaitclickable(String locator) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.elementToBeClickable(getElement(locator)));
	}

	public static void explicitwaitpresence(String locator) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.presenceOfElementLocated(getElementBy(locator)));
	}

	public static void explicitwaitvisible(String locator) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.visibilityOf(getElement(locator)));
	}
	public static void explicitwaitvisibletolocate(String locator) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By) getElement(locator)));
	}
	public static void explicitwaitelementclickable(String locator) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 150);
		wait.until(ExpectedConditions.elementToBeClickable(getElement(locator)));
	}

	// Thread.sleep method for 8 seconds
	public void driverwait(int ms) throws InterruptedException {
		Thread.sleep(ms);
	}

	// Thread.sleep method for seconds
	public void sleepForSeconds(int seconds) throws InterruptedException {
		try {
			Thread.sleep(seconds * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void dropdownlist(String locator,String searchText) throws Exception {

		List<WebElement> p = getElements(locator);
		//iterate through list
		for( WebElement i: p){
		}
		for( WebElement i: p){
			String text =i.getText().trim();
			if (text.equalsIgnoreCase(searchText)){
				i.click(); // click the desired option
				break;
			}
		}
	}

	public void ElementsListClick(String locator,String value) throws Exception {
		try {
			List<WebElement> allrow = getElements(locator);
			int rowcount = allrow.size();
			for (WebElement rows : allrow) {
				String text = rows.getText().toString();
				if(value.equalsIgnoreCase(text)) {
					rows.click();
					break;
				}
			}
		}catch(Exception e) {
			System.out.println("Element is not able to click:"+e);
			Assert.fail("Element is not able to click");
		}
	}

	public void selectDropDownByVisible(String locator, String dropDownValue) throws Exception {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(dropDownValue);
	}

	// select the DropDown By Value
	public void selectDropDownBy(String locator,String dropDownValue) throws Exception {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(dropDownValue);
	}

	public void close() {
		driver.quit();
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static String captureScreenshot() throws IOException {

		File srcFiler = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		byte[] encoded;
		try {
			encoded = Base64.encodeBase64(FileUtils.readFileToByteArray(srcFiler));
			String s = new String(encoded, StandardCharsets.US_ASCII);
			return s;

		} catch (IOException e) {
			e.printStackTrace();

		}
		return null;
	}

	public void scroll(int i, int j) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(i,j)", "");
	}

	public void scriptClick(String locator) throws Exception {
		WebElement element = getElement(locator);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void scriptSendKeys(String locator,String input) throws Exception {
		WebElement element = getElement(locator);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='"+input+"';", element);
	}


	public void scrollVisible(String locator) throws Throwable {

		WebElement element = getElement(locator);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500); 
	}

	public void UploadImage(String locator,String path) throws Throwable {
		WebElement uploadfile = getElement(locator);
		uploadfile.sendKeys(path);
	}

	public void ElementListMatchAssert(String locator,String input) throws Exception{
		try {
			Thread.sleep(2000);
			WebElement value = getElement(locator);
			explicitwaitvisible(locator);
			if(value.isDisplayed()) {
				List<WebElement> allrow = getElements(locator);
				int rowcount = allrow.size();
				for (WebElement rows : allrow) {
					System.out.println("row:"+rows);
					String text = rows.getText().toString();
					if(input.equalsIgnoreCase(text)) {
						String validationText = value.getText().trim();
						System.out.println("error message:"+validationText);
						System.out.println("error message:"+input);	
						Assert.assertEquals(validationText,input);
						System.out.println("Actual Value: " +validationText  + " Expected value: " +input );
						break;
					}
				}}}catch(Exception e) {
					System.out.println("Element is not able to click:"+e);
					Assert.fail("Element is not able to click");
				}
		}
	
	public void ElementsListFindSendkeys(String locator,String value) throws Exception {
		try {
			String var1 ="(//input[@id='phoneNumber'])[";
			String var2="]";
			List<WebElement> allrow = getElements(locator);
			int rowcount = allrow.size();
			String count=Integer.toString(rowcount);
			for (WebElement rows : allrow) {
				String val = var1 + rowcount + var2;
				WebElement ele = driver.findElement(By.xpath(val));
				ele.click();
				ele.sendKeys(value);
			}
		}catch(Exception e) {
			System.out.println("Element is not able to click:"+e);
			Assert.fail("Element is not able to click");
		}
	}

	public void ElementsListFindEmailSendkeys(String locator,String value) throws Exception {
		try {
			String var1 ="(//input[@id='email'])[";
			String var2="]";
			List<WebElement> allrow = getElements(locator);
			int rowcount = allrow.size();
			String count=Integer.toString(rowcount);
			for (WebElement rows : allrow) {
				String val = var1 + rowcount + var2;
				WebElement ele = driver.findElement(By.xpath(val));
				ele.click();
				ele.sendKeys(value);
			}
		}catch(Exception e) {
			System.out.println("Element is not able to click:"+e);
			Assert.fail("Element is not able to click");
		}
	}

}

