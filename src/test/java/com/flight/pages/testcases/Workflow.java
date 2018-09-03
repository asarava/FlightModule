package com.flight.pages.testcases;
import com.flight.pages.SearchPage;
import com.flight.testbase.TestBase;
import com.flight.testdata.TestData;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Workflow extends TestBase{

	SearchPage searchpage;
	TestData testdata;

	//Initializing TestBase
	public Workflow() {
		super();
	}

	@BeforeClass
	public void testdataread() {
		testdata = new TestData();
		journeytypedata = testdata.readinputdata(0, 3);	
		fromsectorsearchkeyipdata = testdata.readinputdata(6, 6);
		fromsectoripdata = testdata.readinputdata(8, 6);
		tosectorsearchkeyipdata = testdata.readinputdata(7, 6);
		tosectoripdata = testdata.readinputdata(9, 6);
		fromdayipdata = testdata.readinputdata(4, 1);
		todayipdata = testdata.readinputdata(5, 1);
		prevnxtipdata = testdata.readinputdata(17, 7);
		multicitydateipdata = testdata.readinputdata(18, 6);
		daytobeselectedipdata = testdata.readinputdata(19, 6);
		travelclassipdata = testdata.readinputdata(10, 1);
		paxnoipdata = testdata.readinputdata(11, 3);
		flightdata = testdata.readinputdata(3, 2);
		adtlistipdata = testdata.readinputdata(13, 7);
		chdlistipdata = testdata.readinputdata(14, 7);
		inflistipdata = testdata.readinputdata(15, 7);
		seatipdata = testdata.readinputdata(16, 3);
		logindetails = testdata.readinputdata(12, 2);
	}

	@BeforeMethod
	public void setup() {
		initialization();
		searchpage = new SearchPage();
	}

	@Test(enabled = false)
	@Parameters({ "flightpresent"})
	public void onewayworkflow(boolean flightpresent) {
		String tempdata = null;
		searchpage.flightbutton.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		searchpage.radiobuttonselector(journeytypedata.get(0));
		searchpage.frombutton.click();
		searchpage.autofromsectorselector(fromsectorsearchkeyipdata.get(0), fromsectoripdata.get(0));
		searchpage.autotosectorselector(tosectorsearchkeyipdata.get(0), tosectoripdata.get(0));
		searchpage.fromcal.click();
		fromdaylist = searchpage.dateselector((Integer.parseInt(fromdayipdata.get(0))), false, 0,(Integer.parseInt(prevnxtipdata.get(0))));
		fromdaylist.get(0).click();
		searchpage.advancedsearch.click();
		searchpage.travelclassselector(travelclassipdata.get(0));
		searchpage.paxnoselector(paxnoipdata);
		searchpage.searchbutton.click();
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.invisibilityOf(searchpage.pleasewaitloading));
		onewayflightlist = searchpage.onewayflight();

		for(int i=0; i<onewayflightlist.size(); i++) {
			tempdata = onewayflightlist.get(i).findElement(By.xpath(".//*[@class = 'dspl-flgt-nm']")).getText();
			if(tempdata.startsWith(flightdata.get(0))){
				flightcount++;
			}
		}

		if(flightcount !=0)
			flightpresent = false;

		System.out.println(flightcount);
		Assert.assertEquals(flightpresent, true);
		searchpage.onewayflightlistselector(4);

		if(!pricingfailed) {
			searchpage.insurancecheckbox.click();
			searchpage.proceedtopayment("User", logindetails.get(0), logindetails.get(1));
			searchpage.travellerdetails(adtlistipdata, "Adult");
			//searchpage.travellerdetails(chdlistipdata, "Child");
			//searchpage.travellerdetails(inflistipdata, "infant");
			searchpage.seatselector(seatipdata,"Onwards");
		}

		driver.quit();
	}

	@Test(enabled = false)
	public void roundtripworkflow() {
		searchpage.flightbutton.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		searchpage.radiobuttonselector(journeytypedata.get(1));
		searchpage.frombutton.click();
		searchpage.autofromsectorselector(fromsectorsearchkeyipdata.get(0), fromsectoripdata.get(0));
		searchpage.autotosectorselector(tosectorsearchkeyipdata.get(0), tosectoripdata.get(0));
		fromdaylist = searchpage.dateselector((Integer.parseInt(fromdayipdata.get(0))), false, 0,(Integer.parseInt(prevnxtipdata.get(0))));
		System.out.println(fromdaylist.get(0).getText());
		fromdaylist.get(0).click();
		todaylist = searchpage.dateselector((Integer.parseInt(todayipdata.get(0))), false, 0, (Integer.parseInt(prevnxtipdata.get(0))));
		todaylist.get(0).click();
		searchpage.advancedsearch.click();
		searchpage.travelclassselector(travelclassipdata.get(0));
		searchpage.paxnoselector(paxnoipdata);
		searchpage.searchbutton.click();
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.invisibilityOf(searchpage.pleasewaitloading));
		onwardflightlist = searchpage.onwwardflightselector(4);
		returnflightlist = searchpage.returnflightselector(5);
		searchpage.bookflight();
		if(!pricingfailed) {
			searchpage.insurancecheckbox.click();
			searchpage.proceedtopayment("User", logindetails.get(0), logindetails.get(1));
			searchpage.travellerdetails(adtlistipdata, "Adult");
			//searchpage.travellerdetails(chdlistipdata, "Child");
			//searchpage.travellerdetails(inflistipdata, "infant");
			searchpage.seatselector(seatipdata,"Onwards");
			searchpage.seatselector(seatipdata, "Return");
		}

		driver.quit();

	}

	@Test
	public void multicityworkflow() {

		searchpage.flightbutton.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		searchpage.radiobuttonselector(journeytypedata.get(2));
		searchpage.multicityselector(fromsectorsearchkeyipdata, fromsectoripdata, tosectorsearchkeyipdata, tosectoripdata, "autocomplete", multicitydateipdata, prevnxtipdata,daytobeselectedipdata);
		searchpage.advancedsearch.click();
		searchpage.travelclassselector(travelclassipdata.get(0));
		searchpage.paxnoselector(paxnoipdata);
		searchpage.searchbutton.click();


	}
}


