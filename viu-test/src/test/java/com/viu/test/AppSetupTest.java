package com.viu.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.viu.common.AdbOperations;

public class AppSetupTest{
	private String applicationFilePath=System.getProperty("user.dir")+"\\src\\test\\resources\\viu.apk";  //apk file name needs to parameterize maven/jenkins
	
/*	Assumed application is not installed on device
	We can add check for isApplicationInstalled using "adb shell pm list packages" command and check required package is already installed or not"
*/	
	@Test(priority=1)
	public void verifyApplicationInstallationSuccessful(){
		AdbOperations.unInstallApplication("com.vuclip.viu");// if already installed
		String installMessage = AdbOperations.installApplication(applicationFilePath);
		System.out.println("Installation message - "+installMessage);
		Assert.assertEquals(installMessage.contains("Success"),true);
	}
	

	/*	Assumed application is installed on device
	We can add check for isApplicationInstalled using "adb shell pm list packages" command and check required package is already installed or not"
	*/
	@Test(priority=2)
	public void verifyApplicationUnInstallSuccessful(){
		AdbOperations.installApplication(applicationFilePath);//if not installed
		String unInstallMessage = AdbOperations.unInstallApplication("com.vuclip.viu");
		System.out.println("Uninstallation message - "+unInstallMessage);
		Assert.assertEquals(unInstallMessage.contentEquals("Success"), true);
	}
}
