package HostPlazaBackOffice;

import static org.junit.Assert.*;
import tajikistanConfiguration.Settingsfields_File;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class BOHost_AccountCreationOnly extends Settingsfields_File {

	@Before
	public void setUp() throws Exception{
	System.setProperty("webdriver.chrome.driver", "E:\\workspace\\fatima_repository\\lib\\chromedriver.exe");
		/*DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
		cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true
		cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);*/
			//ChromeOptions opts =  new ChromeOptions(); poner esta opción cuando se vaya a subir a Git
			//opts.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe"); poner esta opción cuando se vaya a subir a Git
			driver = new ChromeDriver();//opts); poner esta opción cuando se vaya a subir al Git
			driver.manage().window().maximize();	
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void accountCreatoinOnlyInit() throws Exception{
		Thread.sleep(1000);
		accountCreationOnly();
		Thread.sleep(1000);
	}
	
	public static void accountCreationOnly() throws Exception{
		Actions action = new Actions(driver);	
		borrarArchivosTemp("E:\\workspace\\Fatima_Repository\\BOHost_accountCreation\\attachments\\");
		try{
			driver.get(BoHostUrl);
			takeScreenShot("E:\\Selenium\\","loginBOTajPage"+timet+".jpg");
			takeScreenShot("E:\\workspace\\Fatima_Repository\\BOHost_crearOperadores\\attachments\\","loginBOTajPage.jpg");
			loginPage("00001","00001");
			takeScreenShot("E:\\Selenium\\","homeBOTajPage"+timet+".jpg");
			takeScreenShot("E:\\workspace\\Fatima_Repository\\BOHost_crearOperadores\\attachments\\","homeBOTajPage.jpg");
			BOVersion = driver.findElement(By.id("ctl00_statusRight")).getText();
			Thread.sleep(2000);			
			action.moveToElement(driver.findElement(By.linkText("Customer service"))).build().perform();
			Thread.sleep(1000);
			action.moveToElement(driver.findElement(By.linkText("Create account"))).build().perform();
			Thread.sleep(1000);
			int selaccount = ranNumbr(0,1);
			if (selaccount == 0){
				driver.findElement(By.linkText("Individual")).click();
			}else{
				

				action.clickAndHold(driver.findElement(By.linkText("Company"))).build().perform();				
				selaccount = ranNumbr(0,1);
				if (selaccount==0){
					driver.findElement(By.linkText("Prepayment")).click();
				}else{
					driver.findElement(By.linkText("Exempt")).click();
				}
			}
			Thread.sleep(3000);
		}catch (Exception e){
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}
	
	@After
	public void tearDown() throws Exception{			  
		    driver.quit();
		    String verificationErrorString = verificationErrors.toString();
		    if (!"".equals(verificationErrorString)) {
		      fail(verificationErrorString);
		    }
	}

}