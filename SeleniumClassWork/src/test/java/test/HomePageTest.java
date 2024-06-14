package test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import utilities.ExcelUtility;

public class HomePageTest extends Base  {
@Test

	public void VerifyHomPageTitle() throws IOException {
	    driver.get("https://demowebshop.tricentis.com/");
		String actualTitle= driver.getTitle();
		String expectedTitle=ExcelUtility.getStringData(0, 0, "Sheet1");
		System.out.println("Title : "+expectedTitle);
		Assert.assertEquals(actualTitle, expectedTitle,"Failed: Title different");
	}
@Test

    public void VerifyCommunityPoolSelection() {
	    driver.get("https://demowebshop.tricentis.com/");
	    WebElement goodOption=driver.findElement(By.xpath("//input[@id='pollanswers-2']"));
	    JavascriptExecutor js= (JavascriptExecutor) driver;
	    js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    	List<WebElement> radioOptions= driver.findElements(By.xpath("//input[@type='radio']")); 	
    		radioOptions.forEach(options -> {
    		    if(options.getText().equals("Good")) {
    		    	WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
    		         wait.until(ExpectedConditions.elementToBeClickable(options));
    		         options.click();
    		    }
    		});
    		
    		boolean status=goodOption.isSelected(); 
    		Assert.assertTrue(status,"Failed: not selected");
		//loop through elements, if good then click
    	//use assertion to check if the option button selected
}

}
