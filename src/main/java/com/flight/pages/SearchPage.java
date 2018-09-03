	package com.flight.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flight.testbase.TestBase;

public class SearchPage extends TestBase{

	//Block UI Overlay.
	@FindBy(how = How.XPATH, using = "//div[@class='blockUI blockOverlay']")
	WebElement blockui;

	//Flight button.
	@FindBy(how = How.XPATH, using = "//*[@id='MenuNav']/ul/li[1]/a")
	public WebElement flightbutton; 

	//Domestic button.
	@FindBy(how = How.CLASS_NAME, using = "domestic-btn")
	WebElement domesticbutton;

	//International button.
	@FindBy(how = How.CLASS_NAME, using = "international-btn")
	WebElement internationalbutton;

	//From field.
	@FindBy(how = How.XPATH, using = "//*[@id='From']")
	public WebElement frombutton;

	//From Important Airport list.
	@FindBy(how = How.ID, using = "impAirportsUlFrom")
	WebElement impfromairlistul;

	//From Airport list.
	@FindBy(how = How.ID, using = "AirportsUlFrom")
	WebElement airfromlistul;

	//To Field.
	@FindBy(how = How.XPATH, using = "//*[@id='To']")
	WebElement tobutton;	

	//To Important Airport list.
	@FindBy(how = How.ID, using = "im;pAirportsUlTo")
	WebElement imptoairlistul;

	//To Airport list.
	@FindBy(how = How.ID, using = "AirportsUlTo")
	WebElement toairlistul;

	//To Auto-complete list.			
	@FindBy(how = How.ID, using = "ui-id-2")
	WebElement tolistul;

	//From Calendar.
	@FindBy(how = How.ID, using = "departureDateIcon")
	public WebElement fromcal;

	//To Calendar.
	@FindBy(how = How.ID, using = "return_clndr_icon")
	public WebElement tocal;

	@FindBy(how = How.CLASS_NAME, using = "mlti-add")
	public WebElement addmulticity;

	//Next arrow in Calendar
	@FindBy(how = How.XPATH, using = "//*[@title = 'Next']")
	WebElement calnext;

	//Travel Class.
	@FindBy(how = How.XPATH, using = "//*[@id = 'TravelClass']")
	WebElement classlist;

	//Adult List.
	@FindBy(how = How.XPATH, using = "//*[@id = 'Adults']")
	WebElement adtlist;

	//Children List.
	@FindBy(how = How.XPATH, using = "//*[@id = 'Chindren']")
	WebElement chdlist;

	//Infant List.
	@FindBy(how = How.XPATH, using = "//*[@id = 'Infants']")
	WebElement inflist;

	//Advanced Search.
	@FindBy(how = How.CLASS_NAME, using = "advsearchtext")
	public WebElement advancedsearch;

	//Search button.
	@FindBy(how = How.XPATH, using = "//*[@id = 'FlightSearchBtn']")
	public WebElement searchbutton;

	//Please Wait Loading.
	@FindBy(how = How.CLASS_NAME, using = "prs-text")
	public WebElement pleasewaitloading;

	//Travel class Pop-up alert.
	@FindBy(how = How.ID, using = "ui-id-15")
	WebElement travelclasspopup;

	//Pricing Failed Pop-up alert close button.
	@FindBy(how = How.ID, using = "ui-id-16" )
	WebElement pricingfailedpopup;

	//Pricing Failed close button.
	@FindBy(how = How.XPATH, using = ".//button[@title = 'close']")
	WebElement popproceed;

	//Book Button.
	@FindBy(how = How.ID, using = "btmBookNw")
	WebElement bookbutton;

	//Insurance checkbox.
	@FindBy(how = How.ID, using = "chkInsurance")
	public WebElement insurancecheckbox;

	//Terms and conditions.
	@FindBy(how = How.ID, using = "chkInsAgree")
	WebElement termsandconditions;

	//Without Registration.
	@FindBy(how = How.ID, using = "Email")
	WebElement withoutregistration;

	//Continue button.
	@FindBy(how = How.ID, using = "guestButton")
	WebElement continuebutton;

	//Username Already Registered.
	@FindBy(how = How.ID, using = "UserName")
	WebElement username;

	//Password Already Registered.
	@FindBy(how = How.ID, using = "Password")
	WebElement password;

	//Insurance pop-up.
	@FindBy(how = How.ID, using = "ui-id-5")
	WebElement insurancepopup;

	//Login button.
	@FindBy(how = How.XPATH, using = "//*[@id='loginform']/div[7]/a/span")
	WebElement loginbutton;

	@FindBy(how = How.CLASS_NAME, using = "stop-details")
	WebElement airlinematrixarea;

	//Pax Title.
	@FindBy(how = How.ID, using = "Adults_0__Title")
	WebElement paxtitle;

	//Sector Details for Pax details page
	@FindBy(how = How.XPATH, using = "//*[@class = 'sector-details']")
	WebElement sectordetailspax;

	//Flight Name.
	@FindBy(how = How.XPATH, using = ".//*[@class = 'dspl-flgt-nm']")
	WebElement flightname;

	//Seat select.
	@FindBy(how = How.ID, using = "chkSeatLayout")
	WebElement addseat;

	//Seat Layout.
	@FindBy(how = How.XPATH, using = "//*[@class = 'seat-layout-row']")
	List<WebElement> seatlayout;

	//Onward Seat Select
	@FindBy(how = How.XPATH, using = "//*[@id = 'SLO0']")
	WebElement onwardseatlayout;

	//Onward Seat Select
	@FindBy(how = How.XPATH, using = "//*[@id = 'SLR0']")
	WebElement returnseatlayout;

	public SearchPage() {

		PageFactory.initElements(driver, this);
	}

	public void radiobuttonselector(String element) {

		//One way radio button
		WebElement oneway= driver.findElement(By.xpath("//*[@id = 'cb_oneway']"));
		//Round-trip radio button
		WebElement roundtrip = driver.findElement(By.xpath("//*[@id = 'cb_return']"));
		//Multi-city radio button
		WebElement multicity = driver.findElement(By.xpath("//*[@id = 'cb_multi']"));

		Actions radiobutton = new Actions(driver);
		if(element.equalsIgnoreCase("round")){
			radiobutton.click(roundtrip).perform();
		}else if(element.equalsIgnoreCase("one")){
			radiobutton.click(oneway).perform();
		}else if(element.equalsIgnoreCase("multi")) {
			radiobutton.click(multicity).perform();
		}
	}

	public List<WebElement> impfromsectorselector(){

		List<WebElement> impfromairlist = impfromairlistul.findElements(By.tagName("li"));
		return impfromairlist;
	}

	public List<WebElement> imptosectorselector() {

		List<WebElement> imptoairlist = imptoairlistul.findElements(By.tagName("li"));
		return imptoairlist;
	}

	public List<WebElement> allfromsectorselector() {

		List<WebElement> allfromlist = airfromlistul.findElements(By.tagName("li"));
		return allfromlist;
	}

	public List<WebElement> alltosectorselector() {

		List<WebElement> alltolist = toairlistul.findElements(By.tagName("li"));
		return alltolist;
	}

	public void autofromsectorselector(String fromsearchkey, String fromsector) {

		int src_pos = 0;
		List<WebElement> autofromlist = new ArrayList<WebElement>();
		driver.findElement(By.xpath("//*[@id='From']")).click();
		driver.findElement(By.xpath("//*[@id='From']")).sendKeys(fromsearchkey);
		WebElement fromlistul = driver.findElement(By.id("ui-id-1"));
		autofromlist = fromlistul.findElements(By.tagName("li"));
		for(int i=0; i<autofromlist.size();i++) {
			if(fromsector.startsWith((autofromlist.get(i).getText()))) {
				src_pos = i;
				WebElement element = autofromlist.get(i);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			}
		}

		Actions scroll = new Actions(driver);
		scroll.moveToElement(autofromlist.get(src_pos)).click().build().perform();
	}

	public void autotosectorselector(String tosearchkey, String tosector) {

		int src_pos = 0;
		List<WebElement> autotolist = new ArrayList<WebElement>();
		driver.findElement(By.xpath("//*[@id='To']")).click();
		driver.findElement(By.xpath("//*[@id='To']")).sendKeys(tosearchkey);
		autotolist = tolistul.findElements(By.tagName("li"));
		for(int i=0; i<autotolist.size();i++) {
			if(tosector.startsWith((autotolist.get(i).getText()))) {
				src_pos = i;
				WebElement element = autotolist.get(i);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			}
		}

		Actions scroll = new Actions(driver);
		scroll.moveToElement(autotolist.get(src_pos)).click().build().perform();
	}

	public void multicityselector(List<String> fromsearchkey, List<String> fromsector, List<String> tosearchkey, List<String> tosector, String typeofselection,List<String> multicitydateipdata, List<String> prevnext, List<String> daytobeselectedipdata) {
		List<WebElement> datelist = null;
		String sectrocheck = null;
		WebDriverWait waitforsector = new WebDriverWait(driver,10);
		if(typeofselection.equals("impairport")) {
			List<WebElement> fromairportlist = impfromsectorselector();
			List<WebElement> toairportlist = imptosectorselector();
			for(int i=0; i<fromsector.size() && i<tosector.size();i++) {
				if(i>1) { 
					addmulticity.click();
					waitforsector.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("multicityfrom"+i+""))));
				}
				driver.findElement(By.id("multicityfrom"+i+"")).click();
				driver.findElement(By.id("multicityfrom"+i)).click();
				driver.findElement(By.id("multicityfrom"+i+"")).clear();
				fromairportlist.get(Integer.parseInt(fromsector.get(i))).click();
				driver.findElement(By.id("multicityto"+i+"")).click();
				driver.findElement(By.id("multicityto"+i+"")).clear();
				toairportlist.get(Integer.parseInt(tosector.get(i))).click();
				datelist = dateselector((Integer.parseInt(multicitydateipdata.get(i))), true, i, (Integer.parseInt(prevnext.get(i))));
				datelist.get(Integer.parseInt(daytobeselectedipdata.get(i))).click();;
			}			
		}else if(typeofselection.equals("allairport")) {
			List<WebElement> fromairportlist = allfromsectorselector();
			List<WebElement> toairportlist = alltosectorselector(); 
			for(int i=0; i<fromsector.size() && i<tosector.size();i++) {
				if(i>1) { 
					addmulticity.click();
					waitforsector.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("multicityfrom"+i+""))));
				}
				driver.findElement(By.id("multicityfrom"+i)).click();
				driver.findElement(By.id("multicityfrom"+i)).click();
				driver.findElement(By.id("multicityfrom"+i)).clear();
				fromairportlist.get(Integer.parseInt(fromsector.get(i))).click();
				driver.findElement(By.id("multicityto"+i)).click();
				driver.findElement(By.id("multicityto"+i)).clear();
				toairportlist.get(Integer.parseInt(tosector.get(i))).click();
				datelist = dateselector((Integer.parseInt(multicitydateipdata.get(i))), true, i, (Integer.parseInt(prevnext.get(i))));
				datelist.get(Integer.parseInt(daytobeselectedipdata.get(i))).click();
			}			
		}else if(typeofselection.equals("autocomplete")) {
			int k=3;
			List<WebElement> autofromlist = new ArrayList<WebElement>();
			List<WebElement> autotolist = new ArrayList<WebElement>();
			for(int i=0,src_pos=0; i<fromsector.size() && i<tosector.size();i++,k++) {
				if(i==0) {
					driver.findElement(By.id("multicityfrom"+i)).click();
					driver.findElement(By.id("multicityfrom"+i)).click();
			}else if(i==1) {
					driver.findElement(By.id("multicityfrom"+i)).click();
					driver.findElement(By.id("multicityfrom"+i)).click();
					try {
						waitforsector.until(ExpectedConditions.textToBePresentInElementValue(By.id("multicityfrom"+i), sectrocheck));
						System.out.println("");
						driver.findElement(By.id("multicityfrom"+i)).clear();
					}catch(NoSuchElementException e) {
						System.out.println("Error");
					}
				}else if(i>1 && i<5) { 
					addmulticity.click();
					driver.findElement(By.id("multicityfrom"+i)).click();
					driver.findElement(By.id("multicityfrom"+i)).click();
					try {
						waitforsector.until(ExpectedConditions.textToBePresentInElementValue(By.id("multicityfrom"+i), sectrocheck));
						driver.findElement(By.id("multicityfrom"+i)).clear();
					}catch(NoSuchElementException e) {
						System.out.println("Error");
					}
				}else if(i>4) {
					try {
						addmulticity.click();
						waitforsector.until(ExpectedConditions.invisibilityOf(addmulticity));
						driver.findElement(By.id("multicityfrom"+i)).click();
						driver.findElement(By.id("multicityfrom"+i)).click();
						try {
							waitforsector.until(ExpectedConditions.textToBePresentInElementValue(By.id("multicityfrom"+i), sectrocheck));
							driver.findElement(By.id("multicityfrom"+i)).clear();
						}catch(NoSuchElementException e) {
							System.out.println("Error");
						}
					}catch(TimeoutException e) {
						System.out.println("Error");
					}
				}
				driver.findElement(By.id("multicityfrom"+i)).sendKeys(fromsearchkey.get(i));
				WebElement fromlistul = driver.findElement(By.id("ui-id-"+k));
				autofromlist = fromlistul.findElements(By.tagName("li"));
				for(int j=0; j<autofromlist.size();j++) {
					if(fromsector.get(i).startsWith((autofromlist.get(j).getText()))) {
						src_pos = j;
						WebElement element = autofromlist.get(j);
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
					}
				}

				Actions scroll = new Actions(driver);
				scroll.moveToElement(autofromlist.get(src_pos)).click().build().perform();

				driver.findElement(By.id("multicityto"+i+"")).click();
				driver.findElement(By.id("multicityto"+i+"")).clear();
				driver.findElement(By.id("multicityto"+i)).sendKeys(tosearchkey.get(i));
				k=k+1;
				WebElement tolistul = driver.findElement(By.id("ui-id-"+k));
				autotolist = tolistul.findElements(By.tagName("li"));
				for(int j=0; j<autotolist.size();j++) {
					if(fromsector.get(i).startsWith((autotolist.get(j).getText()))) {
						src_pos = j;
						WebElement element = autotolist.get(j);
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
					}
				}
				scroll.moveToElement(autotolist.get(src_pos)).click().build().perform();
				sectrocheck = driver.findElement(By.id("multicityto"+i+"")).getText();
				System.out.println(sectrocheck);
				datelist = dateselector((Integer.parseInt(multicitydateipdata.get(i))), true, i, (Integer.parseInt(prevnext.get(i))));
				datelist.get(Integer.parseInt(daytobeselectedipdata.get(i))).click();
			}			
		}
	}

	public List<WebElement> dateselector(int dayasnumber, boolean ismutlicity, int multicitynumber, int prevnext) {
		List<WebElement> datelist;
		JavascriptExecutor e = (JavascriptExecutor)driver;
		if(ismutlicity) {
			if(calnext.isDisplayed()) {
				System.out.println("Date Picker displayed");
				for(int i=0;i<prevnext;i++) {
					e.executeScript("arguments[0].scrollIntoView(true);", calnext);
					calnext.click();
				}
				datelist = driver.findElements(By.linkText(""+dayasnumber+""));
				return datelist;	
			}else {
				System.out.println("Date Picker not displayed");
				driver.findElement(By.id("MultiCityDeparture"+multicitynumber)).click();
				for(int i=0;i<prevnext;i++) {
					e.executeScript("arguments[0].scrollIntoView(true);", calnext);
					calnext.click();
				}
				datelist = driver.findElements(By.linkText(""+dayasnumber+""));
				return datelist;	
			}
		}else {
			datelist = driver.findElements(By.linkText(""+dayasnumber+""));
			return datelist;
		}
	}

	public void travelclassselector(String travelclass) {

		Select classselector = new Select(classlist);
		if(travelclass.equalsIgnoreCase("Economy")){
			classselector.selectByVisibleText("Economy");
		}else if(travelclass.equalsIgnoreCase("Business")){
			classselector.selectByVisibleText("Business");
		}else if(travelclass.equalsIgnoreCase("First")){
			classselector.selectByVisibleText("First");
		}else if(travelclass.equalsIgnoreCase("Premium Economy")){
			classselector.selectByVisibleText("Premium Economy");
		}
	}

	public void paxnoselector(List<String> paxlist) {

		if(!paxlist.get(0).equals("0")) {
			Select adtselector = new Select(adtlist);
			adtselector.selectByValue(paxlist.get(0));
		}
		if(!paxlist.get(1).equals("0")) {
			Select chdselector = new Select(chdlist);
			chdselector.selectByValue(paxlist.get(1));
		}
		if(!paxlist.get(2).equals("0")) {
			Select infselector = new Select(inflist);
			infselector.selectByValue(paxlist.get(2));
		}
	}

	public List<WebElement> onewayflight() {

		WebDriverWait matrixareawait = new WebDriverWait(driver,10);
		matrixareawait.until(ExpectedConditions.invisibilityOf(airlinematrixarea));
		scrolltopopulate();
		WebElement flightlistid = driver.findElement(By.id("flightresult"));
		List<WebElement> flightlist = flightlistid.findElements(By.className("dispylist-main"));
		return flightlist;
	}

	public void onewayflightlistselector(int flightposition) {

		WebElement popupalert = null;
		String popupalerttext = null;
		WebDriverWait matrixareawait = new WebDriverWait(driver,5);
		matrixareawait.until(ExpectedConditions.invisibilityOf(airlinematrixarea));
		scrolltopopulate();
		WebElement flightlistid = driver.findElement(By.id("flightresult"));
		List<WebElement> flightlist = flightlistid.findElements(By.className("dispylist-main"));
		WebElement selectedflight = flightlist.get(flightposition);
		scrollintoview(selectedflight);
		selectedonwardflightname = flightlist.get(flightposition).findElement(By.xpath(".//*[@class = 'dspl-flgt-nm']")).getText();
		System.out.println(selectedonwardflightname);
		flightlist.get(flightposition).findElement(By.xpath(".//div[contains(@onclick, 'selectFlight')]")).click();

		try {
			matrixareawait.until(ExpectedConditions.visibilityOf(travelclasspopup));
			popupalert = travelclasspopup;
			popupalerttext = travelclasspopup.getText();
			System.out.println(popupalerttext);
			if(popupalert.isDisplayed() && (popupalerttext.equals("Pricing failed"))) {
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", popproceed);
				pricingfailed = true;
			}else {
				WebElement travelpopup = driver.findElement(By.className("msgbtn-row-left"));
				WebElement popproceed = travelpopup.findElement(By.className("bookbt"));
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", popproceed);
			}
		}catch (NoSuchElementException e) {
			System.out.println("Unable to locate Pop-up");
		}catch (TimeoutException e) {
			System.out.println("No Alert");
		}
		if(!pricingfailed) {
			try {
				matrixareawait.until(ExpectedConditions.visibilityOf(pricingfailedpopup));
				popupalert = pricingfailedpopup;
				if(popupalert.isDisplayed()) {
					WebElement travelpopup = driver.findElement(By.xpath("//*[@class = 'ui-dialog ui-widget ui-widget-content ui-corner-all ui-front ui-draggable']"));
					List<WebElement> popproceed = travelpopup.findElements(By.xpath(".//button[@title = 'close']"));
					JavascriptExecutor executor = (JavascriptExecutor)driver;
					executor.executeScript("arguments[0].click();", popproceed.get(0));
					pricingfailed = true;
				}
			}catch (NoSuchElementException e) {
				System.out.println("No Alert");
			}catch (TimeoutException e) {
				System.out.println("No Alert");
			}
		}
	}

	public List<WebElement> onwwardflightselector(int flightposition){

		WebElement onwardlist = driver.findElement(By.className("split-left-main"));
		List<WebElement> flightlist = onwardlist.findElements(By.className("split-box"));
		WebElement radioselect = flightlist.get(flightposition).findElement(By.className("rd-box"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", radioselect);
		selectedonwardflightname = flightlist.get(flightposition).findElement(By.xpath(".//*[@class = 'flt-depbt']")).getText();
		System.out.println(selectedonwardflightname);
		return flightlist;
	}

	public List<WebElement> returnflightselector(int flightposition){  

		WebElement returnlist = driver.findElement(By.className("split-right-main"));
		List<WebElement> flightlist = returnlist.findElements(By.className("split-box"));
		WebElement radioselect = flightlist.get(flightposition).findElement(By.className("rd-box"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", radioselect);
		selectedreturnflightname = flightlist.get(flightposition).findElement(By.xpath(".//*[@class = 'flt-depbt']")).getText();
		System.out.println(selectedreturnflightname);
		return flightlist;
	}

	public void bookflight() {
		WebElement popupalert = null;
		String popupalerttext = null;
		WebDriverWait wait = new WebDriverWait(driver, 10);
		bookbutton.click();	
		try {
			wait.until(ExpectedConditions.visibilityOf(travelclasspopup));
			popupalert = travelclasspopup;
			popupalerttext = travelclasspopup.getText();
			System.out.println(popupalerttext);
			if(popupalert.isDisplayed() && (popupalerttext.equals("Pricing failed"))) {
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", popproceed);
				pricingfailed = true;
			}else if(popupalert.isDisplayed() && (popupalerttext.equals("Fare Change"))) {
				System.out.println("Fare Change pop up");
			}else {
				WebElement travelpopup = driver.findElement(By.className("msgbtn-row-left"));
				WebElement popproceed = travelpopup.findElement(By.className("bookbt"));
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", popproceed);
			}
		}catch (NoSuchElementException e) {
			System.out.println("Unable to locate pop-up");
		}catch (TimeoutException e) {
			System.out.println("No Alert");
		}
		if(!pricingfailed) {
			try {
				wait.until(ExpectedConditions.visibilityOf(pricingfailedpopup));
				popupalert = pricingfailedpopup;
				if(popupalert.isDisplayed()) {
					WebElement travelpopup = driver.findElement(By.xpath("//*[@class = 'ui-dialog ui-widget ui-widget-content ui-corner-all ui-front ui-draggable']"));
					List<WebElement> popproceed = travelpopup.findElements(By.xpath(".//button[@title = 'close']"));
					JavascriptExecutor executor = (JavascriptExecutor)driver;
					executor.executeScript("arguments[0].click();", popproceed.get(0));
					pricingfailed = true;
				}
			}catch (NoSuchElementException e) {
				System.out.println("No Alert");
			}catch (TimeoutException e) {
				System.out.println("No Alert");
			}
		}
	}

	public void proceedtopayment(String typeofproceed, String email, String pssword) {

		WebDriverWait popuphandler = new WebDriverWait(driver, 10);
		if(typeofproceed.equalsIgnoreCase("Guest")) {
			scrollintoview(withoutregistration);
			withoutregistration.clear();
			withoutregistration.click();
			withoutregistration.sendKeys(email);
			continuebutton.click();
			try {
				popuphandler.until(ExpectedConditions.visibilityOf(insurancepopup));
				if(insurancepopup.isDisplayed()) {
					WebElement insurancepopupokbutton = driver.findElement(By.xpath("//*[@class = 'msgbtn-row-new']"));
					List<WebElement> insurancepopupokbuttonlist = insurancepopupokbutton.findElements(By.xpath("//*[@class = 'bookbt']"));
					JavascriptExecutor executor = (JavascriptExecutor)driver;
					executor.executeScript("arguments[0].click();", insurancepopupokbuttonlist.get(1));
					scrollintoview(termsandconditions);
					termsandconditions.click();
					continuebutton.click();
				}
			}catch(TimeoutException e) {
				System.out.println("No Alert Present");
			}
		}else if(typeofproceed.equalsIgnoreCase("User")) {
			scrollintoview(username);
			username.clear();
			username.click();
			username.sendKeys(email);
			password.clear();
			password.sendKeys(pssword);
			loginbutton.click();
			try {
				popuphandler.until(ExpectedConditions.visibilityOf(insurancepopup));
				if(insurancepopup.isDisplayed()) {
					WebElement insurancepopupokbutton = driver.findElement(By.xpath("//*[@class = 'msgbtn-row-new']"));
					List<WebElement> insurancepopupokbuttonlist = insurancepopupokbutton.findElements(By.xpath("//*[@class = 'bookbt']"));
					JavascriptExecutor executor = (JavascriptExecutor)driver;
					executor.executeScript("arguments[0].click();", insurancepopupokbuttonlist.get(1));
					scrollintoview(termsandconditions);
					termsandconditions.click();
					loginbutton.click();
				}
			}catch(TimeoutException e) {
				System.out.println("No Alert Present");
			}
		}

		WebDriverWait wait = new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.visibilityOf(sectordetailspax));
	}

	public void travellerdetails(List<String> adtpax, String paxtype) {

		int numberofadults = Integer.parseInt(adtpax.get(0));
		String temppaxtype=null;
		if(paxtype.equalsIgnoreCase("Adult")) {
			temppaxtype = "Adults";
		}else if(paxtype.equalsIgnoreCase("Child")) {
			temppaxtype = "Children";
		}else if(paxtype.equalsIgnoreCase("Infant")) {
			temppaxtype = "Infants";
		}

		if(!selectedonwardflightname.startsWith("Spice|SG") && temppaxtype.equalsIgnoreCase("Adults")) {
			for(int i=1,position=0; position<numberofadults; position++) {
				WebElement paxtitle = driver.findElement(By.id(temppaxtype+"_"+position+"__Title"));
				Select titleselector = new Select(paxtitle);
				titleselector.selectByValue(adtpax.get(i));
				i=i+1;
				driver.findElement(By.id(temppaxtype+"_"+position+"__FirstName")).sendKeys(adtpax.get(i));
				i=i+1;
				driver.findElement(By.id(temppaxtype+"_"+position+"__LastName")).sendKeys(adtpax.get(i));
				i=i+1;
			}
		}else if(!selectedonwardflightname.startsWith("Spice|SG") && !temppaxtype.equalsIgnoreCase("Adults")){
			for(int i=1,position=0; position<numberofadults; position++) {
				WebElement paxtitle = driver.findElement(By.id(temppaxtype+"_"+position+"__Title"));
				Select selector = new Select(paxtitle);
				selector.selectByValue(adtpax.get(i));
				i=i+1;
				driver.findElement(By.id(temppaxtype+"_"+position+"__FirstName")).sendKeys(adtpax.get(i));
				i=i+1;
				driver.findElement(By.id(temppaxtype+"_"+position+"__LastName")).sendKeys(adtpax.get(i));
				i=i+1;
				WebElement paxdayofbirth = driver.findElement(By.id(temppaxtype+"_"+position+"__Day"));
				Select dayofbirthselector = new Select(paxdayofbirth);
				dayofbirthselector.selectByValue(adtpax.get(i));
				i=i+1;
				WebElement paxmonthofbirth = driver.findElement(By.id(temppaxtype+"_"+position+"__Month"));
				Select monthofbirthselector = new Select(paxmonthofbirth);
				monthofbirthselector.selectByValue(adtpax.get(i));
				i=i+1;
				WebElement paxyearofbirth = driver.findElement(By.id(temppaxtype+"_"+position+"__Year"));
				Select yearofbirthselector = new Select(paxyearofbirth);
				yearofbirthselector.selectByValue(adtpax.get(i));
				i=i+1;
			}
		}else {
			for(int i=1,position=0; position<numberofadults; position++) {
				WebElement paxtitle = driver.findElement(By.id(temppaxtype+"_"+position+"__Title"));
				Select selector = new Select(paxtitle);
				selector.selectByValue(adtpax.get(i));
				i=i+1;
				driver.findElement(By.id(temppaxtype+"_"+position+"__FirstName")).sendKeys(adtpax.get(i));
				i=i+1;
				driver.findElement(By.id(temppaxtype+"_"+position+"__LastName")).sendKeys(adtpax.get(i));
				i=i+1;
				WebElement paxdayofbirth = driver.findElement(By.id(temppaxtype+"_"+position+"__Day"));
				Select dayofbirthselector = new Select(paxdayofbirth);
				dayofbirthselector.selectByValue(adtpax.get(i));
				i=i+1;
				WebElement paxmonthofbirth = driver.findElement(By.id(temppaxtype+"_"+position+"__Month"));
				Select monthofbirthselector = new Select(paxmonthofbirth);
				monthofbirthselector.selectByValue(adtpax.get(i));
				i=i+1;
				WebElement paxyearofbirth = driver.findElement(By.id(temppaxtype+"_"+position+"__Year"));
				Select yearofbirthselector = new Select(paxyearofbirth);
				yearofbirthselector.selectByValue(adtpax.get(i));
				i=i+1;
			}
		}
	}

	public List<WebElement> seatlist(){

		WebElement seatlayout = driver.findElement(By.xpath("//*[@class = 'seat-layout-row']"));
		List<WebElement> seatlayoutlist = seatlayout.findElements(By.xpath(".//div[starts-with(@onclick,'SelectSeat')]"));
		return seatlayoutlist;
	}

	public void seatselector(List<String> seatlist, String layouttype) {

		int noofpax;
		WebElement templayout = null;
		String temppaxlistid = null;
		String temppaxlistaddid = null;
		WebDriverWait waitforlayout = new WebDriverWait(driver, 10);
		scrollintoview(addseat);
		if(!addseat.isSelected()) {
			driver.findElement(By.id("chkSeatLayout")).click();
		}
		try {
			waitforlayout.until(ExpectedConditions.invisibilityOf(blockui));
		}catch(TimeoutException e) {
			System.out.println("Error");
		}
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		if (layouttype.equalsIgnoreCase("Onwards")) {
			onwardseatlayout.click();
			templayout = seatlayout.get(0);
			temppaxlistid = "SLPaxnameO0";
			temppaxlistaddid = "SLaddIDO0";
		}else if(layouttype.equalsIgnoreCase("Return")) {
			returnseatlayout.click();
			templayout = seatlayout.get(1);
			temppaxlistid = "SLPaxnameR0";
			temppaxlistaddid = "SLaddIDR0";
		}

		List<WebElement> seatlayoutlist = templayout.findElements(By.xpath(".//div[starts-with(@onclick,'SelectSeat')]"));
		noofpax = Integer.parseInt(seatlist.get(0));
		WebElement selectidentifier = driver.findElement(By.id(temppaxlistid+0));
		executor.executeScript("arguments[0].scrollIntoView(true);", selectidentifier);
		for(int i=0,j=1; i<noofpax; i++,j++) {
			selectidentifier = driver.findElement(By.id(temppaxlistid+i));
			Select paxselector = new Select(selectidentifier);
			paxselector.selectByIndex(1);
			executor.executeScript("arguments[0].scrollIntoView(true);", seatlayoutlist.get(Integer.parseInt(seatlist.get(j))));
			executor.executeScript("arguments[0].click();", seatlayoutlist.get(Integer.parseInt(seatlist.get(j))));
			WebElement addbutton = driver.findElement(By.id(temppaxlistaddid+i));
			scrollintoview(addbutton);
			if(j<noofpax) {
				try {
					waitforlayout.until(ExpectedConditions.visibilityOf(addbutton));
					addbutton.click();
				}catch(TimeoutException e) {
					System.out.println(" ");
				}
			}
		}
	}

	public void scrolltopopulate() {

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		for(int i = 0; i < 10; i++)
			executor.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		for(int i = 0; i < 10; i++)
			executor.executeScript("window.scrollTo(0, 0)");
	}

	public void scrollintoview(WebElement element) {

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", element);
	}

}
