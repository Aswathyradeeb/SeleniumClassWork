package org.selenium.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class WebElementsCommands {
	 WebDriver driver= new ChromeDriver();
	    public void verifySingleInputField() {
	    	driver.get("https://selenium.qabible.in/select-input.php");
	    	driver.manage().window().maximize();
	    	WebElement colorDrpdown= driver.findElement(By.xpath("//select[@id='single-input-field']"));
	    	boolean isSelected= colorDrpdown.isSelected();
	    	if(!isSelected) {
	    		System.out.println("Not selected");
	    		Select select= new Select(colorDrpdown); 
	    		select.selectByValue("Red");
	    		isSelected= colorDrpdown.isSelected();
	    		System.out.println("Color Selected: "+select.getFirstSelectedOption());		
	    	}    	
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebElementsCommands obj= new WebElementsCommands();
		obj.verifySingleInputField();
	}

}
