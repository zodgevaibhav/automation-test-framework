package com.viu.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.viu.common.WebDriverUtility;
import com.web.webdriver_factory.WebDriverFactory;

public class PlayVideoPage {
	
	@FindBy(xpath="//*[@resource-id='com.vuclip.viu:id/v_detail_img_thumb']")
	private WebElement playFirstVideoFromScreen;
	
	@FindBy(xpath="//*[@text='Go for it. Download it here.']")
	private WebElement goForItDownloadTip;	

	@FindBy(xpath="//*[@resource-id='com.vuclip.viu:id/rlParentForAnimate']")
	private WebElement screenContainer;		
		
	public PlayVideoPage(){
		PageFactory.initElements(WebDriverFactory.getDriver(), this);
	}

	
	public PlayVideoPage isPageLoaded(){
		if(WebDriverUtility.waitForPageElement(goForItDownloadTip)){
			return this;
		}else{
			return null;
		}
	}
	
	public PlayVideoPage closeGoForItDownloadTip(){		
		//screenContainer.click();
		WebDriverFactory.getDriver().navigate().back();
		return this;
	}
	
	public VideoPlayerPage playSelectedVideo(){
		playFirstVideoFromScreen.click();
		return new VideoPlayerPage().isPageLoaded();
	}
}
