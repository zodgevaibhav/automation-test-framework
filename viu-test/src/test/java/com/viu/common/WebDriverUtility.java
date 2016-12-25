package com.viu.common;

import org.openqa.selenium.WebElement;

public class WebDriverUtility {
	
	
	public static boolean waitForPageElement(WebElement element, int timeOut){
		return waitForElement(element, timeOut);
	}
	
	public static boolean waitForPageElement(WebElement element){
		return waitForElement(element, 20);
	}
	
	private static boolean waitForElement(WebElement element, int timeOut){

		for(int counter=0;counter<=timeOut;counter++){
			try {	
				//if(searchIcon.isDisplayed() || tvGetItNowClose.isDisplayed() || goForItDownloadPopup.isDisplayed()){
				if(element.isDisplayed()){
					System.out.println("******** Element  found in - "+counter+" seconds **"+element.getText()+" - "+element+"**");
					return true;
				}
				
				}catch (Exception e) {
						try {
							System.out.println("!!!!!!!! Element not found till - "+counter+" seconds **"+element+" - "+element+"**");
							Thread.sleep(1000);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
			}
			return false;

	}

}
