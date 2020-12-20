package com.google.testexecution;


import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.google.initialize.SetUp;
import com.api.rest.GetCall;


	public class Test extends SetUp{

		
		
		public static void main (String[] args) throws InterruptedException  {
		
			Start();
			
		System.out.println("********************Test Case 1*************************");	
			WebElement search=driver.findElement(By.name("q"));
			driver.findElement(By.name("q"));
		    search.sendKeys("rubber-duck");
		    
		    // Explicit wait condition for search results
		    WebDriverWait w = new WebDriverWait(driver, 5);
		    w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul")));
		    
		    search.submit();
		    
		   if (existsElement()) {System.out.println("Found rubber-duck. Test Case1 Passed");}
			else {System.out.println("Test Case1 Failed");}
		   
		   System.out.println("********************Test Case 2*************************");	   
		   
		   GetCall.getCall();
		    
		    driver.close();
			
		}

		private static boolean existsElement() {
		    try {driver.findElement(By.xpath("//span[text()='rubber ducks - Amazon.com']"));} 
		    catch (NoSuchElementException e) {return false;}
		    return true;
		}
	
	}