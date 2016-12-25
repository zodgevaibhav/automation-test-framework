package com.viu.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.viu.common.WebDriverUtility;
import com.web.webdriver_factory.WebDriverFactory;

public class HomePage {
	@FindBy(xpath="//*[@resource-id='com.vuclip.viu:id/tv_get_now']")
	private WebElement tvGetItNow;
	
	@FindBy(xpath="//*[@class='android.widget.TextView' and @text='Go for it. Download it here.']")
	private WebElement goForItDownloadPopup;	
	
	@FindBy(xpath="//*[@resource-id='com.vuclip.viu:id/iv_close']")
	private WebElement tvGetItNowClose;
	
	@FindBy(xpath="//*[@resource-id='com.vuclip.viu:id/ivTriangle']")
	private WebElement viuTopTriangleIcon;
	
	
	@FindBy(xpath="//*[@resource-id='com.vuclip.viu:id/iv_search']")
	private WebElement searchIcon;

	@FindBy(xpath="//*[@resource-id='com.vuclip.viu:id/iv_menu']")
	private WebElement menuIcon;	
	
	@FindBy(xpath="//*[@text='Movies' and @resource-id='com.vuclip.viu:id/lblListHeader']")
	//@FindBy(xpath="//*[@text'Mo=vies']")
	private WebElement subMenuMovie;		
	
	public HomePage(){
		PageFactory.initElements(WebDriverFactory.getDriver(), this);
	}
	
	public HomePage isTvGetItNowDiaplaying(){
		if(tvGetItNow.isDisplayed()){
			return this;
		}else{
			return null;
		}
	}
	
	public HomePage closeTvGetItNowPopup(){
		if(tvGetItNowClose.isDisplayed()){
			tvGetItNowClose.click();
			viuTopTriangleIcon.click();
			System.out.println("Promotion popup (GET IT NOW) popup closed");
		}else{
			System.out.println("Promotion popup (GET IT NOW) could not close as it was not visible");
		}
		return this;
	}
	
	public MoviesPage navigateToMoviesPage(){
		menuIcon.click();
		System.out.println("****************** Clicked on MenuIcon");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		subMenuMovie.click();
		System.out.println("****************** Clicked on MovieIcon");		
		return new MoviesPage().isPageLoaded();
	}

	/*public HopePage closeInitialPopups(){
		
	}*/
	
	public HomePage isPageLoaded(){
		if(WebDriverUtility.waitForPageElement(tvGetItNowClose)){
			return this;
		}else{
			return null;
		}
	}
	
	public HomePage printPageSource(){
		System.out.println(WebDriverFactory.getDriver().getPageSource());
		System.out.println(WebDriverFactory.getDriver().getPageSource());
		System.out.println(WebDriverFactory.getDriver().getPageSource());
		System.out.println(WebDriverFactory.getDriver().getPageSource());
		System.out.println(WebDriverFactory.getDriver().getPageSource());
		return this;
	}
	
}
