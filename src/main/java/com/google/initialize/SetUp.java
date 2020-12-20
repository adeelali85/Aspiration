package com.google.initialize;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;


public class SetUp  {
    
	public static WebDriver driver;
	
		public static void Start() {
		
			System.setProperty("webdriver.chrome.driver",new File(System.getProperty("user.home"), "eclipse-workspace\\GoogleSearch\\src\\main\\java\\com\\google\\driver\\chromedriver.exe").getAbsolutePath());
			driver= new ChromeDriver();
			//driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		    driver.get("https://www.google.com/");
		}

} 
