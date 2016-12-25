package com.orangehrm.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertTest {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver dr = new FirefoxDriver();
		dr.get("http://127.0.0.1/orangehrm-3.3.1/symfony/web/index.php/auth/login");
		dr.findElement(By.cssSelector("input#txtUsername")).sendKeys("admin");
		dr.findElement(By.id("txtPassword")).sendKeys("admin");
		dr.findElement(By.id("btnLogin")).click();
		
		dr.findElement(By.id("menu_admin_viewAdminModule")).click();
		
		dr.findElement(By.id("ohrmList_chkSelectRecord_4")).click();
		
		dr.findElement(By.id("btnDelete")).click();
		
		dr.findElement(By.xpath("//input[@value='Cancel']")).click();
		
		Thread.sleep(5000);;
		
		dr.switchTo().alert().dismiss();
		
		WebDriverWait wait = new WebDriverWait(dr, 20);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("sdf")));

		Wait<WebDriver> waiting = new FluentWait<WebDriver>( dr )
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring( NoSuchElementException.class ) 
                .ignoring( StaleElementReferenceException.class )
                .ignoring(ElementNotVisibleException.class);
		System.currentTimeMillis();
		
		
		Actions actions = new Actions(dr);
		WebElement mainMenu = dr.findElement(By.linkText("menulink"));
		actions.moveToElement(mainMenu);

		WebElement subMenu = dr.findElement(By.cssSelector("subLinklocator"));
		actions.moveToElement(subMenu).click().build().perform();
		
		actions.keyDown(Keys.DOWN);
		actions.keyDown(Keys.valueOf("A"));
		actions.keyDown(Keys.getKeyFromUnicode('c'));
	}
	
	

}

