package swagLab;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class parameters {
	WebDriver driver= new ChromeDriver();
	public void websiteLogin() {
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/inventory.html");
		WebElement userName=driver.findElement(By.id("user-name"));
		WebElement userPassword=driver.findElement(By.id("password"));
		WebElement loginButton=driver.findElement(By.id("login-button"));
		userName.sendKeys("standard_user");
		userPassword.sendKeys("secret_sauce");
		loginButton.click();
	}
	public void sortItemsfunction(WebElement sortingcreteria) throws InterruptedException, IOException {
		WebElement sortCreteria=sortingcreteria;
		Select select = new Select(sortCreteria);
		select.selectByValue("hilo");
		Thread.sleep(1000);
		List <WebElement> addToCartButtons=driver.findElements(By.className("btn"));
		addToCartButtons.get(0).click();
		addToCartButtons.get(addToCartButtons.size()-1).click();
		Date currentDate= new Date();
		String picName=currentDate.toString().replace(":", "-");
		TakesScreenshot  src= ((TakesScreenshot)driver);
		File srcFile= src.getScreenshotAs(OutputType.FILE);
		File destenation= new File("src/screenshot/"+picName+".png");
		FileUtils.copyFile(srcFile, destenation);
		Thread.sleep(2000);
		
		
	}
	public void checkoutProcessFunction() throws InterruptedException {
		WebElement cart=driver.findElement(By.className("shopping_cart_link"));
		cart.click();
		Thread.sleep(2000);
		WebElement checkoutButton=driver.findElement(By.id("checkout"));
		checkoutButton.click();
		Thread.sleep(2000);
		WebElement firstName=driver.findElement(By.id("first-name"));
		WebElement lastName=driver.findElement(By.id("last-name"));
		WebElement postalCode=driver.findElement(By.id("postal-code"));
		WebElement continueButton=driver.findElement(By.id("continue"));
		firstName.sendKeys("leen");
		lastName.sendKeys("omar");
		postalCode.sendKeys("123467890");
		Thread.sleep(2000);
		continueButton.click();
		Thread.sleep(2000);
		WebElement finishButton=driver.findElement(By.id("finish"));
		finishButton.click();
		WebElement ActualMsg=driver.findElement(By.className("complete-header"));
		Assert.assertEquals(ActualMsg.getText().contains("Thank you"),true);
	}
	
	
	
	
	
	
	
	

}
