package com.web.webdriver_factory;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
	
	public static WebDriver webDriver;
	
	public static WebDriver getDriver(){
		return webDriver;		
	}
	public void setDriver() throws MalformedURLException{
		webDriver = WebDriverManager.CreateInstance();
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
