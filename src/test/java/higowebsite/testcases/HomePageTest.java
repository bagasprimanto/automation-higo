package higowebsite.testcases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;

import higowebsite.pageobjects.ContactUsPage;
import higowebsite.pageobjects.WifiAdvertisingPage;

public class HomePageTest extends BaseTest{

	@Test
	public void submitContactHIGOWifiAdvertising() {
		WifiAdvertisingPage wifiAdPage = this.getHomePage().goToWifiAdvertising();
		ContactUsPage contactUs = wifiAdPage.goToContactUs();
		contactUs.sendMessage();
		String successMessage = contactUs.getSuccessMessage();
		Assert.assertTrue(successMessage.equals("Pesan Anda berhasil terkirim."));
	}

}
