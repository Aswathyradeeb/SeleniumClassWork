package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class RegisterPageTest extends Base {
    public void VerifyRegisterPageTitle() {
		//assertion
	}
    
    @Test
    
    public void VerifyUserRegister() throws IOException {
		
    	driver.get("https://demowebshop.tricentis.com/register");
    	String firstName= RandomDataUtility.getFirstName();
    	String lastName=RandomDataUtility.getLastName();
    	String emailId=firstName+lastName+"@gmail.com";
    	String password=firstName+lastName;
    	driver.get("https://demowebshop.tricentis.com/register");
    	
    	WebElement firstNameField= driver.findElement(By.id("FirstName"));
    	firstNameField.sendKeys(firstName);
    	WebElement lastNameField= driver.findElement(By.id("LastName"));
    	lastNameField.sendKeys(lastName);
    	WebElement emailField= driver.findElement(By.id("Email"));
    	emailField.sendKeys(emailId);
    	WebElement passwordField= driver.findElement(By.id("Password"));
    	passwordField.sendKeys(password);
    	WebElement cpasswordField= driver.findElement(By.id("ConfirmPassword"));
    	cpasswordField.sendKeys(password);
    	
    	driver.findElement(By.id("register-button")).click();
    	
    	WebElement registrationStatus=driver.findElement(By.xpath("//div[@class=\"result\"]"));
    	String actualText=registrationStatus.getText();
    	String expectedText= ExcelUtility.getStringData(0, 5, "Register");
    	Assert.assertEquals(actualText,expectedText,"STATUS MISMATCH");
	}
}
