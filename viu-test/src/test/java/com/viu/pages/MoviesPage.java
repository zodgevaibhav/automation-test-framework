package com.viu.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.viu.common.WebDriverUtility;
import com.web.webdriver_factory.WebDriverFactory;

public class MoviesPage {
	@FindBy(xpath="//*[@resource-id='com.vuclip.viu:id/lblListHeader' and @text='Movies']")
	private WebElement moviesPageTitle;

	@FindBy(xpath="//*[@text='Popular Movies For You']")
	private WebElement populorMoviesLable;
	
//	@FindBy(xpath="//*[@text='Popular Movies For You']/following-sibling::com.vuclip.viu.ui.customviews.ViuMultiDirectionalScrollView//android.widget.ImageView[0]")
	@FindBy(xpath="//*[@resource-id='com.vuclip.viu:id/iv_thumb'][1]")
	private WebElement firstPopularVideoInList;			
	
	public MoviesPage(){
		PageFactory.initElements(WebDriverFactory.getDriver(), this);
	}
	
	public MoviesPage isPageLoaded(){
		if(WebDriverUtility.waitForPageElement(populorMoviesLable)){
			System.out.println("*************** Successfully navigated to Movies Page");
			return this;
		}else{
			System.out.println("!!!!!!!!!!!!!!! Unable to navigate to Movies Page");
			return null;
		}
	}
	
	public MoviesPage printPageSource(){
		System.out.println(WebDriverFactory.getDriver().getPageSource());
		return this;
	}

	public PlayVideoPage playFirstPopularMovie(){
		firstPopularVideoInList.click();
		return new PlayVideoPage().isPageLoaded();
		
	}

}
