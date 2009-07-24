package nl.rotterdam.rtmf.guc.selenium;

import nl.rotterdam.rtmf.guc.test.RtmfSeleniumUseCaseBase;

public class RTMFIntrekkenUseCaseTest extends RtmfSeleniumUseCaseBase {
	
	public void testRTMFIntrekkenUseCase() throws Exception {
		selenium.open("/main.htm");
		selenium.waitForPageToLoad(PAGE_WAIT_TIMEOUT);
		selenium.click("link=Inzien / Intrekken");
		selenium.waitForPageToLoad(PAGE_WAIT_TIMEOUT);
		selenium.type("meldingkenmerk", "123");
		selenium.click("//input[@value='Ophalen gegevens']");
		selenium.waitForPageToLoad(PAGE_WAIT_TIMEOUT);
		selenium.click("link=123");
		selenium.waitForPageToLoad(PAGE_WAIT_TIMEOUT);
		selenium.click("//input[@value='Intrekken']");
		selenium.waitForPageToLoad(PAGE_WAIT_TIMEOUT);
		selenium.type("Toelichting", "foutje");
		selenium.click("//input[@value='Versturen']");
		selenium.waitForPageToLoad(PAGE_WAIT_TIMEOUT);
		String pattern = "Intrekking is succesvol verstuurd";
		assertTrue("De verwachte melding ontbreekt: '" + pattern + "'", 
				selenium.isTextPresent(pattern));
	}
}
