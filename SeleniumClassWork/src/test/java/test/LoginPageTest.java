package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import dataprovider.DataProviders;
import listners.RetryAnalyser;
import utilities.ExcelUtility;

public class LoginPageTest extends Base {
	
	@Test(priority=2,retryAnalyzer= RetryAnalyser.class )
	
    public void VerifyLoginPageTitle() {
    	driver.get("https://demowebshop.tricentis.com/login");
    	String actualTitle= driver.getTitle();
		String expectedTitle="Demo Web Shop";
		Assert.assertEquals(actualTitle, expectedTitle,"Failed: Title different");
	}
    @Test(priority=1)
    
    public void VerifyUserLogin() throws IOException {
		//assertion - after login check the email displayed is the userId
    	//invalid login and email
    	driver.get("https://demowebshop.tricentis.com/login");

		WebElement emailField=driver.findElement(By.id("Email"));
		emailField.sendKeys(ExcelUtility.getStringData(0, 0, "Login"));
		WebElement passwordField=driver.findElement(By.id("Password"));
		passwordField.sendKeys(ExcelUtility.getStringData(1, 0, "Login"));
		WebElement loginButton1= driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input"));
		loginButton1.click();	
	}
    
    @Test(priority=3,dataProvider="InvalidDataCredentials",dataProviderClass= DataProviders.class)
    public void verifyUserLoginWithInvalidUserCredentials(String Username,String Password) throws IOException {
    	driver.get("https://demowebshop.tricentis.com/login");
    	WebElement emailField=driver.findElement(By.id("Email"));
		emailField.sendKeys(Username);
		WebElement passwordField=driver.findElement(By.id("Password"));
		passwordField.sendKeys(Password);
		WebElement loginButton1= driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input"));
		loginButton1.click();
		
		WebElement textField= driver.findElement(By.xpath("//span[text()='Login was unsuccessful. Please correct the errors and try again.']"));
		String actualMsg= textField.getText();
		String expectedErrorMsg= ExcelUtility.getStringData(2, 0, "Login");
		Assert.assertEquals(actualMsg,expectedErrorMsg,"Login Successfull");
    }
    public void VerifyUserLoginPageWithInvalidCredentials() {
		//assertion
    	WebElement loginButton= driver.findElement(By.cssSelector("#Email"));
		loginButton.click();
		WebElement emailField=driver.findElement(By.id("Email"));
		emailField.sendKeys("tom@gmail.com");
		WebElement passwordField=driver.findElement(By.id("Password"));
		passwordField.sendKeys("123456789!");
		WebElement loginButton1= driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input"));
		loginButton1.click();
		
	}
   
}
