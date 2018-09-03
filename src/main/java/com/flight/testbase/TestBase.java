package com.flight.testbase;
import com.flight.utilties.TestUtil;
import com.flight.utilties.WebEventListener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;



public class TestBase {
	
	//Event Listener
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	//For Framework
	public static WebDriver driver;
	public static Properties prop;
	public boolean pricingfailed = false;
	public String selectedonwardflightname = null;
	public String selectedreturnflightname = null;
	
	//Test cases
	public int flightcount = 0;
	//public boolean flightpresent = false; 
	public List<String> journeytypedata = new ArrayList<String>();
	public List<String> fromsectoripdata = new ArrayList<String>();
	public List<String> fromsectorsearchkeyipdata = new ArrayList<String>();
	public List<String> tosectoripdata = new ArrayList<String>();
	public List<String> tosectorsearchkeyipdata = new ArrayList<String>();
	public List<String> fromdayipdata = new ArrayList<String>();
	public List<String> todayipdata = new ArrayList<String>();
	public List<String> multicitydateipdata = new ArrayList<String>();
	public List<String> daytobeselectedipdata = new ArrayList<String>();
	public List<String> prevnxtipdata = new ArrayList<String>();
	public List<String> flightdata = new ArrayList<String>();
	public List<String> travelclassipdata = new ArrayList<String>();
	public List<String> paxnoipdata= new ArrayList<String>();
	public List<String> adtlistipdata = new ArrayList<String>();
	public List<String> chdlistipdata = new ArrayList<String>();
	public List<String> inflistipdata = new ArrayList<String>();
	public List<String> seatipdata = new ArrayList<String>();
	public List<String> logindetails = new ArrayList<String>();
	public List<WebElement> fromsectorlist = new ArrayList<WebElement>();
	public List<WebElement> tosectorlist = new ArrayList<WebElement>();
	public List<WebElement> fromdaylist = new ArrayList<WebElement>();
	public List<WebElement> todaylist = new ArrayList<WebElement>();
	public List<WebElement> onewayflightlist = new ArrayList<WebElement>();
	public List<WebElement> onwardflightlist = new ArrayList<WebElement>();
	public List<WebElement> returnflightlist = new ArrayList<WebElement>();

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\user\\eclipse-workspace\\FlightModule"
					+ "\\src\\main\\java\\com\\flight\\configfile\\flightconfig");
			prop.load(ip);			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		String url = prop.getProperty("URL");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\user\\Desktop\\Selenium\\geckodriver-v0.18.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}

}

