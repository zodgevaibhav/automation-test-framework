package com.viu.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.viu.common.WebDriverUtility;
import com.web.webdriver_factory.WebDriverFactory;

public class VideoPlayerPage {

	@FindBy(xpath = "//*[@resource-id='com.vuclip.viu:id/video_player_play_pause_btn']")
	private WebElement playPauseButton;

	@FindBy(xpath = "//*[@resource-id='com.vuclip.viu:id/error_textview']")
	private WebElement errorTextView;

	@FindBy(xpath = "//*[@resource-id='com.vuclip.viu:id/video_view']")
	private WebElement videoView;
	
	@FindBy(xpath = "//*[@resource-id='com.vuclip.viu:id/video_player_fwd_seek_btn']")
	private WebElement seekForwardButton;	

	@FindBy(xpath = "//android.widget.Button[@content-desc='Skip Ad']")
	private WebElement skipAddButton;

	public VideoPlayerPage() {
		PageFactory.initElements(WebDriverFactory.getDriver(), this);
	}

	public VideoPlayerPage pauseVideo() {
		videoView.click();
		playPauseButton.click();
		return this;
	}

	public VideoPlayerPage isPageLoaded() {
		skipAddIfFound();
		if (WebDriverUtility.waitForPageElement(videoView)) {
			return this;
		} else {
			return null;
		}
	}

	public VideoPlayerPage printPageSource() {
		System.out.println(WebDriverFactory.getDriver().getPageSource());
		return this;
	}

	public VideoPlayerPage skipAddIfFound(){
			if(WebDriverUtility.waitForPageElement(skipAddButton,1)) {
				skipAddButton.click();
			}else{
			System.out
					.println("!!!!!!!! Skip add button not found");
			}
		return this;
	}
	
	
	public VideoPlayerPage verifyVideoPaused(){
		if(WebDriverUtility.waitForPageElement(playPauseButton)){
			System.out.println("****************** Video paused successfully");
			Assert.assertTrue(true, "Video paused successfully.");
		}else{
			System.out.println("!!!!!!!! Unable to paused video.");
			Assert.assertTrue(false, "Unable to paused video.");
		}
		return this;
	}
	
	public VideoPlayerPage verifySeekForwardButtonDisplay(){
		if(WebDriverUtility.waitForPageElement(seekForwardButton)){
			System.out.println("***************** Video Seek forward successfully");
			Assert.assertTrue(true, "Video Seek forward successfully");
		}else{
			System.out.println("!!!!!!!!!!!!!! Video Seek forward not visible");
			Assert.assertTrue(false, "Video Seek forward not visible");
		}
		return this;
	}
}
