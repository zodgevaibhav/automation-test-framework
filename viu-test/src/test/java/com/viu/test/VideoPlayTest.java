package com.viu.test;

import org.testng.annotations.Test;

import com.viu.pages.HomePage;

public class VideoPlayTest {

	@Test
	public void playVideo() {
		HomePage hp = new HomePage();
		hp.isPageLoaded()
				.closeTvGetItNowPopup()   // if found then close
					.navigateToMoviesPage()
						.playFirstPopularMovie()
								.closeGoForItDownloadTip()
									.playSelectedVideo()
/*										.skipAddIfFound()   //need to understand business logic when skip adds allowed
*/											.pauseVideo()
												.verifyVideoPaused();
								
	}

}
