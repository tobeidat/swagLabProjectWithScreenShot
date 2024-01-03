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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testCases extends parameters {
	
	@BeforeTest
	public void Setup()
	{
		websiteLogin();
		
	}
	@Test(priority = 1)
	public void sortItems() throws IOException, InterruptedException
	{
		sortItemsfunction(driver.findElement(By.className("product_sort_container")));
		
	}
	@Test(priority = 2)
	public void checkout() throws InterruptedException {
		checkoutProcessFunction();   
		
		
		
		
	}
	
	

}
