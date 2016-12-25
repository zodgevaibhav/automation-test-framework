package com.web.webdriver_factory;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverManager {
	
	protected static WebDriver CreateInstance() throws MalformedURLException{
		WebDriver dr;
		dr = new RemoteWebDriver(new URL(getDerivedHubUrl()),getDerivedCapabilities());		
		return dr;
	}
	
	private static DesiredCapabilities getDerivedCapabilities(){
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("deviceName", "Emulator");
			capabilities.setCapability("app", getApplicationFile().getAbsolutePath());
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("appPackage", "com.vuclip.viu");    // this needs to parameterize (maven/jenkins-String parameter) to support multiple app automation
			capabilities.setCapability("appActivity", "com.vuclip.viu.ui.screens.MainActivity");
		return capabilities;		
	}

private static String getDerivedHubUrl(){
		String hubURL = null;
			hubURL  = "http://127.0.0.1:5723/wd/hub";  // this need to parameterized if using same framework for Web and Mobile 
		return hubURL;		
	}

private static File getApplicationFile(){
	File file = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\viu.apk");  //apk file name needs to parameterize maven/jenkins
	return file;	
}

}
