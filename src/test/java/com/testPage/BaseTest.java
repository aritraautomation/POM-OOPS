/**
 * 
 */
package com.testPage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

//import com.crm.qa.base.EventFiringWebDriver;
import com.util.WebEventListener;
import com.myPages.BasePage;
import com.myPages.Page;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author AritraS
 *
 */
public class BaseTest {
	
	WebDriver driver;	
	public Page page;
	public Properties prop;
	
	public EventFiringWebDriver e_driver;
	public WebEventListener eventListener;
	
	public BaseTest() throws IOException{
	try{
		prop = new Properties();
		FileInputStream fis = new FileInputStream("/Automation/POM-OOPS/src/main/java/"
				+ "com/config/config.properties");
		prop.load(fis);
	}catch(FileNotFoundException fe){
		fe.printStackTrace();
	}	
 }	
	
	Logger log = Logger.getLogger(BaseTest.class);
	
	@BeforeMethod
	@Parameters(value={"browser"})
	public void setUpTest(String browser){
		log.info("*********Launching Browser*************");
		
		if(browser.equals("chrome")){
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver();
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("browserName", "chrome");
			try {
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			
		}else if(browser.equals("firefox")){
			WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver();		
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("browserName","firefox");
			try {
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}else{
			System.out.println("No browser is defined in the xml file....");
		}
		
		/*e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;*/
		
		driver.get(prop.getProperty("url"));
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		page = new BasePage(driver);
	}
	
	
	@AfterMethod
	public void tearDown(){
		log.info("**********Ending Browser***********" );
		
		driver.quit();
	}
	
	
	
	

}
